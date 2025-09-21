package org.example.onlineshop.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "productVariant_Id")
    private ProductVariant productVariant;

    @ManyToOne
    @JoinColumn(name = "Cart_Id")
    private Cart cart;

}
