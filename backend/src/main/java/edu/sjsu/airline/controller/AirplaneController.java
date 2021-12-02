package edu.sjsu.airline.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
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

import edu.sjsu.airline.model.Airplane;
import edu.sjsu.airline.service.AirplaneService;

@RestController
@RequestMapping(path = "/api/v1/airplane")
@CrossOrigin( origins = "*" )
public class AirplaneController {
	
	@Autowired
	private AirplaneService airplaneService;
	
	@GetMapping
	public List<Airplane> getAirplanes() {
		
		return airplaneService.getAll();
		
	}
	
	@GetMapping( path = "/{airplaneId}" )
	public Airplane getAirplane( @PathVariable("airplaneId") Long airplaneId ) {
		
		return airplaneService.getByAirplaneId( airplaneId );
		
	}
	
	@PostMapping
	public void addNewAirplane( @Valid @RequestBody Airplane airplane ) {
		
		airplaneService.addAirplane( airplane );
		
	}
	
	@PutMapping
	public void updateAirplane( @Valid @RequestBody Airplane airplane ) {
		
		airplaneService.updateAirplane( airplane );
		
	}
	
	@DeleteMapping( path = "/{airplaneId}" )
	public void deleteAirplane( @PathVariable("airplaneId") Long airplaneId ) {
		
		airplaneService.deleteAirplane( airplaneId );
		
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