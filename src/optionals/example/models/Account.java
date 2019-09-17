package optionals.example.models;

import optionals.models.Restaurant;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

public class Account {

    private List<Restaurant> starredRestaurants;

    private List<Restaurant> blockedRestaurants;

    public List<Restaurant> getBlockedRestaurants() {
        return blockedRestaurants != null ?
                blockedRestaurants : emptyList();
    }

    public List<Restaurant> getStarredRestaurants() {
        return starredRestaurants != null ?
                blockedRestaurants : emptyList();
    }
}
