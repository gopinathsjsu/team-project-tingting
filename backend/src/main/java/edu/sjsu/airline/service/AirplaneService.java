package edu.sjsu.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.airline.model.Airplane;
import edu.sjsu.airline.repository.AirplaneRepository;

@Service
public class AirplaneService {
	
	private final AirplaneRepository airplaneRepository;
	
	@Autowired
	public AirplaneService( AirplaneRepository airplaneRepository ) {
		
		this.airplaneRepository = airplaneRepository;
		
	}
	
	public List<Airplane> getAll( ) {
		
		return airplaneRepository.findAll();
		
	}
	
	public Airplane getByAirplaneId( Long airplaneId ) {
		
		checkAirplaneCode( airplaneId );
		
		return airplaneRepository.findById( airplaneId ).get();
		
	}
	
	public void addAirplane( Airplane newAirplane ) {
		
		airplaneRepository.save(newAirplane);
		
	}
	
	public void updateAirplane( Airplane airplane ) {
		
		checkAirplaneCode( airplane.getAirplaneId() );
		
		airplaneRepository.save(airplane);
		
	}

	public void deleteAirplane( Long airplaneId ) {
		
		checkAirplaneCode( airplaneId );
	
		airplaneRepository.deleteById(airplaneId);
	
	}
	
	private void checkAirplaneCode( Long airplaneId ) {
		
		if( ! airplaneRepository.existsById( airplaneId ) )
			
			throw new IllegalStateException("airplaneCode:Airplane code " + airplaneId + " does not exits");
		
	}

}
