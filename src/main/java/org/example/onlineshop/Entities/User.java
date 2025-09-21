package org.example.onlineshop.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String Name;
    @Column(nullable = false)
    private String LastName;
    @Column(nullable = false, unique = true)
    private String PhoneNumber;

    @ManyToOne
    @JoinColumn(name = "role_Id",nullable = false)
    private Role roles;

    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "user")
    private List<Address> addresses;

    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "user")
    private List<Comment> comments;

    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "user")
    private List<Cart> carts;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;


}
