//package by.softclub.menu_project.controller;
//
//import by.softclub.menu_project.service.DishService;
//import by.softclub.menu_project.service.RestaurantService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.aop.scope.ScopedProxyUtils;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import by.softclub.menu_project.entity.Dish;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/dishes")
//@RequiredArgsConstructor
//public class DishController {
//
//    private final DishService dishService;
//    private final RestaurantService restaurantService;
//
////    @PostMapping("/add")
////    public ResponseEntity<Dish> addDish(@RequestBody DishDto dish) {
////        Dish newDish = new Dish(
////                restaurantService.getRestaurant(dish.getRestId()).get(),
////                dish.getName(), dish.getCost());
//////        System.out.println(newDish.getName() + "\n" + newDish.getCost() + "\n" + newDish.getRestaurant().getName());
////        dishService.addDish(newDish);
////        return ResponseEntity.ok(newDish);
////    }
//
//    @GetMapping("/all")
//    public List<Dish> getAllDishes(){
//        return dishService.getDishes();
//    }
//
//    @GetMapping("/get/{id}")
//    public Optional<Dish> getDish(@PathVariable("id") Long id){
//        return dishService.getDish(id);
//    }
//
////    @PutMapping("/update/{id}")
////    public ResponseEntity<Dish> updateDish(@RequestBody DishDto dish, @PathVariable("id") Long id) {
////        Dish updDish = new Dish(
////                restaurantService.getRestaurant(dish.getRestId()).get(),
////                dish.getName(), dish.getCost());
////
////        Dish updatedDish = dishService.updateDish(updDish, id);
////        return ResponseEntity.ok(updatedDish);
////    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> deleteDish(@PathVariable("id") Long dishId){
//        try {
//            dishService.deleteDish(dishId);
//            return new ResponseEntity<>("Dish with ID " + dishId + " has been deleted.", HttpStatus.OK);
//        } catch (EmptyResultDataAccessException e) {
//            return new ResponseEntity<>("Dish with ID " + dishId + " not found.", HttpStatus.NOT_FOUND);
//        }
//    }
//}
