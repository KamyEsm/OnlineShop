package org.example.onlineshop.Mapper;

import org.example.onlineshop.DTO.RegisterEmployeeDTO;
import org.example.onlineshop.Entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public RegisterEmployeeDTO toRegisterEmployeeDTO(Employee employee) {
        return new RegisterEmployeeDTO(
            employee.getFirstName(),
            employee.getLastName(),
            employee.getPhoneNumber(),
            employee.getUsername(),
            employee.getPassword()
        );
    }

    public Employee toEmployee(RegisterEmployeeDTO registerEmployeeDTO) {
        return new Employee(
            registerEmployeeDTO.getFirstName(),
            registerEmployeeDTO.getLastName(),
            registerEmployeeDTO.getPhoneNumber(),
            registerEmployeeDTO.getUsername(),
            registerEmployeeDTO.getPassword()
        );
    }
}