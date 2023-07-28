package by.softclub.menu_project.controller;

import by.softclub.menu_project.entity.dto.DishDto;
import by.softclub.menu_project.service.DishService;
import by.softclub.menu_project.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import by.softclub.menu_project.entity.Dish;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dishes")
@RequiredArgsConstructor
public class DishController {

    private final DishService dishService;
    private final RestaurantService restaurantService;

    @PostMapping("/add")
    public ResponseEntity<Void> addDish(@RequestBody DishDto dishDto) {
        dishService.addDish(dishDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/all")
    public List<Dish> getAllDishes(){
        return dishService.getDishes();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Dish> getDish(@PathVariable("id") Long id){
        return ResponseEntity.ok(dishService.getDish(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Dish> updateDish(@RequestBody DishDto dishDto, @PathVariable("id") Long id) {
        Dish dish = dishService.updateDish(dishDto, id);
        return ResponseEntity.ok(dish);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDish(@PathVariable("id") Long dishId){
        try {
            dishService.deleteDish(dishId);
            return new ResponseEntity<>("Dish with ID " + dishId + " has been deleted.", HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("Dish with ID " + dishId + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}
