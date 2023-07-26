package by.softclub.menu_project.service;

import by.softclub.menu_project.entity.dto.UserDto;
import by.softclub.menu_project.entity.user.Role;
import by.softclub.menu_project.entity.user.User;
import by.softclub.menu_project.repository.RoleRepository;
import by.softclub.menu_project.repository.UserRepository;
import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public void addUser(UserDto userDto){
        User newUser = new User();
        BeanUtils.copyProperties(userDto, newUser, "roles");
        Set<Role> roles = roleRepository.findAllByIds(userDto.getRoles());
        newUser.setRoles(roles);
        userRepository.save(newUser);
    }

    public User getUser(Long id){
        return userRepository.findById(id).orElseThrow(() ->  new RuntimeException("User not found"));
    }
}
