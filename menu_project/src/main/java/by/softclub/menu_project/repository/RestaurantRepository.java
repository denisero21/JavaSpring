package by.softclub.menu_project.repository;

import by.softclub.menu_project.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Query("select r from Restaurant r where r.id in :ids")
    List<Restaurant> findAllByIds(List<Long> ids);
}
