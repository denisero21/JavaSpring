package by.softclub.menu_project.controller;

import by.softclub.menu_project.entity.Restaurant;

import by.softclub.menu_project.entity.dto.RestaurantDto;
import by.softclub.menu_project.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    
    private final RestaurantService restaurantService;

    @PostMapping("/add")
    public ResponseEntity<Void> addRestaurant(@RequestBody RestaurantDto restaurantDto) {
        restaurantService.addRestaurant(restaurantDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getRestaurants();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable("id") Long id) {
        return ResponseEntity.ok(restaurantService.getRestaurant(id));
    }

    @PutMapping("/update/{restId}")
    public ResponseEntity<Restaurant> updateRestaurant(@RequestBody RestaurantDto restaurantDto, @PathVariable Long restId) {
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(restaurantDto, restId);
        return ResponseEntity.ok(updatedRestaurant);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable("id") Long restId) {
        try {
            restaurantService.deleteRestaurant(restId);
            return new ResponseEntity<>("Restaurant with ID " + restId + " has been deleted.", HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("Restaurant with ID " + restId + " not found.", HttpStatus.NOT_FOUND);
        }
    }

}
