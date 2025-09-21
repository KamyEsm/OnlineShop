package org.example.onlineshop.Repositories;

import org.example.onlineshop.Entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemR extends JpaRepository<OrderItem, Long> {
}
