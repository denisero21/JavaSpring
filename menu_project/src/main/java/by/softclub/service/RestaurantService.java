package by.softclub.service;

import by.softclub.entity.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant addRestaurant(Restaurant restaurant);

    List<Restaurant> getRestaurants();

    Restaurant updateRestaurant(Restaurant restaurant, Long restId);

    void deleteRestaurant(Long restId);
}
