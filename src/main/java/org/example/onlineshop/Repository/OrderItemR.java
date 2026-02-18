package org.example.onlineshop.Repository;

import org.example.onlineshop.Entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemR extends JpaRepository<OrderItem, Long> {
}
