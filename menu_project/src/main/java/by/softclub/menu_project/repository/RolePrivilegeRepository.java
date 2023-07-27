package by.softclub.menu_project.repository;

import by.softclub.menu_project.entity.user.Role;
import by.softclub.menu_project.entity.user.RolePrivilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface RolePrivilegeRepository extends JpaRepository<RolePrivilege, Long> {
    @Query("select r from RolePrivilege r where r.id in :ids")
    Set<RolePrivilege> findAllByIds(Set<Long> ids);
}
