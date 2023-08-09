package by.softclub.menu_project.config;

import by.softclub.menu_project.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.http.HttpMethod.PUT;

@RequiredArgsConstructor
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConfig{

    private final UserDetailsServiceImpl userDetailsServiceImpl;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((request) -> request
                .requestMatchers(PUT, "/**").hasAuthority("USER_LOGIN")
                .requestMatchers("/**").permitAll()
        );
        http.authenticationManager(authenticationManager());
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public AuthenticationManager authenticationManager(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsServiceImpl);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(authenticationProvider);
    }

    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
    }



}