package task.tariff;

import task.Call;
import task.CallType;

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
        if (totalDuration.toMinutes() < MINUTE_LIMIT) {
            return call.getDuration().toMinutes() * COST_BY_MINUTE;
        } else {
            return tariffByMinute.calculateCallCost(call);
        }
    }
}
