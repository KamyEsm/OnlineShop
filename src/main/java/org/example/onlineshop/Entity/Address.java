package org.example.onlineshop.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Integer licensePlate;

    @Column(nullable = false)
    private Integer unit;

    @Column(nullable = false)
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Employee user;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;
}
