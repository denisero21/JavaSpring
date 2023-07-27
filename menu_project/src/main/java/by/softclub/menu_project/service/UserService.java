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

import java.time.LocalDateTime;
import java.util.List;
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
        newUser.setCreationDate(LocalDateTime.now());
        newUser.setRoles(roles);
        userRepository.save(newUser);
    }

    public User getUser(Long id){
        return userRepository.findById(id).orElseThrow(() ->  new RuntimeException("User not found"));
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User updateUser(UserDto userDto, Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        BeanUtils.copyProperties(userDto, user, "roles", "creationDate");
        user.setCreationDate(LocalDateTime.now());
        Set<Role> roles = roleRepository.findAllByIds(userDto.getRoles());
        user.setRoles(roles);
        return user;
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
