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
        this.number = number;
        this.tariff = tariff;
        this.calls = new TreeSet<>(Comparator.comparing(Call::getTimeStart));
    }

    public void addCall(Call call) {
        calls.add(call);
    }

    public Set<Call> getCalls() {
        return calls;
    }
}
