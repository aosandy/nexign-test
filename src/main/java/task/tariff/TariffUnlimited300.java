package task.tariff;

import task.Call;

import java.time.Duration;

public class TariffUnlimited300 extends Tariff {
    private static final int MINUTE_LIMIT = 300;
    private static final double FIXED_COST = 100.0;
    private static final double COST_BY_MINUTE = 1.0;

    private Duration totalDuration = Duration.ofSeconds(0);

    @Override
    public double calculateCallCost(Call call) {
        totalDuration = totalDuration.plus(call.getDuration());
        if (totalDuration.toMinutes() < MINUTE_LIMIT) {
            return 0.0;
        } else {
            return call.getDuration().toMinutes() * COST_BY_MINUTE;
        }
    }

    @Override
    public double getFixedCost() {
        return FIXED_COST;
    }
}