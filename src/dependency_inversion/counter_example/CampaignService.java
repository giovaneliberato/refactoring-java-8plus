package dependency_inversion.counter_example;

import dependency_inversion.models.Account;
import dependency_inversion.models.Campaign;
import dependency_inversion.models.Country;
import dependency_inversion.models.Message;

import java.util.List;

public class CampaignService {

    CampaignFactory campaignFactory;

    public Campaign createCampaignForNewUsers(Country country) {
        var message = new Message("welcome");
        return campaignFactory.buildCampaignForNewUsers(country, message);
    }

    public Campaign createCampaignForAllUsers(Country country) {
        var message = new Message("#lanches");
        return campaignFactory.buildCampaign(country, message);
    }

    public Campaign createCampaignForUsers(List<Account> accounts) {
        var message = new Message("#lanches");
        return campaignFactory.buildCampaign(accounts, message);
    }

    public Campaign createCampaignForAllDrivers(Country country) {
        var message = new Message("bonus!");
        return campaignFactory.buildCampaignForDrivers(country, message);
    }
}
