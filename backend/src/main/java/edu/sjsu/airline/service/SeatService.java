package edu.sjsu.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.airline.model.Flight;
import edu.sjsu.airline.model.Seat;
import edu.sjsu.airline.model.SeatStatus;
import edu.sjsu.airline.repository.SeatRepository;

@Service
public class SeatService {
	
	@Autowired
	private SeatRepository seatRepository;
	
	@Autowired
	private FlightService flightService;
	
	public List<Seat> getAll( ) {
		
		return seatRepository.findAll();
		
	}
	
	public Seat getBySeatId( Long seatId ) {
		
		checkSeatCode( seatId );
		
		return seatRepository.findById( seatId ).get();
		
	}
	
	public List<Seat> getByFlightId( Long flightId ) {
		
		return seatRepository.findByFlightId( flightId );
		
	}
	
	public void addSeat( Seat newSeat ) {
		
		Flight flight = flightService.getByFlightId( newSeat.getFlightId() );
		
		newSeat.setFlight(flight);
		
		seatRepository.save(newSeat);
		
	}
	
	public void updateSeat( Seat seat ) {
		
		checkSeatCode( seat.getSeatId() );
		
		seatRepository.save(seat);
		
	}

	public void deleteSeat( Long seatId ) {
		
		checkSeatCode( seatId );
	
		seatRepository.deleteById(seatId);
	
	}
	
	public void cancelSeat( Seat seat ) {
		
		seat.setSeatStatus( SeatStatus.Avaiable );
		seat.setTicket(null);
	
		seatRepository.save(seat);
	
	}
	
	private void checkSeatCode( Long seatId ) {
		
		if( ! seatRepository.existsById( seatId ) )
			
			throw new IllegalStateException("seatId:Seat id \" + seatId + \" does not exits" );
		
	}

}
