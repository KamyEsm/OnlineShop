package org.example.onlineshop.Repository;

import org.example.onlineshop.Entity.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVariantR extends JpaRepository<ProductVariant, Long> {
}
