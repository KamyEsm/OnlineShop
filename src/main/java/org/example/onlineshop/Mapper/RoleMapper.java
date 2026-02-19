package org.example.onlineshop.Mapper;

import lombok.RequiredArgsConstructor;
import org.example.onlineshop.DTO.RoleDTO;
import org.example.onlineshop.Entity.Employee;
import org.example.onlineshop.Entity.Role;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RoleMapper {

    private final EmployeeMapper employeeMapper;

    public RoleDTO toRoleDTO(Role role){
        List<String> usernames = new ArrayList<>();
        for (Employee employee : role.getUsers()){
            usernames.add(employee.getUsername());
        }

        return new RoleDTO(
                role.getName(),
                role.getDescription(),
                usernames
        );
    }

    public Role toRole(RoleDTO roleDTO){
        Role role = new Role();
        role.setName("ROLE_" + roleDTO.getName());
        role.setDescription(roleDTO.getDescription());
        return role;
    }
}
