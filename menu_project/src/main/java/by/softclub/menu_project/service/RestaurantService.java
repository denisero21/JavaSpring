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
    }
}
