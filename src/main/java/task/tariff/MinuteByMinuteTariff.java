package task.tariff;

import task.Call;

public class MinuteByMinuteTariff extends Tariff {
    @Override
    public double handleCall(Call call) {
        return 0;
    }
}
