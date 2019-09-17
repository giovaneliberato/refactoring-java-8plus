package dependency_inversion.counter_example;

import dependency_inversion.models.Account;
import dependency_inversion.models.AccountRepository;
import dependency_inversion.models.Campaign;
import dependency_inversion.models.Country;
import dependency_inversion.models.Driver;
import dependency_inversion.models.DriversRepository;
import dependency_inversion.models.Message;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class CampaignFactory {

    private AccountRepository accountRepository;

    private DriversRepository driversRepository;


    public Campaign buildCampaignForNewUsers(Country country, Message message) {
        var pushIds = accountRepository
                .findNewUsersByCountry(country)
                .stream()
                .map(Account::getPushNotificationId)
                .collect(toList());

        return Campaign
                .builder()
                .pushNotificationIds(pushIds)
                .message(message)
                .build();
    }

    public Campaign buildCampaign(Country country, Message message) {
        var pushIds = accountRepository
                .findUsersByCountry(country)
                .stream()
                .map(Account::getPushNotificationId)
                .collect(toList());

        return Campaign
                .builder()
                .pushNotificationIds(pushIds)
                .message(message)
                .build();
    }

    public Campaign buildCampaign(List<Account> accounts,Message message) {
        var pushIds = accounts
                .stream()
                .map(Account::getPushNotificationId)
                .collect(toList());

        return Campaign
                .builder()
                .pushNotificationIds(pushIds)
                .message(message)
                .build();
    }

    public Campaign buildCampaignForDrivers(Country country, Message message) {
        var pushIds = driversRepository
                .findDriversByCountry(country)
                .stream()
                .map(Driver::getPushNotificationId)
                .collect(toList());

        return Campaign
                .builder()
                .pushNotificationIds(pushIds)
                .message(message)
                .build();
    }
}
