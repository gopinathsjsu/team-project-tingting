package edu.sjsu.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.sjsu.airline.model.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> { }
