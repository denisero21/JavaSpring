package by.softclub.menu_project.service;

import by.softclub.menu_project.entity.Dish;
import by.softclub.menu_project.entity.Restaurant;
import by.softclub.menu_project.entity.dto.RestaurantDto;
import by.softclub.menu_project.repository.DishRepository;
import by.softclub.menu_project.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final DishRepository dishRepository;

    public void addRestaurant(RestaurantDto restaurantDto){
        Restaurant restaurant = new Restaurant();
        BeanUtils.copyProperties(restaurantDto, restaurant, "dishes");
        List<Dish> dishes = dishRepository.findAllByIds(restaurantDto.getDishes());
        restaurant.setDishes(dishes);
        restaurantRepository.save(restaurant);
    }

    public Restaurant getRestaurant(Long id){
        return restaurantRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Restaurant nor found"));
    }

    public List<Restaurant> getRestaurants(){
        return restaurantRepository.findAll();
    }

    public Restaurant updateRestaurant(RestaurantDto restaurantDto, Long id){
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Restaurant not found"));
        BeanUtils.copyProperties(restaurantDto, restaurant, "dishes");
        List<Dish> dishes = dishRepository.findAllByIds(restaurantDto.getDishes());
        restaurant.setDishes(dishes);
        restaurantRepository.save(restaurant);
        return restaurant;
    }

    public void deleteRestaurant(Long id){
        restaurantRepository.deleteById(id);
    }
}
