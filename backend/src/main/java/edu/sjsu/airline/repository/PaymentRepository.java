package edu.sjsu.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.sjsu.airline.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> { }
