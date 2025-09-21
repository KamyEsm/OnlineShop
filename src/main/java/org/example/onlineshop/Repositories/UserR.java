package org.example.onlineshop.Repositories;

import org.example.onlineshop.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserR extends JpaRepository<User, Long> {
}
