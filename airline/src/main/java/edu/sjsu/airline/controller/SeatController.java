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

import edu.sjsu.airline.model.Seat;
import edu.sjsu.airline.service.SeatService;

@RestController
@RequestMapping(path="/api/v1/seat")
public class SeatController {
	
	@Autowired
	private SeatService seatService;
	
	@GetMapping
	public List<Seat> getSeats() {
		
		return seatService.getAll();
		
	}
	
	@GetMapping( path = "/{seatId}" )
	public Seat getSeat( @PathVariable("seatId") Long seatId ) {
		
		return seatService.getBySeatId( seatId );
		
	}
	
	@GetMapping( path = "/flight/{flightId}" )
	public List<Seat> getSeatByFlight( @PathVariable Long flightId ) {
		
		return seatService.getByFlightId( flightId );
		
	}
	
	@PostMapping
	public void addNewSeat( @RequestBody Seat seat ) {
		
		seatService.addSeat( seat );
		
	}
	
	@PutMapping
	public void updateSeat( @RequestBody Seat seat ) {
		
		seatService.updateSeat( seat );
		
	}
	
	/*
	@PutMapping( path = "/{seatId}/flight/{flightId}" )
	public void assignAirplaneToSeat( @PathVariable Long seatId, @PathVariable Long flightId ) {
		
		Seat seat = seatService.getBySeatId(seatId);
		
		Flight flight = flightService.getByFlightId(flightId);
		
		seat.setFlight(flight);
		
		seatService.updateSeat( seat );
		
	}
	*/
	
	@DeleteMapping( path = "/{seatId}" )
	public void deleteSeat( @PathVariable("seatId") Long seatId ) {
		
		seatService.deleteSeat( seatId );
		
	}

}
