package com.example.service;

import com.example.entity.Restaurant;
import com.example.repository.RestaurantRepository;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public class RestaurantServiceImpl implements RestaurantService {
    private RestaurantRepository restaurantRepository;

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getRestaurants() {
        return (List<Restaurant>)restaurantRepository.findAll();
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant, Long restId){
        Restaurant existingRestaurant = null;
        try {
            existingRestaurant = restaurantRepository.findById(restId)
                    .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }

        // Update the fields of the existing restaurant with the new values
        existingRestaurant.setName(restaurant.getName());
        existingRestaurant.setDishesList(restaurant.getDishesList());

        // Save the updated restaurant
        return restaurantRepository.save(existingRestaurant);
    }

    @Override
    public void deleteRestaurant(Long restId) {
        restaurantRepository.deleteById(restId);
    }
}
