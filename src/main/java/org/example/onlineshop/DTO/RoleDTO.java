package org.example.onlineshop.DTO;

import jakarta.persistence.*;
import org.example.onlineshop.Entity.Employee;

import java.util.List;

public class RoleDTO {
    private String name;
    private String description;
    private List<EmployeeDTO> users;
}
