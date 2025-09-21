package org.example.onlineshop.Repositories;

import org.example.onlineshop.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductR extends JpaRepository<Product, Long> {
}
