package by.softclub.menu_project.repository;

import by.softclub.menu_project.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("select r from Role r where r.id in :ids")
    Set<Role> findAllByIds(Set<Long> ids);
}
