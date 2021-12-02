package edu.sjsu.airline.customValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.airline.repository.UserRepository;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
	
	@Autowired
	private UserRepository userRepository;
	
	public boolean isValid( String email, ConstraintValidatorContext context ) {
		
		return userRepository == null ? true : !userRepository.existsByEmail( email );
		
	}

}