package org.example.onlineshop.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.onlineshop.Entity.Category;
import org.example.onlineshop.Entity.Comment;
import org.example.onlineshop.Entity.ProductVariant;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {


    private String title;
    private String description;
    private Double price;
    private Integer totalQuantity;
    
    private CategoryDTO category;

    private List<ProductVariantDTO> productVariants;
}
