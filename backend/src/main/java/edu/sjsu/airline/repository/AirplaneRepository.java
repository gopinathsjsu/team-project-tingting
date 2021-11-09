package edu.sjsu.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.sjsu.airline.model.Airplane;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> { }
