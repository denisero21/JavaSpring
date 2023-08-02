package by.softclub.menu_project.repository;

import by.softclub.menu_project.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select r from Order r where r.id in :ids")
    List<Order> findAllByIds(List<Long> ids);
}
