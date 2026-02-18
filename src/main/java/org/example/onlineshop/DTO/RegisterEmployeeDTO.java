package org.example.onlineshop.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.onlineshop.Entity.Address;
import org.example.onlineshop.Entity.Order;
import org.example.onlineshop.Entity.Role;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RegisterEmployeeDTO {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String username;
    private String password;
}
