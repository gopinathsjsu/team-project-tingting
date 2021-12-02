package edu.sjsu.airline.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.sjsu.airline.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{ 
	
	Optional<Customer> findByEmail( String email );
	
}