//package by.softclub.menu_project.controller;
//
//import by.softclub.menu_project.entity.user.User;
//import by.softclub.menu_project.service.AuthService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/users")
//@RequiredArgsConstructor
//public class AuthController {
//
//    @Autowired
//    private final AuthService authService;
//
//    @PostMapping("/login")
//    public ResponseEntity<Authentication> getUser(@RequestBody String email){
//        Authentication user = authService.findByEmail(email);
//        return ResponseEntity.ok(user);
//    }
//}
