package task.tariff;

import task.Call;

public class TariffByMinute extends Tariff {
    private static final double COST_BY_MINUTE = 1.5;

    @Override
    public double calculateCallCost(Call call) {
        return call.getDuration().toMinutes() * COST_BY_MINUTE;
    }
}