package by.softclub.menu_project.repository;

import by.softclub.menu_project.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Long> {
    @Query("select r from Dish r where r.id in :ids")
    List<Dish> findAllByIds(List<Long> ids);
}
