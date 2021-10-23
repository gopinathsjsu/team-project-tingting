package edu.sjsu.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.sjsu.airline.model.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, String> { }
