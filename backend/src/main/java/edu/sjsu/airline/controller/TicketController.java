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

import edu.sjsu.airline.model.Ticket;
import edu.sjsu.airline.service.TicketService;

@RestController
@RequestMapping(path = "/api/v1/ticket")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@GetMapping
	public List<Ticket> getTickets() {
		
		return ticketService.getAll();
		
	}
	
	@GetMapping( path = "/{ticketId}" )
	public Ticket getTicket( @PathVariable("ticketId") Long ticketId ) {
		
		return ticketService.getByTicketId( ticketId );
		
	}
	
	@PostMapping
	public void addNewTicket( @RequestBody Ticket ticket ) {
		
		ticketService.addTicket( ticket );
		
	}
	
	@PutMapping
	public void updateTicket( @RequestBody Ticket ticket ) {
		
		ticketService.updateTicket( ticket );
		
	}
	
	@DeleteMapping( path = "/{ticketId}" )
	public void deleteTicket( @PathVariable("ticketId") Long ticketId ) {
		
		ticketService.deleteTicket( ticketId );
		
	}
		
}
