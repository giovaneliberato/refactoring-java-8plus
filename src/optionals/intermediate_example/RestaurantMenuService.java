package optionals.intermediate_example;

import optionals.intermediate_example.models.Account;
import optionals.models.Restaurant;
import optionals.models.RestaurantRepository;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class RestaurantMenuService {

    public List<Restaurant> getRestaurantsForAccount(Account account) {
        var restaurants = RestaurantRepository.getAll();

        var blocked = account.getBlockedRestaurants().orElse(emptyList());
        restaurants = restaurants
                .stream()
                .filter((r -> blocked.contains(r)))
                .collect(toList());

        restaurants.addAll(account.getStarredRestaurants().orElse(emptyList()));

        return restaurants;
    }




    public void ignoreMe() {
        // just here for screen shot porpuses
        List<Restaurant> restaurantsForAccount = getRestaurantsForAccount(null);
    }
}
