package org.example.onlineshop.Repository;

import org.example.onlineshop.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryR extends JpaRepository<Category, Long> {
}
