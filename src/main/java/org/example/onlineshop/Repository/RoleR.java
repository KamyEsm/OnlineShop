package org.example.onlineshop.Repository;

import org.example.onlineshop.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleR extends JpaRepository<Role, Long> {

    Role findByName(String name);

    boolean existsByName(String roleName);

    void deleteByName(String name);
}
