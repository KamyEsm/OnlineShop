package org.example.onlineshop.Repositories;

import org.example.onlineshop.Entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityR extends JpaRepository<City, Long> {
}
