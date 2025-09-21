package org.example.onlineshop.Repositories;

import org.example.onlineshop.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderR extends JpaRepository<Order, Long> {
}
