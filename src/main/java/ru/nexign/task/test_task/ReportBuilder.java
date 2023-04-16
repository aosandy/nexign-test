package ru.nexign.task.test_task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class ReportBuilder {

    private ReportBuilder() {
        throw new IllegalStateException("Utility class");
    }

    public static void buildReport(Subscriber subscriber) throws IOException {
        String reportFolder = "reports";
        String reportFileName = "report_" + subscriber.getNumber() + ".txt";

        File file = new File(String.valueOf(Paths.get(reportFolder, reportFileName)));
        file.createNewFile();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            String header = String.format("| %9s |     %10s      |      %8s       | %8s | %4s  |%n",
                "Call Type", "Start Time", "End Time", "Duration", "Cost");
            String separator = "----------------------------------------------------------------------------\n";
            writer.write(String.format("Tariff index: %02d%n", subscriber.getTariff().getIndex()));
            writer.write(separator);
            writer.write(String.format("Report for phone number %s:%n", subscriber.getNumber()));
            writer.write(separator);
            writer.write(header);
            writer.write(separator);
            for (Call call : subscriber.getCalls()) {
                String callType = String.format("%02d", call.getCallType().getIndex());
                String startTime = call.getTimeStart().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                String endTime = call.getTimeEnd().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                String duration = formatDuration(call.getDuration());
                String cost = String.format("%.2f", call.getCost()).replace(",", ".");
                String row = String.format("|     %2s    | %9s | %19s | %8s |%6.6s |%n",
                    callType, startTime, endTime, duration, cost);
                writer.write(row);
            }
            String totalCost = String.format("%.2f", subscriber.calculateTotalCost()).replace(",", ".");
            String footer = String.format("|%55s|%17.13s |%n", "Total Cost: ", totalCost);
            writer.write(separator);
            writer.write(footer);
            writer.write(separator);
        }
    }

    private static String formatDuration(Duration duration) {
        return String.format("%02d:%02d:%02d",
            duration.toHours(),
            duration.toMinutesPart(),
            duration.toSecondsPart());
    }
}
