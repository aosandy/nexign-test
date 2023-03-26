package task.tariff;

import task.Call;
import task.CallType;

public class TariffByMinute extends Tariff {
    private static final double COST_BY_MINUTE = 1.5;

    TariffByMinute() {
        super(0);
    }

    TariffByMinute(int index) {
        super(index);
    }

    @Override
    public double calculateCallCost(Call call) {
        if (call.getCallType() == CallType.INCOMING) {
            return 0.0;
        }
        return durationToMinutes(call.getDuration()) * COST_BY_MINUTE;
    }
}
