package task;

import java.time.Duration;
import java.time.LocalDateTime;

public class Call {
    private CallType callType;
    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;
    private Duration duration;
    private double price;

    public Call(CallDataRecord cdr) {
        this.callType = cdr.getCallType();
        this.timeStart = cdr.getTimeStart();
        this.timeEnd = cdr.getTimeEnd();
        this.duration = Duration.between(timeStart, timeEnd);
    }

    public LocalDateTime getTimeStart() {
        return timeStart;
    }

    public Duration getDuration() {
        return duration;
    }
}
