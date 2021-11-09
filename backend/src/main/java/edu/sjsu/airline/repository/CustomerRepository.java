package edu.sjsu.airline.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.sjsu.airline.model.Customer;
import edu.sjsu.airline.model.User;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{ 
	
	Optional<User> findByEmail( String email );
	
}
