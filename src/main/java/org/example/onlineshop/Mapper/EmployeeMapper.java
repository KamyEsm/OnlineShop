package org.example.onlineshop.Mapper;

import org.example.onlineshop.DTO.AddressDTO;
import org.example.onlineshop.DTO.EmployeeDTO;
import org.example.onlineshop.DTO.EmployeeDTOForRecord;
import org.example.onlineshop.DTO.RegisterEmployeeDTO;
import org.example.onlineshop.Entity.Address;
import org.example.onlineshop.Entity.Employee;
import org.example.onlineshop.Entity.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public EmployeeDTOForRecord toEmployeeDTOForRecord(Employee employee) {
        List<Address> addressList =  employee.getAddresses();
        List<String> addressRecord = new ArrayList<>();
        for (Address address : addressList) {
            addressRecord.add(address.toString());
        }

        String lastCart = null;
        if(!employee.getCarts().isEmpty())
            lastCart = employee.getCarts().getLast().toString();

        List<String> employeeOrders = new ArrayList<>();
        for (Order order : employee.getOrders()) {
            employeeOrders.add(order.toString());
        }

        EmployeeDTOForRecord employeeDTO = new EmployeeDTOForRecord(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getPhoneNumber(),
                employee.getUsername(),
                employee.getRole().getName(),
                addressRecord,
                lastCart,
                employeeOrders
        );
        return employeeDTO;
    }

}