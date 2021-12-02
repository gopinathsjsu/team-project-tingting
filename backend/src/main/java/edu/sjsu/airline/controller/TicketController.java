package edu.sjsu.airline.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.sjsu.airline.model.Ticket;
import edu.sjsu.airline.service.TicketService;

@RestController
@RequestMapping(path = "/api/v1/ticket")
@CrossOrigin( origins = "*" )
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
	public void addNewTicket( @Valid @RequestBody Ticket ticket ) {
		
		ticketService.addTicket( ticket );
		
	}
	
	@PutMapping
	public void updateTicket( @Valid @RequestBody Ticket ticket ) {
		
		ticketService.updateTicket( ticket );
		
	}
	
	@DeleteMapping( path = "/{ticketId}" )
	public void deleteTicket( @PathVariable("ticketId") Long ticketId ) {
		
		ticketService.deleteTicket( ticketId );
		
	}
	
	@PutMapping( path = "cancel/{ticketId}" )
	public void cancelTicket( @PathVariable("ticketId") Long ticketId ) {
		
		ticketService.cancelTicket( ticketId );
		
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        
		Map<String, String> errors = new HashMap<>();
		
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        
        return errors;
    }
		
}
