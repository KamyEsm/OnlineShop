package org.example.onlineshop.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

//    @ManyToOne
//    @JoinColumn(name = "subcategories")
//    private Category parentCategory;
//
//    @OneToMany(mappedBy = "parentCate")
//    private List<Category> subcategories;
}
