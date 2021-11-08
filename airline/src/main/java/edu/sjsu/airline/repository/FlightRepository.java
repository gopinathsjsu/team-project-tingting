package edu.sjsu.airline.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.sjsu.airline.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> { 
	
	@Query(value="SELECT * FROM flight WHERE route_route_code = :originAirport and DATE(estimated_departure_date_time) = :date HAVING ( SELECT COUNT(*) FROM seat WHERE flight_id = flight.flight_id AND seat_status = 'Avaiable' ) >= :qty", nativeQuery=true)
	List<Flight> findAllAvaiableFlight( String originAirport, LocalDate date, int qty );
	
}