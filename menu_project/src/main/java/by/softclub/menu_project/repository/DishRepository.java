package by.softclub.menu_project.repository;

import by.softclub.menu_project.entity.Dish;
import by.softclub.menu_project.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
}
