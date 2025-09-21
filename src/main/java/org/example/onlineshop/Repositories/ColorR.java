package org.example.onlineshop.Repositories;

import org.example.onlineshop.Entities.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorR extends JpaRepository<Color, Long> {
}
