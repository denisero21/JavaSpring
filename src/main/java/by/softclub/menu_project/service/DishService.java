package by.softclub.menu_project.service;

import by.softclub.menu_project.entity.Dish;
import by.softclub.menu_project.entity.Restaurant;
import by.softclub.menu_project.entity.dto.DishDto;
import by.softclub.menu_project.repository.DishRepository;
import by.softclub.menu_project.repository.MenuCategoryRepository;
import by.softclub.menu_project.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DishService {

    private final DishRepository dishRepository;
    private final RestaurantRepository restaurantRepository;
    private final MenuCategoryRepository menuCategoryRepository;

    public void addDish(DishDto dishDto) {
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDto, dish, "restaurant", "menuCategory");
        dish.setRestaurant(restaurantRepository.findById(dishDto.getRestaurant())
                .orElseThrow(() -> new RuntimeException("Restaurant not found")));
        dish.setMenuCategory(menuCategoryRepository.findById(dishDto.getMenuCategory())
                .orElseThrow(() -> new RuntimeException("Menu category not found")));
        dishRepository.save(dish);
    }


    public List<Dish> getDishes() {
        return dishRepository.findAll();
    }

    public Dish getDish(Long id) {
        return dishRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dish not found"));
    }

    public Dish updateDish(DishDto dishDto, Long id){
        Dish dish = dishRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dish not found"));
        BeanUtils.copyProperties(dishDto, dish, "restaurant", "menuCategory");
        dish.setRestaurant(restaurantRepository.findById(dishDto.getRestaurant())
                .orElseThrow(() -> new RuntimeException("Restaurant not found")));
        dish.setMenuCategory(menuCategoryRepository.findById(dishDto.getMenuCategory())
                .orElseThrow(() -> new RuntimeException("Menu category not found")));
        dishRepository.save(dish);
        return dish;
    }

    public void deleteDish(Long restId) {
        dishRepository.deleteById(restId);
    }
}
