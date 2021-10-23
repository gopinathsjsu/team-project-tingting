package edu.sjsu.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.sjsu.airline.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> { }