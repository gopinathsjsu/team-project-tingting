package edu.sjsu.airline.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.airline.model.Employee;
import edu.sjsu.airline.model.Flight;
import edu.sjsu.airline.model.NewFlightRequest;
import edu.sjsu.airline.model.SearchFlight;
import edu.sjsu.airline.repository.FlightRepository;

@Service
public class FlightService { 
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	public AirplaneService airplaneService;
	
	@Autowired
	public RouteService routeService;
	
	@Autowired
	public EmployeeService employeeService;
	
	public List<Flight> getAll( ) {
		
		return flightRepository.findAll();
		
	}
	
	public Flight getByFlightId( Long flightId ) {
		
		checkFlightCode( flightId );
		
		return flightRepository.findById( flightId ).get();
		
	}
	
	public void addFlight( NewFlightRequest newFlightRequest ) {
		
		Flight newFlight = new Flight( newFlightRequest.getFlightNumber(), newFlightRequest.getEstimatedDepartureDateTime(), newFlightRequest.getEstimatedArrivalDateTime() );
		
		newFlight.setRoute( routeService.getByRouteId( newFlightRequest.getRouteCode() ) );
		
		newFlight.setFlightEquipment( airplaneService.getByAirplaneId( newFlightRequest.getAirplaneId() ) );
		
		flightRepository.save( newFlight );
		
	}
	
	public void updateFlight( NewFlightRequest newFlightRequest ) {
		
		Flight flight = getByFlightId( newFlightRequest.getFlightId() );
		
		flight.setFlightNumber( newFlightRequest.getFlightNumber() );
		flight.setEstimatedDepartureDateTime( newFlightRequest.getEstimatedDepartureDateTime() );
		flight.setEstimatedArrivalDateTime( newFlightRequest.getEstimatedArrivalDateTime() );
		
		if( flight.getRoute().getRouteCode() != newFlightRequest.getRouteCode() )
			
			flight.setRoute( routeService.getByRouteId( newFlightRequest.getRouteCode() ) );
		
		if( flight.getFlightEquipment().getAirplaneId() != newFlightRequest.getAirplaneId() )
			
			flight.setFlightEquipment( airplaneService.getByAirplaneId( newFlightRequest.getAirplaneId() ) );
		
		flightRepository.save( flight );
		
	}
	
	public void assignEmployeeToFlight( Long flightId, Long employeeId ) {
		
		Flight flight = getByFlightId( flightId );
		
		Employee employee = employeeService.getByEmployeeId( employeeId );
		
		flight.getCrew().add(employee);
		
		flightRepository.save( flight );
		
	}

	public void deleteFlight( Long flightId ) {
		
		checkFlightCode( flightId );
	
		flightRepository.deleteById( flightId );
	
	}
	
	
	
	public List<Flight> findAvaiableFlights( SearchFlight searchFlight ) {
		
		String departingRoute = searchFlight.getOriginAirport() + "-" + searchFlight.getReturnAirport();
		
		String returningRoute = searchFlight.getReturnAirport() + "-" + searchFlight.getOriginAirport();
		
		List<Flight> departureFlights = flightRepository.findAllAvaiableFlight(departingRoute, searchFlight.getDepartureDate(), searchFlight.getQtyPassager() );
		
		List<Flight> returnFlights = flightRepository.findAllAvaiableFlight(returningRoute, searchFlight.getReturnDate(), searchFlight.getQtyPassager() );
		
		return Stream.concat(departureFlights.stream(), returnFlights.stream()).collect( Collectors.toList() );
		
	}
	
	private void checkFlightCode( Long flightId ) {
		
		if( ! flightRepository.existsById( flightId ) )
			
			throw new IllegalStateException("Flight id " + flightId + " does not exits");
		
	}

}
