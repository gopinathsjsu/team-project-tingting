package edu.sjsu.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.airline.model.Seat;
import edu.sjsu.airline.repository.SeatRepository;

@Service
public class SeatService {
	
	@Autowired
	private SeatRepository seatRepository;
	
	public List<Seat> getAll( ) {
		
		return seatRepository.findAll();
		
	}
	
	public Seat getBySeatId( Long seatId ) {
		
		checkSeatCode( seatId );
		
		return seatRepository.findById( seatId ).get();
		
	}
	
	public void addSeat( Seat newSeat ) {
		
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
	
	private void checkSeatCode( Long seatId ) {
		
		if( ! seatRepository.existsById( seatId ) )
			
			throw new IllegalStateException("Seat id " + seatId + " does not exits");
		
	}

}
