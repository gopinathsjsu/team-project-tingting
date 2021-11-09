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

import edu.sjsu.airline.model.Airport;
import edu.sjsu.airline.service.AirportService;

@RestController
@RequestMapping(path = "/api/v1/airport")
public class AirportController {
	
	private final AirportService airportService;
	
	@Autowired
	public AirportController( AirportService airportService ) {
		
		this.airportService = airportService;
		
	}
	
	@GetMapping
	public List<Airport> getAirports() {
		
		return airportService.getAll();
		
	}
	
	@GetMapping( path = "/{airportCode}" )
	public Airport getAirport( @PathVariable("airportCode") String airportCode ) {
		
		return airportService.getByAirportCode( airportCode );
		
	}
	
	@PostMapping
	public void addNewAirport( @RequestBody Airport airport ) {
		
		airportService.addAirport( airport );
		
	}
	
	@PutMapping
	public void updateAirport( @RequestBody Airport airport ) {
		
		airportService.updateAirport( airport );
		
	}
	
	@DeleteMapping( path = "/{airportCode}" )
	public void deleteAirport( @PathVariable("airportCode") String airportCode ) {
		
		airportService.deleteAirport( airportCode );
		
	}

}
