package edu.sjsu.airline.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.airline.model.Flight;
import edu.sjsu.airline.model.Reservation;
import edu.sjsu.airline.model.Ticket;
import edu.sjsu.airline.repository.ReservationRepository;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private RewardLogService rewardLogService;
	
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
		
		checkReservationCode( reservationId );
		
		Reservation reservation =  getByReservationId(reservationId);
		
		if( checkReservationConstrain( reservation ) ) {
			
			LocalDateTime dateTime = LocalDateTime.now();
		
			for( Ticket ticket :  reservation.getTickets() ) {
				
				ticketService.cancelTicket( ticket, dateTime );
				
			}
			
			paymentService.cancelPayment( reservation.getPayment(), dateTime );
			
			reservation.setCanceledDate( dateTime );
			
			reservationRepository.save( reservation );
			
			rewardLogService.cancelPurchase( rewardLogService.getPurchaseLog( reservation.getReservationId() ), dateTime  );
			
		}	
		
	}
	
	private void checkReservationCode( Long reservationId ) {
		
		if( ! reservationRepository.existsById( reservationId ) )
			
			throw new IllegalStateException("reservationId:Reservation code \" + reservationId + \" does not exits");
			
	}
	
	private boolean checkReservationConstrain( Reservation reservation ) {
		
		for( Ticket ticket :  reservation.getTickets() )
			
			checkFlight( ticket.getSeat().getFlight() );
			
		return true;
		
	}
	
	private void checkFlight( Flight flight ) {
		
		// Raise exception if the flight has already taken off 
		if( flight.getDepartureDateTime() != null ) {
			
			throw new IllegalStateException("Message:Flight \" + flight.getFlightNumber() + \" has already taken off");
			
		// Raise exception if the customer wants cancel the reservation less than 48 hours for the flight
		} else if( flight.getDepartureDateTime() == null && LocalDateTime.now().isAfter( flight.getEstimatedDepartureDateTime().minusHours(48) ) )
					
			throw new IllegalStateException("Message:The deadline for canceling the reservation was " + flight.getFlightNumber() );
		
	}
	
}