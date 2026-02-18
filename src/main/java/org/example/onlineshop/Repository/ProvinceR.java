package org.example.onlineshop.Repository;

import org.example.onlineshop.Entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceR extends JpaRepository<Province, Long> {
}
