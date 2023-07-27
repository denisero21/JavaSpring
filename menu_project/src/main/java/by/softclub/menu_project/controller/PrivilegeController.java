package by.softclub.menu_project.controller;

import by.softclub.menu_project.entity.user.RolePrivilege;
import by.softclub.menu_project.service.RolePrivilegeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/privilege")
public class PrivilegeController {

    private final RolePrivilegeService rolePrivilegeService;

    @PostMapping("/add")
    public ResponseEntity<Void> addRolePrivilege(@RequestBody RolePrivilege rolePrivilege){
        rolePrivilegeService.addPrivilege(rolePrivilege);
        return ResponseEntity.ok().build();
    }
}
