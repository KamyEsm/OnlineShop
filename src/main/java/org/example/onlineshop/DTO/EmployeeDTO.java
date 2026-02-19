package org.example.onlineshop.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.onlineshop.Entity.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String username;
    private Role role;
    private List<AddressDTO> addresses;
    private List<CommentDTO> comments;
    private List<CartDTO> carts;
    private List<OrderDTO> orders;
}
