package edu.sjsu.airline.customValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.airline.repository.AirportRepository;

public class AirportCodeValidator implements ConstraintValidator<AirportCode, String> {
	
	@Autowired
	private AirportRepository airportRepository;
	
	public boolean isValid( String routeCode, ConstraintValidatorContext context ) {
		
		if( airportRepository == null ) return true;
		
		if( routeCode.length() == 3 ) {
			
			return airportRepository.existsById( routeCode );
			
		} else if( routeCode.length() == 7 ) {
		
			String[] airports = routeCode.split("-");
		
			return airportRepository.existsById( airports[0] ) && airportRepository.existsById( airports[1] );
		
		} else {
			
			return false;
			
		}
		
		/*
		if( !airportRepository.existsById( airports[0] ) )
			
			stringBuilder.append("Airport Code " + airports[0] + " is invalid");
			
		if( !airportRepository.existsById( airports[1] ) ) {
			
			if ( !stringBuilder.isEmpty() ) stringBuilder.append(". ");
			
			stringBuilder.append("Airport Code " + airports[1] + " is invalid");
			
		}
		
		if(!stringBuilder.isEmpty() ) {
			 
			 context.buildConstraintViolationWithTemplate( stringBuilder.toString() ).addConstraintViolation();
			 
			 return false;
			 
	    }
		
		return true;
		*/
		
	}

}