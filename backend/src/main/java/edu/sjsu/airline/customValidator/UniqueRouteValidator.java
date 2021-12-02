package edu.sjsu.airline.customValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.airline.repository.RouteRepository;

public class UniqueRouteValidator implements ConstraintValidator<UniqueRoute, String> {
	
	@Autowired
	private RouteRepository routeRepository;
	
	public boolean isValid( String routeCode, ConstraintValidatorContext context ) {
		
		return routeRepository == null ? true : !routeRepository.existsById( routeCode );
		
	}

}