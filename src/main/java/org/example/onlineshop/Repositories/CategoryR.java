package org.example.onlineshop.Repositories;

import org.example.onlineshop.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryR extends JpaRepository<Category, Long> {
}
