package edu.sjsu.airline.customValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.airline.repository.AirportRepository;

public class UniqueAirportValidator implements ConstraintValidator<UniqueAirport, String> {
	
	@Autowired
	private AirportRepository airportRepository;
	
	public boolean isValid( String airportCode, ConstraintValidatorContext context ) {
		
		return airportRepository == null ? true : !airportRepository.existsById( airportCode );
		
	}

}