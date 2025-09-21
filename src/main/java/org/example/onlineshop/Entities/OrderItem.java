package org.example.onlineshop.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "ProductVariant_Id")
    private ProductVariant productVariant;

    @ManyToOne
    @JoinColumn(name = "order_Id")
    private Order OrdeR;

}
