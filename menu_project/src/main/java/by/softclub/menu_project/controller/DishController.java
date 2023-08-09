package by.softclub.menu_project.controller;

import by.softclub.menu_project.entity.Dish;
import by.softclub.menu_project.entity.dto.DishDto;
import by.softclub.menu_project.service.DishService;
import by.softclub.menu_project.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dishes")
@RequiredArgsConstructor
public class DishController {

    private final DishService dishService;
    private final RestaurantService restaurantService;

    @PostMapping("/add")
    public ResponseEntity<Void> addDish(@RequestBody DishDto dishDto) {
        dishService.add(dishDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/all")
    public List<Dish> getAllDishes(){
        return dishService.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Dish> getDish(@PathVariable("id") Long id){
        return ResponseEntity.ok(dishService.getById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Dish> updateDish(@RequestBody DishDto dishDto, @PathVariable("id") Long id) {
        Dish dish = dishService.update(dishDto, id);
        return ResponseEntity.ok(dish);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDish(@PathVariable("id") Long dishId){
        try {
            dishService.delete(dishId);
            return new ResponseEntity<>("Dish with ID " + dishId + " has been deleted.", HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("Dish with ID " + dishId + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}
