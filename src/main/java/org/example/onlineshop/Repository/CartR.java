package org.example.onlineshop.Repository;

import org.example.onlineshop.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartR extends JpaRepository<Cart, Long> {
}
