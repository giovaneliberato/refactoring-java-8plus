package predicates.example;

import predicates.models.Account;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class VoucherPredicates {

    public static BiPredicate<Account, String> containsTag =
            (account, tag)-> account.getTags().contains(tag);

    public static Predicate<Account> IS_NEW =
            (account) -> containsTag.test(account, "new");

    public static Predicate<Account> IS_LOVER =
            (account) -> containsTag.test(account, "lover");

    public static Predicate<Account> IS_VEG =
            (account) -> containsTag.test(account, "veg");

    public static Predicate<Account> IS_PIZZA_LOVER =
            (account) -> containsTag.test(account, "pizza_lover");

    public static Predicate<Account> IS_BURGER_LOVER =
            (account) -> containsTag.test(account, "burger_lover");
}
