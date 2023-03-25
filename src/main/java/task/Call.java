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

    public CallType getCallType() {
        return callType;
    }

    public LocalDateTime getTimeStart() {
        return timeStart;
    }

    public LocalDateTime getTimeEnd() {
        return timeEnd;
    }

    public Duration getDuration() {
        return duration;
    }

    public double getPrice() {
        return price;
    }

    public void setCallType(CallType callType) {
        this.callType = callType;
    }

    public void setTimeStart(LocalDateTime timeStart) {
        this.timeStart = timeStart;
    }

    public void setTimeEnd(LocalDateTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
