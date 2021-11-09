package edu.sjsu.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.airline.model.Ticket;
import edu.sjsu.airline.repository.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
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
	
	private void checkTicketCode( Long ticketId ) {
		
		if( ! ticketRepository.existsById( ticketId ) )
			
			throw new IllegalStateException("Ticket code " + ticketId + " does not exits");
		
	}

}
