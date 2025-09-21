package org.example.onlineshop.Repositories;

import org.example.onlineshop.Entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface CartItemR extends JpaRepository<CartItem,Long> {
}
