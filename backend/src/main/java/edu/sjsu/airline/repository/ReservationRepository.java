package edu.sjsu.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.sjsu.airline.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> { }
