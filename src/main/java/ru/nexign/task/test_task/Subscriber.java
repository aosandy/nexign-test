package ru.nexign.task.test_task;

import ru.nexign.task.test_task.tariff.Tariff;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Subscriber {
    private final Set<Call> calls;
    private String number;
    private Tariff tariff;

    public Subscriber(String number, Tariff tariff) {
        if (tariff == null) {
            throw new NullPointerException("Tariff is null.");
        }
        this.number = number;
        this.tariff = tariff;
        this.calls = new TreeSet<>(Comparator.comparing(Call::getTimeStart));
    }

    public void appendCall(CallType callType, LocalDateTime timeStart, LocalDateTime timeEnd) {
        Call call = new Call(callType, timeStart, timeEnd);
        call.setCost(tariff.calculateCallCost(call));
        calls.add(call);
    }

    public double calculateTotalCost() {
        return calls.stream().mapToDouble(Call::getCost).sum() + tariff.getFixedCost();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public Set<Call> getCalls() {
        return calls;
    }
}
