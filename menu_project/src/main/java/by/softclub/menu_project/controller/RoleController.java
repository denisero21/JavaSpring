package by.softclub.menu_project.controller;

import by.softclub.menu_project.entity.dto.RoleDto;
import by.softclub.menu_project.entity.user.Role;
import by.softclub.menu_project.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("role/add")
    public ResponseEntity<Void> addRole(@RequestBody RoleDto roleDto){
        roleService.addRole(roleDto);
        return ResponseEntity.ok().build();
    }
}
