package optionals.counter_example;

import optionals.counter_example.models.Account;
import optionals.models.Restaurant;
import optionals.models.RestaurantRepository;

import java.util.List;
import java.util.function.Consumer;

import static java.util.stream.Collectors.toList;

public class RestaurantMenuService {

    public List<Restaurant> getRestaurantsForAccount(Account account) {
        var restaurants = RestaurantRepository.getAll();

        if (account.getBlockedRestaurants().isPresent()) {
            var blocked = account.getBlockedRestaurants().get();
            restaurants = restaurants
                    .stream()
                    .filter((r -> blocked.contains(r)))
                    .collect(toList());
        }

        if (account.getStarredRestaurants().isPresent()) {
            restaurants.addAll(account.getStarredRestaurants().get());
        }

        return restaurants;
    }




    public void ignoreMe() {
        // just here for screen shot porpuses
        List<Restaurant> restaurantsForAccount = getRestaurantsForAccount(null);
    }
}
