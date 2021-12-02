package edu.sjsu.airline.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.sjsu.airline.model.Customer;
import edu.sjsu.airline.model.RewardAccount;
import edu.sjsu.airline.service.CustomerService;

@RestController
@RequestMapping( path = "/api/v1/customer" )
@CrossOrigin( origins = "*" )
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public List<Customer> getCustomers() {
		
		return customerService.getAll();
		
	}
	
	@GetMapping( path = "/{customerId}" )
	public Customer getCustomer( @PathVariable("customerId") Long customerId ) {
		
		return customerService.getByCustomerId( customerId );
		
	}
	
	@GetMapping( path = "/{customerId}/rewardAccount" )
	public RewardAccount getCustomerRewardAccount( @PathVariable("customerId") Long customerId ) {
		
		return customerService.getRewardAccountByCustomerId( customerId );
		
	}
	
	@PostMapping
	public void addNewCustomer( @Valid @RequestBody Customer customer ) {
		
		customerService.addCustomer( customer );
		
	}
	
	@PutMapping
	public void updateCustomer( @Valid @RequestBody Customer customer ) {
		
		customerService.updateCustomer( customer );
		
	}
	
	@DeleteMapping( path = "/{customerId}" )
	public void deleteCustomer( @PathVariable("customerId") Long customerId ) {
		
		customerService.deleteCustomer( customerId );
		
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        
		Map<String, String> errors = new HashMap<>();
		
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        
        return errors;
    }
	
}