package org.example.onlineshop.DTO;

import jakarta.persistence.*;
import org.example.onlineshop.Entity.Category;
import org.example.onlineshop.Entity.Comment;
import org.example.onlineshop.Entity.ProductVariant;

import java.util.List;

public class ProductDTO {


    private String title;
    private String description;
    private Double price;
    private Integer totalQuantity;

    private List<CommentDTO> comments;

    private CategoryDTO category;

    private List<ProductVariantDTO> productVariants;
}
