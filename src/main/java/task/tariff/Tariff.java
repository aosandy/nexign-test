package task.tariff;

import task.Call;

public abstract class Tariff {
    private static final double FIXED_COST = 0.0;

    public static Tariff createByIndex(int index) {
        switch (index) {
            case 3: return new TariffByMinute();
            case 6: return new TariffUnlimited300();
            case 11: return new TariffRegular();
            default: throw new IllegalArgumentException("Invalid tariff index: " + index);
        }
    }

    public double getFixedCost() {
        return FIXED_COST;
    }

    public abstract double calculateCallCost(Call call);
}
