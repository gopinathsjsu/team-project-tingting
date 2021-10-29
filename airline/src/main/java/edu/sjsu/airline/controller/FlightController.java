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

import edu.sjsu.airline.model.Airplane;
import edu.sjsu.airline.model.Employee;
import edu.sjsu.airline.model.Flight;
import edu.sjsu.airline.model.Route;
import edu.sjsu.airline.service.AirplaneService;
import edu.sjsu.airline.service.EmployeeService;
import edu.sjsu.airline.service.FlightService;
import edu.sjsu.airline.service.RouteService;

@RestController
@RequestMapping(path = "/api/v1/flight")
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	@Autowired
	public AirplaneService airplaneService;
	
	@Autowired
	public RouteService routeService;
	
	@Autowired
	public EmployeeService employeeService;
	
	@GetMapping
	public List<Flight> getFlights() {
		
		return flightService.getAll();
		
	}
	
	@GetMapping( path = "/{flightId}" )
	public Flight getFlight( @PathVariable("flightId") Long flightId ) {
		
		return flightService.getByFlightId( flightId );
		
	}
	
	@PostMapping
	public void addNewFlight( @RequestBody Flight flight ) {
		
		flightService.addFlight( flight );
		
	}
	
	@PutMapping
	public void updateFlight( @RequestBody Flight flight ) {
		
		flightService.updateFlight( flight );
		
	}
	
	@PutMapping( path = "/{flightId}/route/{routeCode}" )
	public void assignRouteToFlight( @PathVariable Long flightId, @PathVariable String routeCode ) {
		
		Flight flight = flightService.getByFlightId(flightId);
		
		Route route = routeService.getByRouteId(routeCode);
		
		flight.setRoute(route);
		
		flightService.updateFlight( flight );
		
	}
	
	@PutMapping( path = "/{flightId}/airplane/{airplaneId}" )
	public void assignAirplaneToFlight( @PathVariable Long flightId, @PathVariable Long airplaneId ) {
		
		Flight flight = flightService.getByFlightId(flightId);
		
		Airplane airplane = airplaneService.getByAirplaneId(airplaneId);
		
		flight.setFlightEquipment(airplane);
		
		flightService.updateFlight( flight );
		
	}
	
	@PutMapping( path = "/{flightId}/employee/{employeeId}" )
	public void assignEmployeeToFlight( @PathVariable Long flightId, @PathVariable Long employeeId ) {
		
		Flight flight = flightService.getByFlightId(flightId);
		
		Employee employee = employeeService.getByEmployeeId(employeeId);
		
		flight.getCrew().add(employee);
		
		flightService.updateFlight( flight );
		
	}
	
	@DeleteMapping( path = "/{flightId}" )
	public void deleteFlight( @PathVariable("flightId") Long flightId ) {
		
		flightService.deleteFlight( flightId );
		
	}

}
