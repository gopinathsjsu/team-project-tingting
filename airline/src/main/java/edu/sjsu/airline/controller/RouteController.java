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

import edu.sjsu.airline.model.Route;
import edu.sjsu.airline.service.RouteService;

@RestController
@RequestMapping( path = "api/v1/route" )
public class RouteController {
	
	private final RouteService routeService;
	
	@Autowired
	public RouteController( RouteService routeService ) {
		
		this.routeService = routeService;
		
	}
	
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
		
		routeService.addRoute( route );
		
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
