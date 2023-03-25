package task.tariff;

import task.Call;

public abstract class Tariff {
    private static final double FIXED_COST = 0.0;
    private final int index;

    Tariff() {
        this.index = 0;
    }

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

    public abstract double calculateCallCost(Call call);
}
