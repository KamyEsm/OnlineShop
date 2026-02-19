package org.example.onlineshop.DTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.onlineshop.Entity.Employee;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {
    @NotBlank
    @Size(min = 2, max = 40)
    private String name;
    @Size(min = 2, max = 40)
    @NotBlank
    private String description;
    private List<String> usernames;
}
