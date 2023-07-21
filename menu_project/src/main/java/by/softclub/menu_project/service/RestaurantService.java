package by.softclub.menu_project.service;

import by.softclub.menu_project.entity.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant addRestaurant(Restaurant restaurant);

    List<Restaurant> getRestaurants();

    Restaurant updateRestaurant(Restaurant restaurant, Long restId);

    void deleteRestaurant(Long restId);
}
