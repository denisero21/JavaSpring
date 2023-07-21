package by.softclub.menu_project.controller;

import by.softclub.menu_project.entity.Restaurant;
import by.softclub.menu_project.repository.RestaurantRepository;
import by.softclub.menu_project.service.RestaurantServiceImpl;
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

    private final RestaurantRepository restaurantRepository;
    private final RestaurantServiceImpl restaurantService;


    @PostMapping
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant savedRestaurant = restaurantService.addRestaurant(restaurant);
        return ResponseEntity.ok(savedRestaurant);
    }

    @GetMapping("/all")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getRestaurants();
    }

    @GetMapping("/{id}")
    public Optional<Restaurant> getRestaurant(@PathVariable("id") Long id) {
        return restaurantService.getRestaurant(id);
    }

    @PutMapping("/{restId}")
    public ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant restaurant, @PathVariable Long restId) {
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(restaurant, restId);
        return ResponseEntity.ok(updatedRestaurant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable("id") Long restId) {
        try {
            restaurantService.deleteRestaurant(restId);
            return new ResponseEntity<>("Restaurant with ID " + restId + " has been deleted.", HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("Restaurant with ID " + restId + " not found.", HttpStatus.NOT_FOUND);
        }
    }

}
