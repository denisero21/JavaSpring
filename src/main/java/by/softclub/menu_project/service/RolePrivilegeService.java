package by.softclub.menu_project.service;

import by.softclub.menu_project.entity.user.RolePrivilege;
import by.softclub.menu_project.repository.RolePrivilegeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RolePrivilegeService {
    private final RolePrivilegeRepository rolePrivilegeRepository;

    public void addPrivilege(RolePrivilege rolePrivilege){
        rolePrivilegeRepository.save(rolePrivilege);
    }
}
