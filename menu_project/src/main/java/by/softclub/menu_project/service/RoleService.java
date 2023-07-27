package by.softclub.menu_project.service;

import by.softclub.menu_project.entity.dto.RoleDto;
import by.softclub.menu_project.entity.user.Role;
import by.softclub.menu_project.entity.user.RolePrivilege;
import by.softclub.menu_project.repository.RolePrivilegeRepository;
import by.softclub.menu_project.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    private final RolePrivilegeRepository rolePrivilegeRepository;


    public void addRole(RoleDto roleDto){

        Role role = new Role();
        role.setCreationDate(LocalDateTime.now());
        BeanUtils.copyProperties(roleDto, role, "rolePrivileges");
        Set<RolePrivilege> privileges = rolePrivilegeRepository.findAllByIds(roleDto.getRolePrivileges());
        role.setRolePrivileges(privileges);
        roleRepository.save(role);
    }
}
