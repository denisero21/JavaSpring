package by.softclub.menu_project.repository;

import by.softclub.menu_project.entity.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Long> {
    @Query("select r from MenuCategory r where r.id in :ids")
    List<MenuCategory> findAllByIds(List<Long> ids);
}
