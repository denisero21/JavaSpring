package by.softclub.menu_project.service;

import by.softclub.menu_project.entity.Restaurant;
import by.softclub.menu_project.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getRestaurants() {
        return (List<Restaurant>)restaurantRepository.findAll();
    }

    public Optional<Restaurant> getRestaurant(Long id) {
        return restaurantRepository.findById(id);
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
        existingRestaurant.setDishes(restaurant.getDishes());

        // Save the updated restaurant
        return restaurantRepository.save(existingRestaurant);
    }

    @Override
    public void deleteRestaurant(Long restId) {
        restaurantRepository.deleteById(restId);
    }
}
