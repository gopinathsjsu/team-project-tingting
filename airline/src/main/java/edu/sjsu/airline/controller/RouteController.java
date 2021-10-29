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
import edu.sjsu.airline.model.Route;
import edu.sjsu.airline.service.AirportService;
import edu.sjsu.airline.service.RouteService;

@RestController
@RequestMapping( path = "api/v1/route" )
public class RouteController {
	
	@Autowired
	private RouteService routeService;
	
	@Autowired
	private AirportService airportService;
	
	@GetMapping
	public List<Route> getRoutes() {
		
		return routeService.getAll();
		
	}
	
	@GetMapping( path = "/{routeCode}" )
	public Route getRoute( @PathVariable("routeCode") String routeCode ) {
		
		return routeService.getByRouteId( routeCode );
		
	}
	
	@PostMapping
	public void addNewRoute( @RequestBody Route route ) {
		
		// The routeCode should be originAirportCode-destinationAirportCode( E.g.: SFO-LAX )
		String[] airports = route.getRouteCode().split("-");
		
		Airport originAirport = airportService.getByAirportCode( airports[0] );
		Airport destinationAirport = airportService.getByAirportCode( airports[1] );
		
		route.setOriginAirport(originAirport);
		route.setDestinationAirport(destinationAirport);
		
		routeService.addRoute( route );
		
	}
	
	@PutMapping( path = "/{routeCode}/originAirport/{airportCode}" )
	public void assignOriginAirportToRoute( @PathVariable String routeCode, @PathVariable String airportCode ) {
		
		Route route = routeService.getByRouteId( routeCode );
		
		Airport airport = airportService.getByAirportCode( airportCode );
		
		route.setOriginAirport(airport);
		
		routeService.updateRoute( route );
		
	}
	
	@PutMapping( path = "/{routeCode}/destinationAirport/{airportCode}" )
	public void assignDestinationAirportToRoute( @PathVariable String routeCode, @PathVariable String airportCode ) {
		
		Route route = routeService.getByRouteId( routeCode );
		
		Airport airport = airportService.getByAirportCode( airportCode );
		
		route.setDestinationAirport(airport);
		
		routeService.updateRoute( route );
		
	}
	
	@PutMapping
	public void updateRoute( @RequestBody Route route ) {
		
		routeService.updateRoute( route );
		
	}
	
	@DeleteMapping( path = "/{routeCode}" )
	public void deleteRoute( @PathVariable("routeCode") String routeCode ) {
		
		routeService.deleteRoute( routeCode );
		
	}

}
