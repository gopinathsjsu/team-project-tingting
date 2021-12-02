package edu.sjsu.airline.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import edu.sjsu.airline.model.Airport;
import edu.sjsu.airline.service.AirportService;

@RestController
@RequestMapping(path = "/api/v1/airport")
@CrossOrigin( origins = "*" )
public class AirportController {
	
	@Autowired
	private AirportService airportService;
	
	@GetMapping
	public List<Airport> getAirports() {
		
		return airportService.getAll();
		
	}
	
	@GetMapping( path = "/{airportCode}" )
	public Airport getAirport( @PathVariable("airportCode") String airportCode ) {
		
		return airportService.getByAirportCode( airportCode );
		
	}
	
	@PostMapping
	public void addNewAirport( @Valid @RequestBody Airport airport ) {
		
		airportService.addAirport( airport );
		
	}
	
	@PutMapping
	public void updateAirport( @Valid @RequestBody Airport airport ) {
		
		airportService.updateAirport( airport );
		
	}
	
	@DeleteMapping( path = "/{airportCode}" )
	public void deleteAirport( @PathVariable("airportCode") String airportCode ) {
		
		airportService.deleteAirport( airportCode );
		
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
