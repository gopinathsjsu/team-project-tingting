package edu.sjsu.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.sjsu.airline.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{ }
