package org.example.onlineshop.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.onlineshop.Entity.Role;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTOForRecord {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String username;
    private String role;
    private List<String> addresses;
    private String lastCarts;
    private List<String> orders;

}
