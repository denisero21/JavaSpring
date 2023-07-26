package by.softclub.menu_project.entity.dto;

import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
public class UserDto {

    private String name;

    private String mail;

    private String password;

    private Set<Long> roles;
}



