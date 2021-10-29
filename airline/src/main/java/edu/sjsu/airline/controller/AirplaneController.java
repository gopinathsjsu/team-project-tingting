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
import edu.sjsu.airline.service.AirplaneService;

@RestController
@RequestMapping(path = "/api/v1/airplane")
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
	public void addNewAirplane( @RequestBody Airplane airplane ) {
		
		airplaneService.addAirplane( airplane );
		
	}
	
	@PutMapping
	public void updateAirplane( @RequestBody Airplane airplane ) {
		
		airplaneService.updateAirplane( airplane );
		
	}
	
	@DeleteMapping( path = "/{airplaneId}" )
	public void deleteAirplane( @PathVariable("airplaneId") Long airplaneId ) {
		
		airplaneService.deleteAirplane( airplaneId );
		
	}

}
