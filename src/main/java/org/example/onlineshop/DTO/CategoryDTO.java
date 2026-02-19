package org.example.onlineshop.DTO;

import jakarta.persistence.*;
import org.example.onlineshop.Entity.Product;

import java.util.List;

public class CategoryDTO {
    private String name;
    private List<ProductDTO> products;
}
