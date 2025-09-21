package org.example.onlineshop.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private int LicensePlate;
    @Column(nullable = false)
    private int Unit;
    @Column(nullable = false)
    private String PostalCode;

    @ManyToOne
    @JoinColumn(nullable = false,name = "User_Id")
    private User user;

    @ManyToOne
    @JoinColumn(nullable = false,name = "City_Id")
    private City city;
}
