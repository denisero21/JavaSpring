//package by.softclub.menu_project.service;
//
//import by.softclub.menu_project.entity.user.User;
//import by.softclub.menu_project.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//
//@Service
//@RequiredArgsConstructor
//public class AuthService {
//
//    private final UserRepository userRepository;
//
//    @Autowired
//    private final AuthenticationManager authenticationManager;
//
//    public Authentication findByEmail(String email){
//        User user = userRepository.findByEmail(email);
//
//        if(user == null){
//            throw new RuntimeException("User not found");
//        }
//        else return authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        user.getEmail(),
//                        user.getPassword(),
//                        new ArrayList<>())
//        );
//    }
//}
