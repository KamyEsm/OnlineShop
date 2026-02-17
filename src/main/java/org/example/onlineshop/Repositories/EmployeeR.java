package org.example.onlineshop.Repositories;

import org.example.onlineshop.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeR extends JpaRepository<Employee, Long> {
    Employee getByUsername(String username);
}
