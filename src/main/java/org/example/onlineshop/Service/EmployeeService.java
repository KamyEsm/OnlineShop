package org.example.onlineshop.Service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.onlineshop.DTO.EmployeeDTO;
import org.example.onlineshop.DTO.EmployeeDTOForRecord;
import org.example.onlineshop.DTO.NameRollDTO;
import org.example.onlineshop.DTO.RegisterEmployeeDTO;
import org.example.onlineshop.Entity.Address;
import org.example.onlineshop.Entity.Employee;
import org.example.onlineshop.Entity.Order;
import org.example.onlineshop.Entity.Role;
import org.example.onlineshop.Enum.RoleName;
import org.example.onlineshop.Exception.DuplicateData;
import org.example.onlineshop.Exception.InsecurePassword;
import org.example.onlineshop.Exception.NotFound;
import org.example.onlineshop.Mapper.EmployeeMapper;
import org.example.onlineshop.Repository.EmployeeR;
import org.example.onlineshop.Repository.RoleR;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final EmployeeR eRepository;
    private final CompromisedPasswordChecker checker;
    private final RoleR rRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterEmployeeDTO registerEmployee(RegisterEmployeeDTO employeeDTO) throws NotFound {

        if(eRepository.existsByUsername(employeeDTO.getUsername()))
            throw new DuplicateData("username already exists");

        if(checker.check(employeeDTO.getPassword()).isCompromised())
            throw new InsecurePassword("The password is simple.");
        employeeDTO.setPassword(passwordEncoder.encode(employeeDTO.getPassword()));

        Employee newEmployee = employeeMapper.toEmployee(employeeDTO);
        Role role = rRepository.findByName(RoleName.ROLE_CUSTOMER.name());
        if(role == null)
            throw new NotFound("Role not found");

        newEmployee.setRole(role);

        eRepository.save(newEmployee);
        return employeeMapper.toRegisterEmployeeDTO(newEmployee);
    }

    public List<EmployeeDTOForRecord> getAllEmployee() throws NotFound {
        List<Employee> list = eRepository.findAll();
        if(list.isEmpty())
            return new ArrayList<EmployeeDTOForRecord>();

        List<EmployeeDTOForRecord> listDTO = new ArrayList<>();


        for (Employee employee : list) {
            EmployeeDTOForRecord employeeDTO = employeeMapper.toEmployeeDTOForRecord(employee);
            listDTO.add(employeeDTO);
        }
        return  listDTO;
    }

    public EmployeeDTOForRecord getEmployeeByUserName(String username) throws NotFound {
        Employee employee = eRepository.findEmployeeByUsername(username);
        if(employee == null)
            throw new NotFound("user not found");
        return employeeMapper.toEmployeeDTOForRecord(employee);
    }

    public void deleteEmployeeByUserName(String username) throws NotFound {
        if(!eRepository.existsByUsername(username))
            throw new NotFound("username not found");
        eRepository.deleteByUsername(username);
    }

    public void updateEmployeeByUserNameMember(String username, RegisterEmployeeDTO employeeDTO) throws NotFound {
        Employee employee = eRepository.findEmployeeByUsername(username);
        if(employee == null)
            throw new NotFound("username not found");

        if(!employee.getUsername().equals(employeeDTO.getUsername()) &&
                eRepository.existsByUsername(employeeDTO.getUsername())) {
            throw new DuplicateData("username already exists");
        }
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee.setUsername(employeeDTO.getUsername());
        if(checker.check(employeeDTO.getPassword()).isCompromised())
            throw new InsecurePassword("The password is simple.");
        employee.setPassword(passwordEncoder.encode(employeeDTO.getPassword()));
    }

    public Employee addRoleForEmployee(String username, Role role) throws NotFound {
        Employee employee = eRepository.findEmployeeByUsername(username);
        if(employee == null)
            throw new NotFound("username not found");
        employee.setRole(role);
        eRepository.save(employee);
        return employee;
    }

    public void change_role(String username, NameRollDTO role) throws NotFound {
        Employee employee = eRepository.findEmployeeByUsername(username);

        String roleName = role.getRoleName();
        roleName = "ROLE_" + roleName;
        Role role1 = rRepository.findByName(roleName);
        if(role1 == null)
            throw new NotFound("Role not found");
        if(employee == null)
            throw new NotFound("username not found");
        employee.setRole(role1);
    }
}
