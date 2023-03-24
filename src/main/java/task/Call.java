package task;

import java.time.LocalDateTime;

public class Call {
    private CallType callType;
    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;
    private double duration;
    private double price;

    public Call(CallDataRecord cdr) {
        this.callType = cdr.getCallType();
        this.timeStart = cdr.getTimeStart();
        this.timeEnd = cdr.getTimeEnd();
    }

    public LocalDateTime getTimeStart() {
        return timeStart;
    }
}
