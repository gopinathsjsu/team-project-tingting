package edu.sjsu.airline.customValidator;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PastDateValidator implements ConstraintValidator<PastDate, LocalDate> {
	
	public boolean isValid( LocalDate date, ConstraintValidatorContext context ) {
		
		return date.isAfter(LocalDate.now());
		
	}

}
