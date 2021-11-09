package edu.sjsu.airline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.sjsu.airline.model.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

	@Query("FROM Seat WHERE flight_id = :flightId")
	List<Seat> findByFlightId(Long flightId); 
	
}
