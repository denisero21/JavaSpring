package by.softclub.menu_project.repository;

import by.softclub.menu_project.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
