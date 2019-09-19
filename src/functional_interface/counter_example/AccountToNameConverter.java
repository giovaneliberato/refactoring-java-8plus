package inheritance.counter_example;

import inheritance.models.Account;

import java.util.function.Function;

public class AccountToNameConverter implements Function<Account, String> {

    @Override
    public String apply(Account account) {
        return String.format("%s %s", account.getFirstName(), account.getLastName());
    }
}
