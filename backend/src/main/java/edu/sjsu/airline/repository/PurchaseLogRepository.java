package edu.sjsu.airline.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.sjsu.airline.model.RewardLog;

public interface PurchaseLogRepository extends JpaRepository<RewardLog, Long> {
	
	@Query("FROM RewardLog WHERE reservation_reservation_id = :reservationId")
	Optional<ArrayList<RewardLog>> findByReservationId( Long reservationId );
	
	
}
