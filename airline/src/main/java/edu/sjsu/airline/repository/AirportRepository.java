package edu.sjsu.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.sjsu.airline.model.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String> { }
