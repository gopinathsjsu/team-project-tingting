package edu.sjsu.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.sjsu.airline.model.RewardLog;

public interface PurchaseLogRepository extends JpaRepository<RewardLog, Long> { }
