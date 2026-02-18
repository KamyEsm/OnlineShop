package org.example.onlineshop.Repository;

import org.example.onlineshop.Entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityR extends JpaRepository<City, Long> {
}
