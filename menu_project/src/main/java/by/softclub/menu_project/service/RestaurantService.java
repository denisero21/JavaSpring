package by.softclub.menu_project.service;

import by.softclub.menu_project.entity.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    Restaurant addRestaurant(Restaurant restaurant);

    List<Restaurant> getRestaurants();
    Optional<Restaurant> getRestaurant(Long id);

    Restaurant updateRestaurant(Restaurant restaurant, Long restId);

    void deleteRestaurant(Long restId);
}
