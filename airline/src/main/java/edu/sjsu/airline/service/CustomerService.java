package edu.sjsu.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.airline.model.Customer;
import edu.sjsu.airline.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private final CustomerRepository customerRepository;
	
	@Autowired
	public CustomerService( CustomerRepository customerRepository ) {
		
		this.customerRepository =  customerRepository;
		
	}
	
	public List<Customer> getAll( ) {
		
		return customerRepository.findAll();
		
	}
	
	public Customer getByCustomerId( Long customerId ) {
		
		checkCustomerCode( customerId );
		
		return customerRepository.findById( customerId ).get();
		
	}
	
	public void addCustomer( Customer newCustomer ) {
		
		customerRepository.save(newCustomer);
		
	}
	
	public void updateCustomer( Customer customer ) {
		
		checkCustomerCode( customer.getPersonId() );
		
		customerRepository.save(customer);
		
	}

	public void deleteCustomer( Long customerId ) {
		
		checkCustomerCode( customerId );
	
		customerRepository.deleteById(customerId);
	
	}
	
	private void checkCustomerCode( Long customerId ) {
		
		if( ! customerRepository.existsById( customerId ) )
			
			throw new IllegalStateException("Customer code " + customerId + " does not exits");
		
	}

}
