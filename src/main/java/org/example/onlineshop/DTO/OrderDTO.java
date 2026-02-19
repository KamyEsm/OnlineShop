package org.example.onlineshop.DTO;

import jakarta.persistence.*;
import org.example.onlineshop.Entity.Employee;
import org.example.onlineshop.Entity.OrderItem;
import org.example.onlineshop.Enum.OrderStatus;

import java.time.LocalDate;
import java.util.List;

public class OrderDTO {

    private LocalDate orderDate;

    private Double totalPrice;

    private OrderStatus orderStatus;

    private List<OrderItemDTO> orderItems;

    private EmployeeDTO user;
}
