package org.example.onlineshop.Repositories;

import org.example.onlineshop.Entities.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceR extends JpaRepository<Province, Long> {
}
