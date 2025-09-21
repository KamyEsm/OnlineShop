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
public class ProductVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private Double price;
    private String description;
    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "Product_Id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "Color_Id")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "Size_Id")
    private Size size;

    @OneToMany(mappedBy = "productVariant", cascade = CascadeType.REMOVE)
    private List<CartItem> cartItems;

    @OneToMany(mappedBy = "productVariant", cascade = CascadeType.REMOVE)
    private List<OrderItem> orderItems;
}
