package org.example.onlineshop.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String comment;


    @ManyToOne
    @JoinColumn(name = "User_Id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Product_Id")
    private Product product;
}
