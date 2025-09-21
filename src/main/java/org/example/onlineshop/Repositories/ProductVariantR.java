package org.example.onlineshop.Repositories;

import org.example.onlineshop.Entities.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVariantR extends JpaRepository<ProductVariant, Long> {
}
