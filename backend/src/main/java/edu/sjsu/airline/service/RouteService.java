package edu.sjsu.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.airline.model.Route;
import edu.sjsu.airline.repository.RouteRepository;

@Service
public class RouteService {
	
	private final RouteRepository routeRepository;
	
	@Autowired
	public RouteService( RouteRepository routeRepository ) {
		
		this.routeRepository = routeRepository;
		
	}
	
	public List<Route> getAll( ) {
		
		return routeRepository.findAll();
		
	}
	
	public Route getByRouteId( String routeCode ) {
		
		checkRouteCode( routeCode );
		
		return routeRepository.findById( routeCode ).get();
		
	}
	
	public void addRoute( Route newRoute ) {
		
		routeRepository.save(newRoute);
		
	}
	
	public void updateRoute( Route route ) {
		
		checkRouteCode( route.getRouteCode() );
		
		routeRepository.save(route);
		
	}

	public void deleteRoute( String routeCode ) {
		
		checkRouteCode( routeCode );
	
		routeRepository.deleteById(routeCode);
	
	}
	
	private void checkRouteCode( String routeCode ) {
		
		if( ! routeRepository.existsById( routeCode ) )
			
			throw new IllegalStateException("routeCode:Route code \" + routeCode + \" does not exits" );
		
	}

}
