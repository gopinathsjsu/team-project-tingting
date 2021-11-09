package edu.sjsu.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.sjsu.airline.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> { }
