package ru.nexign.task.test_task.tariff;

import ru.nexign.task.test_task.Call;
import ru.nexign.task.test_task.CallType;

import java.time.Duration;

public class TariffUnlimited300 extends Tariff {
    private static final int MINUTE_LIMIT = 300;
    private static final double FIXED_COST = 100.0;
    private static final double COST_BY_MINUTE = 1.0;

    private Duration totalDuration = Duration.ofSeconds(0);

    TariffUnlimited300(int index) {
        super(index);
    }

    @Override
    public double calculateCallCost(Call call) {
        if (call.getCallType() == CallType.INCOMING) {
            return 0.0;
        }
        totalDuration = totalDuration.plus(call.getDuration());
        if (durationToMinutes(totalDuration) <= MINUTE_LIMIT) {
            return 0.0;
        } else {
            return durationToMinutes(call.getDuration()) * COST_BY_MINUTE;
        }
    }

    @Override
    public double getFixedCost() {
        return FIXED_COST;
    }
}
