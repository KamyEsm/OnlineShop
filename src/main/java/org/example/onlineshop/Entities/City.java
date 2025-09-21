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
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String name;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "Province_Id")
    private Province province;

    @OneToMany(mappedBy = "city")
    private List<Address> addresses;
}
