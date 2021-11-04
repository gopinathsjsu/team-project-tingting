package edu.sjsu.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.sjsu.airline.model.Customer;
import edu.sjsu.airline.model.Login;
import edu.sjsu.airline.service.CustomerService;

@RestController
@RequestMapping( path = "/api/v1/customer" )
public class CustomerController {
	
private final CustomerService customerService;
	
	@Autowired
	public CustomerController( CustomerService customerService ) {
		
		this.customerService = customerService;
		
	}
	
	@GetMapping
	public List<Customer> getCustomers() {
		
		return customerService.getAll();
		
	}
	
	@GetMapping( path = "/{customerId}" )
	public Customer getCustomer( @PathVariable("customerId") Long customerId ) {
		
		return customerService.getByCustomerId( customerId );
		
	}
	
	@PostMapping
	public void addNewCustomer( @RequestBody Customer customer ) {
		
		customerService.addCustomer( customer );
		
	}
	
	@PutMapping
	public void updateCustomer( @RequestBody Customer customer ) {
		
		customerService.updateCustomer( customer );
		
	}
	
	@DeleteMapping( path = "/{customerId}" )
	public void deleteCustomer( @PathVariable("customerId") Long customerId ) {
		
		customerService.deleteCustomer( customerId );
		
	}
	
	@PutMapping( path = "/login" )
	public void assignRouteToFlight( @RequestBody Login login ) {
		
		customerService.authenticateUser( login );
		
	}

}