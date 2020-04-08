package com.KSHRD.springsecurity4.repository;

import com.KSHRD.springsecurity4.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
