package task;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CallDataRecord {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    private int callTypeIndex;
    private String number;
    private LocalDateTime dateTimeStart;
    private LocalDateTime dateTimeEnd;
    private int tariffIndex;
    private boolean isInitialized;

    public CallDataRecord() {
        this.isInitialized = false;
    }

    public void setData(String data) throws ParseException {
        int i = 0;
        try {
            String[] arguments = data.split(", ");
            this.callTypeIndex = Integer.parseInt(arguments[i]);
            this.number = arguments[++i];
            this.dateTimeStart = LocalDateTime.parse(arguments[++i], DATE_TIME_FORMATTER);
            this.dateTimeEnd = LocalDateTime.parse(arguments[++i], DATE_TIME_FORMATTER);
            this.tariffIndex = Integer.parseInt(arguments[++i]);
            this.isInitialized = true;
        } catch (RuntimeException e) {
            throw new ParseException("Invalid data format.", i);
        }
    }

    public int getCallTypeIndex() {
        checkIsInitialized();
        return callTypeIndex;
    }

    public String getNumber() {
        checkIsInitialized();
        return number;
    }

    public LocalDateTime getDateTimeStart() {
        checkIsInitialized();
        return dateTimeStart;
    }

    public LocalDateTime getDateTimeEnd() {
        checkIsInitialized();
        return dateTimeEnd;
    }

    public int getTariffIndex() {
        checkIsInitialized();
        return tariffIndex;
    }

    private void checkIsInitialized() {
        if (!isInitialized) {
            throw new IllegalStateException("CallDataRecord has not been initialized with data.");
        }
    }
}
