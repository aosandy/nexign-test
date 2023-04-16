package ru.nexign.task.test_task;

import java.time.Duration;
import java.time.LocalDateTime;

public class Call {
    private final CallType callType;
    private final LocalDateTime timeStart;
    private final LocalDateTime timeEnd;
    private Duration duration;
    private double cost;

    public Call(CallType callType, LocalDateTime timeStart, LocalDateTime timeEnd) {
        this.callType = callType;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
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

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
