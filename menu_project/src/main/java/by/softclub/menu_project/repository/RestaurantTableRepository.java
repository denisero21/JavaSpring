package by.softclub.menu_project.repository;

import by.softclub.menu_project.entity.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {
    @Query("select r from RestaurantTable r where r.id in :ids")
    List<RestaurantTable> findAllByIds(List<Long> ids);
}
