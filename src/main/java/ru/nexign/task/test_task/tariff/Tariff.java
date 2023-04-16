package ru.nexign.task.test_task.tariff;

import ru.nexign.task.test_task.Call;

import java.time.Duration;

public abstract class Tariff {
    private static final double FIXED_COST = 0.0;
    private final int index;

    Tariff(int index) {
        this.index = index;
    }

    public static Tariff createByIndex(int index) {
        switch (index) {
            case 3:
                return new TariffByMinute(index);
            case 6:
                return new TariffUnlimited300(index);
            case 11:
                return new TariffRegular(index);
            default:
                throw new IllegalArgumentException("Invalid tariff index: " + index);
        }
    }

    public int getIndex() {
        return index;
    }

    public double getFixedCost() {
        return FIXED_COST;
    }

    long durationToMinutes(Duration duration) {
        return duration.toMinutes() + 1;
    }

    public abstract double calculateCallCost(Call call);
}
