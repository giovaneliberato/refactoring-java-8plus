package optionals.models;

import optionals.models.Restaurant;

import java.util.List;

import static java.util.Collections.singletonList;

public class RestaurantRepository {

    public static List<Restaurant> getAll() {
        return singletonList(new Restaurant());
    }
}
