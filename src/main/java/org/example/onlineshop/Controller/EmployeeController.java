package org.example.onlineshop.Controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.onlineshop.DTO.*;
import org.example.onlineshop.Exception.NotCreated;
import org.example.onlineshop.Exception.NotFound;
import org.example.onlineshop.Service.EmployeeService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employees")
    public ResponseEntity<RegisterEmployeeDTO> Add_Employee(@RequestBody RegisterEmployeeDTO employeeDTO) throws NotFound {
        RegisterEmployeeDTO newEmployee = employeeService.registerEmployee(employeeDTO);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }


    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTOForRecord>> Get_Employees() throws NotFound {
        List<EmployeeDTOForRecord> members = employeeService.getAllEmployee();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }
    @GetMapping("/employees/{username}")
    public ResponseEntity<EmployeeDTOForRecord> Get_Employee(@PathVariable String username) throws NotFound {
        EmployeeDTOForRecord dtoForRecord = employeeService.getEmployeeByUserName(username);
        return new ResponseEntity<>(dtoForRecord, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{username}")
    public ResponseEntity<?> Delete_Employee(@PathVariable String username) throws NotFound {
        employeeService.deleteEmployeeByUserName(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/employees/{username}")
    public ResponseEntity<?> Update_Employee_By_Member(@PathVariable String username, @RequestBody RegisterEmployeeDTO employeeDTO) throws NotFound {
        employeeService.updateEmployeeByUserNameMember(username, employeeDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/employees/{username}/role")
    public ResponseEntity<?> changeEmployeeRole(@PathVariable String username, @RequestBody NameRollDTO roleName) throws NotFound {
        employeeService.change_role(username, roleName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
