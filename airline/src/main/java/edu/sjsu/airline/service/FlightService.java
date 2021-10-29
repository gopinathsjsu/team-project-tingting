package edu.sjsu.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.airline.model.Flight;
import edu.sjsu.airline.repository.FlightRepository;

@Service
public class FlightService { 
	
	@Autowired
	private FlightRepository flightRepository;
	
	public List<Flight> getAll( ) {
		
		return flightRepository.findAll();
		
	}
	
	public Flight getByFlightId( Long flightId ) {
		
		checkFlightCode( flightId );
		
		return flightRepository.findById( flightId ).get();
		
	}
	
	public void addFlight( Flight newFlight ) {
		
		flightRepository.save(newFlight);
		
	}
	
	public void updateFlight( Flight flight ) {
		
		checkFlightCode( flight.getFlightId() );
		
		flightRepository.save(flight);
		
	}

	public void deleteFlight( Long flightId ) {
		
		checkFlightCode( flightId );
	
		flightRepository.deleteById(flightId);
	
	}
	
	private void checkFlightCode( Long flightId ) {
		
		if( ! flightRepository.existsById( flightId ) )
			
			throw new IllegalStateException("Flight id " + flightId + " does not exits");
		
	}
	

}
