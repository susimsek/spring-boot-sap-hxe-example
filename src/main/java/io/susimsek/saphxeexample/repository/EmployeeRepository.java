package io.susimsek.saphxeexample.repository;

import io.susimsek.saphxeexample.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Boolean existsByEmailIgnoreCase(String email);
}