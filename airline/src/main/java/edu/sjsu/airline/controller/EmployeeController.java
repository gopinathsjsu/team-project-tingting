package edu.sjsu.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public void addNewEmployee( @RequestBody Employee employee ) {
		
		employeeService.addEmployee( employee );
		
	}
	
	@PutMapping
	public void updateEmployee( @RequestBody Employee employee ) {
		
		employeeService.updateEmployee( employee );
		
	}
	
	@DeleteMapping( path = "/{employeeId}" )
	public void deleteEmployee( @PathVariable("employeeId") Long employeeId ) {
		
		employeeService.deleteEmployee( employeeId );
		
	}
	
}