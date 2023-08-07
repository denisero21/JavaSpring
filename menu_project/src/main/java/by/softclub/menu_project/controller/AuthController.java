package by.softclub.menu_project.controller;

import by.softclub.menu_project.entity.user.User;
import by.softclub.menu_project.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private final AuthService authService;

    @GetMapping
    public ResponseEntity<Authentication> getUser(@RequestBody String email){
        Authentication user = authService.findByEmail(email);
        return ResponseEntity.ok(user);
    }
}
