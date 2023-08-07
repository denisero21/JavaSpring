package by.softclub.menu_project.service;

import by.softclub.menu_project.entity.dto.UserDto;
import by.softclub.menu_project.entity.user.Role;
import by.softclub.menu_project.entity.user.User;
import by.softclub.menu_project.repository.RoleRepository;
import by.softclub.menu_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserService{

    private final UserRepository userRepository;
    
    private final RoleRepository roleRepository;

    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;



    public void add(UserDto userDto){
        User newUser = new User();
        BeanUtils.copyProperties(userDto, newUser, "roles", "password");
        newUser.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        Set<Role> roles = roleRepository.findAllByIds(userDto.getRoles());
        newUser.setCreationDate(LocalDateTime.now());
        newUser.setRoles(roles);
        userRepository.save(newUser);
    }

    public User getById(Long id){
        return userRepository.findById(id).orElseThrow(() ->  new RuntimeException("User not found"));
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User update(UserDto userDto, Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        BeanUtils.copyProperties(userDto, user, "roles", "password");
        Set<Role> roles = roleRepository.findAllByIds(userDto.getRoles());
        user.setRoles(roles);
        user.setCreationDate(LocalDateTime.now());
        userRepository.save(user);
        return user;
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }


}
