package task;

import task.tariff.Tariff;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Subscriber {
    private String number;
    private Tariff tariff;
    private Set<Call> calls;

    public Subscriber(String number, Tariff tariff) {
        if (tariff == null) {
            throw new IllegalStateException("Tariff must not be null"); // Создастся ли объект??
        }
        this.number = number;
        this.tariff = tariff;
        this.calls = new TreeSet<>(Comparator.comparing(Call::getTimeStart));
    }

    public void addCall(Call call) {
        call.setPrice(tariff.calculateCallCost(call));
        calls.add(call);
    }

    public double calculateTotalCost() {
        return calls.stream().mapToDouble(Call::getPrice).sum() + tariff.getFixedCost();
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

    public void setCalls(Set<Call> calls) {
        this.calls = calls;
    }
}
