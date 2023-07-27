package by.softclub.menu_project.repository;

import by.softclub.menu_project.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
