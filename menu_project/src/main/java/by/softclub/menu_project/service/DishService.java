package by.softclub.menu_project.service;

import by.softclub.menu_project.entity.Dish;
import by.softclub.menu_project.entity.Restaurant;
import by.softclub.menu_project.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {

    private final DishRepository dishRepository;

    @Autowired
    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }


    public Dish addDish(Dish dish) { return dishRepository.save(dish); }


    public List<Dish> getDishes() {
        return (List<Dish>)dishRepository.findAll();
    }

    public Optional<Dish> getDish(Long id) {
        return dishRepository.findById(id);
    }


    public Dish updateDish(Dish dish, Long restId){
        Dish existingDish = null;
        try {
            existingDish = dishRepository.findById(restId)
                    .orElseThrow(ChangeSetPersister.NotFoundException::new);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }

        // Update the fields of the existing restaurant with the new values

        existingDish.setName(dish.getName());
        existingDish.setCost(dish.getCost());
        existingDish.setRestaurant(dish.getRestaurant());

        // Save the updated restaurant
        return dishRepository.save(existingDish);
    }


    public void deleteDish(Long restId) {
        dishRepository.deleteById(restId);
    }
}
