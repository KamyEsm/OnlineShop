package org.example.onlineshop.DTO;

import jakarta.persistence.*;
import org.example.onlineshop.Entity.Employee;
import org.example.onlineshop.Entity.Product;

public class CommentDTO {

    private String comment;

    private EmployeeDTO user;

    private ProductDTO product;
}
