package by.softclub.menu_project.controller;

import by.softclub.menu_project.entity.dto.UserDto;
import by.softclub.menu_project.entity.user.User;
import by.softclub.menu_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<Void> addUser(@RequestBody UserDto userDto){
        userService.addUser(userDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.getUser(id));
    }
}
