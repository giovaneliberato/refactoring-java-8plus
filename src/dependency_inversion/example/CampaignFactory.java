package dependency_inversion.example;

import dependency_inversion.models.AccountRepository;
import dependency_inversion.models.Campaign;
import dependency_inversion.models.Message;

import java.util.List;
import java.util.function.Supplier;

public class CampaignFactory {

    public Campaign buildCampaign(Supplier<List<String>> idsSupplier, Message message) {
        return Campaign
                .builder()
                .pushNotificationIds(idsSupplier.get())
                .message(message)
                .build();
    }

}
