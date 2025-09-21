package org.example.onlineshop.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    private String description;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private int entity;

    @OneToMany(mappedBy = "product")
    private List<Comment> comment;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<ProductVariant> productVariant;
}
