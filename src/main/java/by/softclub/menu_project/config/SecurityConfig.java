//package by.softclub.menu_project.config;
//
//
//import by.softclub.menu_project.service.UserDetailsServiceImpl;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//
//@RequiredArgsConstructor
//@EnableWebSecurity
//@EnableMethodSecurity(securedEnabled = true)
//@Configuration
//public class SecurityConfig {
//
//    private final UserDetailsServiceImpl userDetailsServiceImpl;
//
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        return http
////                .csrf(AbstractHttpConfigurer::disable)
////
////                .authorizeHttpRequests((request) -> request
////                    .requestMatchers("/menu_categories/**").hasAuthority("USER_LOGIN")
////                    .requestMatchers("/users/login").permitAll()
////                    .anyRequest().authenticated()
////                )
////
////
////                .build();
////    }
//
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(12);
//    }
////
////    @Bean
////    public AuthenticationManager authenticationManager(){
////        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
////        authenticationProvider.setUserDetailsService(userDetailsServiceImpl);
////        authenticationProvider.setPasswordEncoder(passwordEncoder());
////        return new ProviderManager(authenticationProvider);
////    }
////
//    public void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
//    }
////
////
////
//}