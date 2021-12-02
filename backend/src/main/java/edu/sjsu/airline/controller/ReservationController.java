package edu.sjsu.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.sjsu.airline.model.Reservation;
import edu.sjsu.airline.service.ReservationService;

@RestController
@RequestMapping(path = "/api/v1/reservation")
@CrossOrigin( origins = "*" )
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping
	public List<Reservation> getReservations() {
		
		return reservationService.getAll();
		
	}
	
	@GetMapping( path = "/{reservationId}" )
	public Reservation getReservation( @PathVariable("reservationId") Long reservationId ) {
		
		return reservationService.getByReservationId( reservationId );
		
	}
	
	@PostMapping
	public void addNewReservation( @RequestBody Reservation reservation ) {
		
		reservationService.addReservation( reservation );
		
	}
	
	@PutMapping
	public void updateReservation( @RequestBody Reservation reservation ) {
		
		reservationService.updateReservation( reservation );
		
	}
	
	@PutMapping( path = "cancel/{reservationId}" )
	public void cancelReservation( @PathVariable("reservationId") Long reservationId ) {
		
		reservationService.cancelReservation( reservationId );
		
	}
	
	@DeleteMapping( path = "/{reservationId}" )
	public void deleteReservation( @PathVariable("reservationId") Long reservationId ) {
		
		reservationService.deleteReservation( reservationId );
		
	}

}