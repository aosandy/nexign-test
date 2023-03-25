package task;

import task.tariff.Tariff;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String CDR_FILE_NAME = "cdr.txt";

    public static void main(String[] args) {
        try {
            URL resource = Main.class.getClassLoader().getResource(CDR_FILE_NAME);
            File cdrFile = Paths.get(resource.toURI()).toFile();

            Map<String, Subscriber> subscribers = parseCdrFileToMap(cdrFile);

            ReportBuilder reportBuilder = new ReportBuilder();
            for (Subscriber subscriber : subscribers.values()) {
                reportBuilder.buildReport(subscriber);
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Subscriber> parseCdrFileToMap(File cdrFile) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(cdrFile)) {
            Map<String, Subscriber> subscribers = new HashMap<>();
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                CallDataRecord cdr = new CallDataRecord(data);

                String number = cdr.getNumber();
                Tariff tariff = Tariff.createByIndex(cdr.getTariffIndex());
                if (!subscribers.containsKey(number)) {
                    subscribers.put(number, new Subscriber(number, tariff));
                }
                Call call = new Call(cdr);
                subscribers.get(number).addCall(call);
            }
            return subscribers;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
