package inheritance.example;

import inheritance.models.Account;

import java.util.function.Function;

public class AccountToNameConverter {

    public static String convert(Account account) {
        return String.format("%s%s", account.getFirstName(), account.getLastName());
    }

    public static String convertLastFirst(Account account) {
        return String.format("%s %s", account.getLastName(), account.getFirstName());
    }
}
