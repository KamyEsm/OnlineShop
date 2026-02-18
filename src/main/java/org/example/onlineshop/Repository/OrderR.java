package org.example.onlineshop.Repository;

import org.example.onlineshop.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderR extends JpaRepository<Order, Long> {
}
