package edu.sjsu.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.airline.model.Airport;
import edu.sjsu.airline.repository.AirportRepository;

@Service
public class AirportService {
	
	private final AirportRepository airportRepository;
	
	@Autowired
	public AirportService( AirportRepository airportRepository ) {
		
		this.airportRepository = airportRepository;
		
	}
	
	public List<Airport> getAll( ) {
		
		return airportRepository.findAll();
		
	}
	
	public Airport getByAirportCode( String airportCode ) {
		
		checkAirportCode( airportCode );
		
		return airportRepository.findById( airportCode ).get();
		
	}
	
	public void addAirport( Airport newAirport ) {
		
		if( airportRepository.existsById( newAirport.getAirportCode() ) )
			
			throw new IllegalStateException("Airport code " + newAirport.getAirportCode() + " is already taken");
		
		airportRepository.save(newAirport);
		
	}
	
	public void updateAirport( Airport airport ) {
		
		checkAirportCode( airport.getAirportCode() );
		
		airportRepository.save(airport);
		
	}

	public void deleteAirport( String airportCode ) {
		
		checkAirportCode( airportCode );
	
		airportRepository.deleteById(airportCode);
	
	}
	
	private void checkAirportCode( String airportCode ) {
		
		if( ! airportRepository.existsById( airportCode ) )
			
			throw new IllegalStateException("Airport code " + airportCode + " does not exits");
		
	}

}
