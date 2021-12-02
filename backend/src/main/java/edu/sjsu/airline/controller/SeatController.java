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

import edu.sjsu.airline.model.Seat;
import edu.sjsu.airline.service.SeatService;

@RestController
@RequestMapping(path="/api/v1/seat")
@CrossOrigin( origins = "*" )
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
	public void addNewSeat( @Valid @RequestBody Seat seat ) {
		
		seatService.addSeat( seat );
		
	}
	
	@PutMapping
	public void updateSeat( @Valid @RequestBody Seat seat ) {
		
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
