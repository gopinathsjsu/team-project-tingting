package edu.sjsu.airline.customValidator;

import java.time.LocalDateTime;

import java.lang.reflect.Field;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CompareDateValidator implements ConstraintValidator<CompareDate, LocalDateTime> {
	
	private String className;
	private String fieldName;
	
	private boolean isBefore;
	
	@Override
	public void initialize(CompareDate constraintAnnotation) {
	    
		className = constraintAnnotation.className();
		fieldName = constraintAnnotation.fieldName();
		isBefore = constraintAnnotation.isBefore();
		
	}
	  
	@Override
	public boolean isValid(LocalDateTime targetDate, ConstraintValidatorContext context) {
		
		try {
			
			Class<?> c = Class.forName("edu.sjsu.airline.model." + className );
			
			Field dateField = c.getDeclaredField( fieldName );
			
			dateField.setAccessible(true);

			if( isBefore ) {
				
				LocalDateTime afterDate = (LocalDateTime) dateField.get( c );
				
				System.out.println("Departure: " + targetDate);
				
				System.out.println("Arrival: " + afterDate);
				
				return targetDate.isBefore(afterDate);   
				
			} else {
				
				LocalDateTime beforeDate = (LocalDateTime) dateField.get( c );
				
				return beforeDate.isBefore(targetDate);
				
			}
			
	    } catch ( ClassNotFoundException | NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e ) {
	    	
	    	e.printStackTrace();
	      
	    }
		
		return false;
	}

}