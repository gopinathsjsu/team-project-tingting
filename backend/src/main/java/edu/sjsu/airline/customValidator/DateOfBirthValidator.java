package edu.sjsu.airline.customValidator;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateOfBirthValidator implements ConstraintValidator<DateOfBirth, LocalDate> {
	
	public boolean isValid( LocalDate dateOfBirth, ConstraintValidatorContext context ) {
		
		if( dateOfBirth.isAfter(LocalDate.now().minusYears(18)) ) {
			
			return false;
			
		}
		
		return true;
		
	}
	
}
