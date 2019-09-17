package inheritance.counter_example;

import inheritance.models.Account;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class AccountService {

    private AccountToNameConverter converter = new AccountToNameConverter();

    public List<String> getEveryonesName(List<Account> accounts) {
        return accounts
                .stream()
                .map(converter)
                .collect(toList());
    }
}
