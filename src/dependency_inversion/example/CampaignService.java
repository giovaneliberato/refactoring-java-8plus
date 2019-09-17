package dependency_inversion.example;

import dependency_inversion.example.CampaignFactory;
import dependency_inversion.models.Account;
import dependency_inversion.models.AccountRepository;
import dependency_inversion.models.Campaign;
import dependency_inversion.models.Country;
import dependency_inversion.models.Driver;
import dependency_inversion.models.DriversRepository;
import dependency_inversion.models.Message;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CampaignService {

    CampaignFactory campaignFactory;

    private AccountRepository accountRepository;

    private DriversRepository driversRepository;

    public Campaign createCampaignForNewUsers(Country country) {
        var message = new Message("welcome");

        Supplier<List<String>> ids = () ->
                accountRepository.findNewUsersByCountry(country)
                .stream()
                .map(Account::getPushNotificationId)
                .collect(toList());

        return campaignFactory.buildCampaign(ids, message);
    }

    // ...

    public Campaign createCampaignForAllDrivers(Country country) {
        var message = new Message("bonus!");

        Supplier<List<String>> ids = () ->
                driversRepository.findDriversByCountry(country)
                        .stream()
                        .map(Driver::getPushNotificationId)
                        .collect(toList());

        return campaignFactory.buildCampaign(ids, message);
    }
}
