package edu.sjsu.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.sjsu.airline.model.Customer;
import edu.sjsu.airline.model.RewardAccount;
import edu.sjsu.airline.repository.CustomerRepository;
import edu.sjsu.airline.repository.RewardAccountRepository;

@Service
public class CustomerService {
	
	private final CustomerRepository customerRepository;
	private final RewardAccountRepository rewardAccountRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public CustomerService( CustomerRepository customerRepository, RewardAccountRepository rewardAccountRepository ) {
		
		this.customerRepository =  customerRepository;
		this.rewardAccountRepository = rewardAccountRepository;
		
	}
	
	public List<Customer> getAll( ) {
		
		return customerRepository.findAll();
		
	}
	
	public Customer getByCustomerId( Long customerId ) {
		
		checkCustomerCode( customerId );
		
		return customerRepository.findById( customerId ).get();
		
	}
	
	public RewardAccount getRewardAccountByCustomerId( Long customerId ) {
		
		checkCustomerCode( customerId );
		
		return rewardAccountRepository.findByUserId( customerId ).get();
		
	}
	
	public void updateRewardAccount( RewardAccount rewardAccount ) {
		
		rewardAccountRepository.save( rewardAccount );
		
	}
	
	public void addCustomer( Customer newCustomer ) {
		
		newCustomer.setRoles("USER");
		
		newCustomer.setActive(true);
		
		newCustomer.setRewardAccount( new RewardAccount( newCustomer, String.valueOf( System.currentTimeMillis() ), 0 ) );
		
		newCustomer.setPassword( passwordEncoder.encode( newCustomer.getPassword() ) );
		
		customerRepository.save(newCustomer);
		
	}
	
	public void updateCustomer( Customer customer ) {
		
		checkCustomerCode( customer.getUserId() );
		
		customerRepository.save(customer);
		
	}

	public void deleteCustomer( Long customerId ) {
		
		checkCustomerCode( customerId );
	
		customerRepository.deleteById(customerId);
	
	}
	
	private void checkCustomerCode( Long customerId ) {
		
		if( ! customerRepository.existsById( customerId ) )
			
			throw new IllegalStateException("customerId:Customer code " + customerId + " does not exits");
		
	}
	
}