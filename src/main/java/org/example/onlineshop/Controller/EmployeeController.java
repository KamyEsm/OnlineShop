package org.example.onlineshop.Controller;

import org.example.onlineshop.DTO.RegisterEmployeeDTO;
import org.example.onlineshop.Exception.NotCreated;
import org.example.onlineshop.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> Add_Employee(@RequestBody RegisterEmployeeDTO employeeDTO) {
        if(employeeDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        RegisterEmployeeDTO newEmployee = employeeService.registerEmployee(employeeDTO);
        if(newEmployee == null) {
            throw new NotCreated("Employee Not Created");
        }
        else {
            newEmployee.setPassword(null);
            return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
        }
    }


}
