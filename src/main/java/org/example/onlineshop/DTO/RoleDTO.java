package org.example.onlineshop.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.onlineshop.Entity.Employee;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {
    private String name;
    private String description;
    private List<String> usernames;
}
