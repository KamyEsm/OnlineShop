package org.example.onlineshop.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.onlineshop.Enum.APIs;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role {

    public Role(String roleName) {
        this.name = roleName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @OneToMany(mappedBy = "role")
    private List<Employee> users;

}
