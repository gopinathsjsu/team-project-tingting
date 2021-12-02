package edu.sjsu.airline.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

import edu.sjsu.airline.model.Employee;
import edu.sjsu.airline.service.EmployeeService;

@RestController
@RequestMapping( path = "/api/v1/employee" )
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	@Autowired
	public EmployeeController( EmployeeService employeeService ) {
		
		this.employeeService = employeeService;
		
	}
	
	@GetMapping
	public List<Employee> getEmployees() {
		
		return employeeService.getAll();
		
	}
	
	@GetMapping( path = "/{employeeId}" )
	public Employee getEmployee( @PathVariable("employeeId") Long employeeId ) {
		
		return employeeService.getByEmployeeId( employeeId );
		
	}
	
	@PostMapping
	public void addNewEmployee( @Valid @RequestBody Employee employee ) {
		
		employeeService.addEmployee( employee );
		
	}
	
	@PutMapping
	public void updateEmployee( @Valid @RequestBody Employee employee ) {
		
		employeeService.updateEmployee( employee );
		
	}
	
	@DeleteMapping( path = "/{employeeId}" )
	public void deleteEmployee( @PathVariable("employeeId") Long employeeId ) {
		
		employeeService.deleteEmployee( employeeId );
		
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