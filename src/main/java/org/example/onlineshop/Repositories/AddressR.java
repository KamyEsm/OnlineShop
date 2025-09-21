package org.example.onlineshop.Repositories;

import org.example.onlineshop.Entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressR extends JpaRepository<Address, Long> {
}
