package task;

import task.tariff.Tariff;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.*;

public class Main {
    private static final String CDR_FILE_NAME = "cdr.txt";

    public static void main(String[] args) {
        try {
            URL resource = Main.class.getClassLoader().getResource(CDR_FILE_NAME);
            File cdrFile = Paths.get(resource.toURI()).toFile();

            Collection<Subscriber> subscribers = parseCdrFileToSubsCollection(cdrFile);

            for (Subscriber subscriber : subscribers) {
                ReportBuilder.buildReport(subscriber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Collection<Subscriber> parseCdrFileToSubsCollection(File cdrFile) throws FileNotFoundException, ParseException {
        try (Scanner scanner = new Scanner(cdrFile)) {
            Map<String, Subscriber> subscribers = new HashMap<>();
            CallDataRecord cdr = new CallDataRecord();
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                cdr.setData(data);

                String number = cdr.getNumber();
                Tariff tariff = Tariff.createByIndex(cdr.getTariffIndex());
                if (!subscribers.containsKey(number)) {
                    subscribers.put(number, new Subscriber(number, tariff));
                }

                subscribers.get(number).appendCall(
                    CallType.valueOfIndex(cdr.getCallTypeIndex()),
                    cdr.getDateTimeStart(),
                    cdr.getDateTimeEnd()
                );
            }
            return subscribers.values();
        }
    }
}
