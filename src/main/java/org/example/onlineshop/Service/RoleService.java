package org.example.onlineshop.Service;

import lombok.RequiredArgsConstructor;
import org.example.onlineshop.DTO.EmployeeDTOForRecord;
import org.example.onlineshop.DTO.RoleDTO;
import org.example.onlineshop.Entity.Employee;
import org.example.onlineshop.Entity.Role;
import org.example.onlineshop.Exception.DuplicateData;
import org.example.onlineshop.Exception.NotFound;
import org.example.onlineshop.Mapper.RoleMapper;
import org.example.onlineshop.Repository.RoleR;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleService {
    private final EmployeeService employeeService;
    private final RoleR roleRepository;
    private final RoleMapper roleMapper;

    public RoleDTO Add_Role(RoleDTO roleDTO) throws NotFound {
        boolean r = roleRepository.existsByName("ROLE_" + roleDTO.getName());
        if(r)
            throw new DuplicateData("role already exists");

        Role role = roleMapper.toRole(roleDTO);

        List<String> userNameList = roleDTO.getUsernames();
        List<Employee> employees = new ArrayList<>();
        if(!(userNameList == null) && !userNameList.isEmpty()) {
            for (String username : userNameList) {
                EmployeeDTOForRecord employee = employeeService.getEmployeeByUserName(username);
                Employee employee1 = employeeService.addRoleForEmployee(employee.getUsername(), role);
                employees.add(employee1);
            }

        }
        role.setUsers(employees);
        roleRepository.save(role);
        return roleMapper.toRoleDTO(role);
    }

    public List<RoleDTO> getAllRole() {
        List<Role> list = roleRepository.findAll();
        List<RoleDTO> listDTO = new ArrayList<>();
        for (Role role : list) {
            RoleDTO roleDTO = roleMapper.toRoleDTO(role);
            listDTO.add(roleDTO);
        }
        return listDTO;
    }

    public RoleDTO getRoleByName(String name) throws NotFound {
        Role role = roleRepository.findByName("ROLE_" + name);
        if(role == null)
            throw new NotFound("role not found");
        return roleMapper.toRoleDTO(role);
    }


    public void  DeleteRoleByName(String name) throws NotFound {
        name = "ROLE_" + name;
        if(!roleRepository.existsByName(name))
            throw new NotFound("role not found");
        roleRepository.deleteByName(name);
    }

    public void UpdateRoleByName(String name, RoleDTO roleDTO) throws NotFound {
        Role role = roleRepository.findByName(name);
        if(role == null)
            throw new NotFound("role not found");

        if(!role.getName().equals(roleDTO.getName()) && roleRepository.existsByName(roleDTO.getName()))
            throw new DuplicateData("role name already exists");

        role.setName(roleDTO.getName());
        role.setDescription(roleDTO.getDescription());
        //Dirty Checking
    }

}
