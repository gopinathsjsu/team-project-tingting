package edu.sjsu.airline.customValidator;

import java.time.LocalDateTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PastDateTimeValidator implements ConstraintValidator<PastDateTime, LocalDateTime> {
	
	public boolean isValid( LocalDateTime date, ConstraintValidatorContext context ) {
		
		return date.isAfter(LocalDateTime.now());
		
	}

}
