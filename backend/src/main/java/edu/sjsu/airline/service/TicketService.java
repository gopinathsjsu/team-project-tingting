package edu.sjsu.airline.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.airline.model.Flight;
import edu.sjsu.airline.model.Ticket;
import edu.sjsu.airline.repository.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private SeatService seatService;
	
	@Autowired
	private RewardLogService rewardLogService;
	
	public List<Ticket> getAll( ) {
		
		return ticketRepository.findAll();
		
	}
	
	public Ticket getByTicketId( Long ticketId ) {
		
		checkTicketCode( ticketId );
		
		return ticketRepository.findById( ticketId ).get();
		
	}
	
	public void addTicket( Ticket newTicket ) {
		
		ticketRepository.save(newTicket);
		
	}
	
	public void updateTicket( Ticket ticket ) {
		
		checkTicketCode( ticket.getTicketId() );
		
		ticketRepository.save(ticket);
		
	}

	public void deleteTicket( Long ticketId ) {
		
		checkTicketCode( ticketId );
	
		ticketRepository.deleteById(ticketId);
	
	}
	
	public void cancelTicket( Long ticketId ) {
		
		Ticket ticket = getByTicketId( ticketId );
		
		LocalDateTime dateTime = LocalDateTime.now();
		
		if( checkTicketConstrain( ticket ) ) {
			
			rewardLogService.refundTicket( ticket, dateTime );
			
			cancelTicket( ticket, dateTime );
			
		}
		
	}
	
	public void cancelTicket( Ticket ticket, LocalDateTime dateTime ) {
		
		seatService.cancelSeat( ticket.getSeat() );
		
		ticket.setCancelDateTime( dateTime );
		ticket.setSeat(null);
		
		ticketRepository.save(ticket);
		
	}
	
	private void checkTicketCode( Long ticketId ) {
		
		if( ! ticketRepository.existsById( ticketId ) )
			
			throw new IllegalStateException("ticketId:Ticket code \" + ticketId + \" does not exits" );
		
	}
	
	private boolean checkTicketConstrain( Ticket ticket ) {
		
		if( ticket.getCancelDateTime() != null ) 
			
			throw new IllegalStateException("Message:This ticket is already canceled" );
		
		Flight flight = ticket.getSeat().getFlight();
		
		// Raise exception if the flight has already taken off 
		if( flight.getDepartureDateTime() != null ) {
					
			throw new IllegalStateException("Message:Flight \" + flight.getFlightNumber() + \" has already taken off" );
				
		// Raise exception if the customer wants cancel the reservation less than 48 hours for the flight
		} else if( flight.getDepartureDateTime() == null && LocalDateTime.now().isAfter( flight.getEstimatedDepartureDateTime().minusHours(48) ) )
			
			throw new IllegalStateException("Message:The deadline for canceling the ticket was " + flight.getFlightNumber() );
			
		return true;
		
	}

}
