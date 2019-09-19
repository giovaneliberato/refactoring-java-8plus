package inheritance.example;

import inheritance.models.Account;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class AccountService {

    public List<String> getEveryonesName(List<Account> accounts) {
        return accounts
                .stream()
                .map(AccountToNameConverter::convert) // ou
                .collect(toList());
    }

    public List<String> getEveryonesLastNameFirstName(List<Account> accounts) {
        return accounts
                .stream()
                .map(AccountToNameConverter::convertLastFirst)
                .collect(toList());
    }
}
