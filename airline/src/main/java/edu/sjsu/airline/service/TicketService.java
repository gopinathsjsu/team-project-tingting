package edu.sjsu.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.airline.model.Customer;
import edu.sjsu.airline.model.Ticket;
import edu.sjsu.airline.repository.CustomerRepository;
import edu.sjsu.airline.repository.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Ticket> getAll( ) {
		
		return ticketRepository.findAll();
		
	}
	
	public Ticket getByTicketId( Long ticketId ) {
		
		checkTicketCode( ticketId );
		
		return ticketRepository.findById( ticketId ).get();
		
	}
	
	public void addTicket( Ticket newTicket ) {
		
		Customer customer = customerRepository.getById(3L);
		
		newTicket.seteTicketNumber(20211000000001L);
		
		newTicket.setCustomer(customer);
		
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
