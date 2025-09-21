package org.example.onlineshop.Repositories;

import org.example.onlineshop.Entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeR extends JpaRepository<Size, Long> {
}
