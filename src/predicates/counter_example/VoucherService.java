package predicates.counter_example;

import predicates.models.Voucher;
import predicates.models.Account;

public class VoucherService {

    public Voucher getVoucherForAccount(Account account) {

        if (account.getTags().contains("new")) {
            return Voucher.of(15);
        }

        if (account.getTags().contains("lover")) {
            return Voucher.of(20);
        }

        if (account.getTags().contains("veg")
                && account.getTags().contains("new")) {
            return Voucher.of(25);
        }

        if (account.getTags().contains("lover")
                && (account.getTags().contains("pizza_lover")
                    || account.getTags().contains("burger_lover"))) {
            return Voucher.of(35);
        }

        return Voucher.none();
    }

    public void ignoreMe() {
        // just here for screen shot porpuses
        Voucher voucherForAccount = getVoucherForAccount(null);
    }
}
