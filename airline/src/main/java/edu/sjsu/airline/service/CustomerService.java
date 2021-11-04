package edu.sjsu.airline.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.sjsu.airline.model.Customer;
import edu.sjsu.airline.model.Login;
import edu.sjsu.airline.model.User;
import edu.sjsu.airline.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private final CustomerRepository customerRepository;
	
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public CustomerService( CustomerRepository customerRepository, BCryptPasswordEncoder bCryptPasswordEncoder ) {
		
		this.customerRepository =  customerRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		
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
	
	public void authenticateUser( Login login ) {
		
		String encodedPassword = bCryptPasswordEncoder.encode( login.getPassword() );

		List<GrantedAuthority> authorities = new ArrayList<>();
		
		authorities.add( new SimpleGrantedAuthority("CUSTOMER") );
		
		UserDetails user = new User( login.getEmail(), encodedPassword );
		
		Authentication authentication = new UsernamePasswordAuthenticationToken( user, null, user.getAuthorities() );
		
		SecurityContextHolder.getContext().setAuthentication( authentication );
		
	}
	
	private void checkCustomerCode( Long customerId ) {
		
		if( ! customerRepository.existsById( customerId ) )
			
			throw new IllegalStateException("Customer code " + customerId + " does not exits");
		
	}

}
