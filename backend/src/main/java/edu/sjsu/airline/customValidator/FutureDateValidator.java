package edu.sjsu.airline.customValidator;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FutureDateValidator implements ConstraintValidator<FutureDate, LocalDate> {
	
	public boolean isValid( LocalDate date, ConstraintValidatorContext context ) {
		
		return date.isBefore( LocalDate.now() );
		
	}

}
