package com.example.object.Repository;

import com.example.object.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
