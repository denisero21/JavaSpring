package by.softclub.menu_project.controller;

import by.softclub.menu_project.entity.Restaurant;
import by.softclub.menu_project.repository.RestaurantRepository;
import by.softclub.menu_project.service.RestaurantServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantServiceImpl restaurantService;


//    @PostMapping("/add")
//    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
//        Restaurant savedRestaurant = restaurantService.addRestaurant(restaurant);
//        return ResponseEntity.ok(savedRestaurant);
//    }

    
    @PostMapping("/addRest")
    public String addRestaurant(@Valid Restaurant rest, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-rest";
        }
        restaurantService.addRestaurant(rest);
        return "redirect:/index";
    }

    @GetMapping
    public String getAllRestaurants(Model model){
        model.addAttribute("restaurants", restaurantService.getRestaurants());
        return "index";
    }

    @GetMapping("/get/{id}")
    public Optional<Restaurant> getRestaurant(@PathVariable("id") Long id) {
        return restaurantService.getRestaurant(id);
    }

    @PutMapping("/update/{id}")
    public String updateRestaurant(@PathVariable("id") Long id, Model model) {
        Restaurant rest = restaurantService.getRestaurant(id)
                .orElseThrow(() -> new IllegalArgumentException("invalid user ID: " + id));

        model.addAttribute("restaurant", rest);
        return "update-user";
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
