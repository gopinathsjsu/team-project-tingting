package edu.sjsu.airline.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.airline.model.Flight;
import edu.sjsu.airline.model.Reservation;
import edu.sjsu.airline.model.Ticket;
import edu.sjsu.airline.repository.ReservationRepository;

@Service
public class ReservationService {
	
	private final ReservationRepository reservationRepository;
	
	@Autowired
	public ReservationService( ReservationRepository reservationRepository ) {
		
		this.reservationRepository = reservationRepository;
		
	}
	
	public List<Reservation> getAll( ) {
		
		return reservationRepository.findAll();
		
	}
	
	public Reservation getByReservationId( Long reservationId ) {
		
		checkReservationCode( reservationId );
		
		return reservationRepository.findById( reservationId ).get();
		
	}
	
	public void addReservation( Reservation newReservation ) {
		
		reservationRepository.save(newReservation);
		
	}
	
	public void updateReservation( Reservation reservation ) {
		
		checkReservationCode( reservation.getReservationId() );
		
		reservationRepository.save(reservation);
		
	}

	public void deleteReservation( Long reservationId ) {
		
		checkReservationCode( reservationId );
	
		reservationRepository.deleteById(reservationId);
	
	}
	
	public void cancelReservation( Long reservationId ) {
		
		if( checkReservationConstrain( reservationId ) ) {
		
			
		
		}	
		
	}
	
	private void checkReservationCode( Long reservationId ) {
		
		if( ! reservationRepository.existsById( reservationId ) )
			
			throw new IllegalStateException("Reservation code " + reservationId + " does not exits");
		
	}
	
	private boolean checkReservationConstrain( Long reservationId ) {
		
		checkReservationCode( reservationId );
		
		Reservation reservation =  getByReservationId(reservationId);
		
		ArrayList<Ticket> tickets = new ArrayList<>(reservation.getTickets()) ; 
		
		Flight flight = tickets.get(0).getSeat().getFlight();
		
		// Raise exception if the flight has already taken off 
		if( flight.getDepartureDateTime() != null ) {
			
			throw new IllegalStateException("Flight " + flight.getFlightNumber() + " has already taken off.");
		
		// Raise exception if the customer wants cancel the reservation less than 48 hours for the flight
		} else if( flight.getDepartureDateTime() == null && LocalDateTime.now().isAfter( flight.getEstimatedDepartureDateTime().minusHours(48) ) )
			
			throw new IllegalStateException("The deadline for canceling the reservation was " + flight.getFlightNumber() );
		
		return true;
		
	}

}
