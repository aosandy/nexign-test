package task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CallDataRecord {
    private CallType callType;
    private String number;
    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;
    private int tariffIndex;

    CallDataRecord(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String[] arguments = data.split(", ");
        callType = CallType.valueOfIndex(Integer.parseInt(arguments[0]));
        number = arguments[1];
        timeStart = LocalDateTime.parse(arguments[2], formatter);
        timeEnd = LocalDateTime.parse(arguments[3], formatter);
        tariffIndex = Integer.parseInt(arguments[4]);
    }

    public CallType getCallType() {
        return callType;
    }

    public String getNumber() {
        return number;
    }

    public LocalDateTime getTimeStart() {
        return timeStart;
    }

    public LocalDateTime getTimeEnd() {
        return timeEnd;
    }

    public int getTariffIndex() {
        return tariffIndex;
    }
}
