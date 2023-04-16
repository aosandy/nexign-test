package ru.nexign.task.test_task.tariff;

import ru.nexign.task.test_task.Call;
import ru.nexign.task.test_task.CallType;

import java.time.Duration;

public class TariffRegular extends Tariff {
    private static final int MINUTE_LIMIT = 100;
    private static final double COST_BY_MINUTE = 0.5;

    private final Tariff tariffByMinute = new TariffByMinute();
    private Duration totalDuration = Duration.ofSeconds(0);

    TariffRegular(int index) {
        super(index);
    }

    @Override
    public double calculateCallCost(Call call) {
        if (call.getCallType() == CallType.INCOMING) {
            return 0.0;
        }
        totalDuration = totalDuration.plus(call.getDuration());
        if (durationToMinutes(totalDuration) <= MINUTE_LIMIT) {
            return call.getDuration().toMinutes() * COST_BY_MINUTE;
        } else {
            return tariffByMinute.calculateCallCost(call);
        }
    }
}
