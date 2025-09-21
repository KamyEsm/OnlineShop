package org.example.onlineshop.Repositories;

import org.example.onlineshop.Entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartR extends JpaRepository<Cart, Long> {
}
