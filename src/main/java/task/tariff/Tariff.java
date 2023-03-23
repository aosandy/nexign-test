package task.tariff;

import task.Call;

public abstract class Tariff {
    private int index;

    public abstract double handleCall(Call call);
}
