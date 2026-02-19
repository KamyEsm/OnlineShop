package org.example.onlineshop.DTO;

import jakarta.persistence.*;
import org.example.onlineshop.Entity.CartItem;
import org.example.onlineshop.Entity.Employee;

import java.util.List;

public class CartDTO {
    private List<CartItemDTO> cartItems;
    private EmployeeDTO user;
}
