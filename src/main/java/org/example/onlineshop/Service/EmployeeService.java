package org.example.onlineshop.Service;

import org.example.onlineshop.DTO.RegisterEmployeeDTO;
import org.example.onlineshop.Entity.Employee;
import org.example.onlineshop.Entity.Role;
import org.example.onlineshop.Enum.RoleName;
import org.example.onlineshop.Exception.Employee.DuplicateUsername;
import org.example.onlineshop.Exception.Employee.InsecurePassword;
import org.example.onlineshop.Exception.Role.RoleNotFound;
import org.example.onlineshop.Mapper.EmployeeMapper;
import org.example.onlineshop.Repository.EmployeeR;
import org.example.onlineshop.Repository.RoleR;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeMapper employeeMapper;
    private EmployeeR erepository;
    private CompromisedPasswordChecker checker;
    private RoleR rrepository;
    public EmployeeService(EmployeeMapper employeeMapper, EmployeeR repository, CompromisedPasswordChecker checker,RoleR rrepository) {
        this.employeeMapper = employeeMapper;
        this.erepository = repository;
        this.checker = checker;
        this.rrepository = rrepository;
    }

    public RegisterEmployeeDTO registerEmployee(RegisterEmployeeDTO employeeDTO) {

        if(erepository.existsByUsername(employeeDTO.getUsername()))
            throw new DuplicateUsername("username already exists");

        if(checker.check(employeeDTO.getPassword()).isCompromised())
            throw new InsecurePassword("The password is simple.");

        Employee newEmployee = employeeMapper.toEmployee(employeeDTO);
        Role role = rrepository.findByName("Customer");
        if(role == null)
            throw new RoleNotFound("Role not found");

        newEmployee.setRole(role);
        role.getUsers().add(newEmployee);

        erepository.save(newEmployee);
        return employeeMapper.toRegisterEmployeeDTO(newEmployee);
    }

}
