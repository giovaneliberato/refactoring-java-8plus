package optionals.counter_example.models;

import optionals.models.Restaurant;

import java.util.List;
import java.util.Optional;

public class Account {

    private Optional<List<Restaurant>> starredRestaurants;

    private Optional<List<Restaurant>> blockedRestaurants;


    public Optional<List<Restaurant>> getBlockedRestaurants() {
        return blockedRestaurants;
    }

    public Optional<List<Restaurant>> getStarredRestaurants() {
        return starredRestaurants;
    }
}
