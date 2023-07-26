package by.softclub.menu_project.service;

import by.softclub.menu_project.entity.user.Role;
import by.softclub.menu_project.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public void addRole(Role role){
        role.setCreationDate(LocalDateTime.now());
        roleRepository.save(role);
    }
}
