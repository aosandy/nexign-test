package task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;

public class ReportBuilder {

    public void buildReport(Subscriber subscriber) throws IOException {
        String reportFolder = "reports";
        String reportFileName = "report_" + subscriber.getNumber() + ".txt";

        File file = new File(String.valueOf(Paths.get(reportFolder, reportFileName)));
        file.createNewFile();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.append("Report for phone number ").append(subscriber.getNumber());
        }
    }

    private String formatDuration(Duration duration) {
        return String.format("%02d:%02d:%02d",
            duration.toHours(),
            duration.toMinutesPart(),
            duration.toSecondsPart());
    }
}
