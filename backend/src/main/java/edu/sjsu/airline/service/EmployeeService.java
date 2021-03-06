package edu.sjsu.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.sjsu.airline.model.Employee;
import edu.sjsu.airline.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public EmployeeService ( EmployeeRepository employeeRepository ) {
		
		this.employeeRepository = employeeRepository;
		
	}
	
	public List<Employee> getAll( ) {
		
		return employeeRepository.findAll();
		
	}
	
	public Employee getByEmployeeId( Long employeeId ) {
		
		checkEmployeeCode( employeeId );
		
		return employeeRepository.findById( employeeId ).get();
		
	}
	
	public void addEmployee( Employee newEmployee ) {
		
		newEmployee.setRoles("ADMIN");
		
		newEmployee.setActive(true);
		
		newEmployee.setPassword( passwordEncoder.encode( newEmployee.getPassword() ) );
		
		employeeRepository.save(newEmployee);
		
	}
	
	public void updateEmployee( Employee employee ) {
		
		checkEmployeeCode( employee.getUserId() );
		
		employeeRepository.save(employee);
		
	}

	public void deleteEmployee( Long employeeId ) {
		
		checkEmployeeCode( employeeId );
	
		employeeRepository.deleteById(employeeId);
	
	}
	
	private void checkEmployeeCode( Long employeeId ) {
		
		if( ! employeeRepository.existsById( employeeId ) )
				
			throw new IllegalStateException("employeeId:Employee code \" + employeeId + \" does not exits");
		
	}
	
}
