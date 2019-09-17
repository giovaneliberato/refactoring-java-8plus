package optionals.example;

import optionals.example.models.Account;
import optionals.models.Restaurant;
import optionals.models.RestaurantRepository;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class RestaurantMenuService {

    public List<Restaurant> getRestaurantsForAccount(Account account) {
        var restaurantList = RestaurantRepository.getAll();
        var blocked = account.getBlockedRestaurants();
        var starred = account.getStarredRestaurants();

        return Stream.concat(
                starred.stream(),
                restaurantList
                        .stream()
                        .filter((blocked::contains)))
                .collect(toList());
    }




    public void ignoreMe() {
        // just here for screen shot porpuses
        List<Restaurant> restaurantsForAccount = getRestaurantsForAccount(null);
    }
}
