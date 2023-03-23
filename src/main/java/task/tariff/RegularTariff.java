package task.tariff;

import task.Call;

public class RegularTariff extends Tariff {
    @Override
    public double handleCall(Call call) {
        return 0;
    }
}
