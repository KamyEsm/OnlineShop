package org.example.onlineshop.Repository;

import org.example.onlineshop.Entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface CartItemR extends JpaRepository<CartItem,Long> {
}
