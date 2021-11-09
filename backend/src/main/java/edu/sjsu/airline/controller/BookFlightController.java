package edu.sjsu.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.sjsu.airline.model.Payment;
import edu.sjsu.airline.model.Ticket;
import edu.sjsu.airline.model.Traveler;
import edu.sjsu.airline.service.BookFlightService;

@RestController
@RequestMapping( path =  "/api/v1/book-flight")
public class BookFlightController {
	
	@Autowired
	private BookFlightService shoppingCartService;
	
	@PutMapping( path = "/customer/{userId}" )
	public void assignCustomer( @PathVariable Long userId  ) { 
		
		shoppingCartService.assignCustomer( userId );
		
	}
	
	@PutMapping( path = "/departFlight/{flightId}" )
	public void assignDepartingFlight( @PathVariable Long flightId ) {
		
		shoppingCartService.assignDepartingFlight( flightId );
		
	}
	
	@PutMapping( path = "/returnFlight/{flightId}" )
	public void assignReturnFlight( @PathVariable Long flightId ) {
		
		shoppingCartService.assignReturnFlight( flightId );
		
	}
	
	@PutMapping( path = "/traveler-info")
	public void assignTravelersToTicket( @RequestBody List<Traveler> travelers ) {
		
		shoppingCartService.assignTravelersToTicket(travelers);
		
	}
	
	@PutMapping( path = "/{travelerId}/departingSeat/{seatId}" )
	public void assignDepartingSeat( @PathVariable int travelerId, @PathVariable Long seatId ) {
		
		shoppingCartService.assignSeatToTicket( travelerId, seatId, true );
		
	}
	
	@PutMapping( path = "/{travelerId}/returningSeat/{seatId}" )
	public void assignReturningSeat( @PathVariable int travelerId, @PathVariable Long seatId ) {
		
		shoppingCartService.assignSeatToTicket( travelerId, seatId, false );
		
	}
	
	@PutMapping( path = "/checkout-flight" )
	public void checkoutFlight( @RequestBody Payment payment ) {
		
		shoppingCartService.checkoutFlight(payment);
		
	}
	
	@GetMapping
	public List<Ticket> teste( ) {
		
		return shoppingCartService.getTickets( );
		
	}
	
}