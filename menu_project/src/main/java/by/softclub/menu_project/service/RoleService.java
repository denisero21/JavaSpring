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
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    private final RolePrivilegeRepository rolePrivilegeRepository;


    public void addRole(RoleDto roleDto){
        Role role = new Role();
        BeanUtils.copyProperties(roleDto, role, "rolePrivileges");
        Set<RolePrivilege> privileges = rolePrivilegeRepository.findAllByIds(roleDto.getRolePrivileges());
        role.setRolePrivileges(privileges);
        roleRepository.save(role);
    }

    public Role getRole(Long id){
        return roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
    }

    public List<Role> getRoles(){
        return roleRepository.findAll();
    }

    public Role updateRole(RoleDto roleDto, Long id){
        Role role = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
        BeanUtils.copyProperties(roleDto, role, "rolePrivileges");
        Set<RolePrivilege> privileges = rolePrivilegeRepository.findAllByIds(roleDto.getRolePrivileges());
        role.setRolePrivileges(privileges);
        roleRepository.save(role);
        return role;
    }

    public void deleteRole(Long id){
        roleRepository.deleteById(id);
    }
}
