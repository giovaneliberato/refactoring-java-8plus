package dependency_inversion.models;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;

public class AccountRepository {
    public List<Account> findNewUsersByCountry(Country country) {
        return emptyList();
    }

    public List<Account> findUsersByCountry(Country country) {
        return emptyList();
    }
}
