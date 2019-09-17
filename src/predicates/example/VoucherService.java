package predicates.example;

import predicates.models.Account;
import predicates.models.Voucher;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import static predicates.example.VoucherPredicates.IS_BURGER_LOVER;
import static predicates.example.VoucherPredicates.IS_LOVER;
import static predicates.example.VoucherPredicates.IS_NEW;
import static predicates.example.VoucherPredicates.IS_PIZZA_LOVER;
import static predicates.example.VoucherPredicates.IS_VEG;

public class VoucherService {

    public Voucher getVoucherForAccount(Account account) {
        if (IS_NEW.test(account)) {
            return Voucher.of(15);
        }

        if (IS_LOVER.test(account)) {
            return Voucher.of(20);
        }

        if (IS_VEG.and(IS_NEW).test(account)) {
            return Voucher.of(25);
        }

        if (IS_LOVER.and(IS_PIZZA_LOVER.or(IS_BURGER_LOVER)).test(account)) {
            return Voucher.of(35);
        }

        return Voucher.none();
    }





    public void ignoreMe() {
        // just here for screen shot porpuses
        Voucher voucherForAccount = getVoucherForAccount(null);
    }
}
