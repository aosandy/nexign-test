package task;

import task.tariff.MinuteByMinuteTariff;
import task.tariff.RegularTariff;
import task.tariff.Tariff;
import task.tariff.UnlimitedTariff;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String cdrName = "cdr.txt";
            ClassLoader classLoader = Main.class.getClassLoader();
            URL resource = classLoader.getResource(cdrName);
            Scanner scanner = new Scanner(new File(resource.toURI()));
            Map<String, Subscriber> subscribers = new HashMap<>();

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                CallDataRecord cdr = new CallDataRecord(data);

                String number = cdr.getNumber();
                Tariff tariff = indexToTariff(cdr.getTariffIndex());
                if (!subscribers.containsKey(number)) {
                    subscribers.put(number, new Subscriber(number, tariff));
                }
                Call call = new Call(cdr);
                subscribers.get(number).addCall(call);
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private static Tariff indexToTariff(int index) {
        switch (index) {
            case 3: return new MinuteByMinuteTariff();
            case 6: return new UnlimitedTariff();
            case 11: return new RegularTariff();
            default: throw new IllegalStateException();
        }
    }
}
