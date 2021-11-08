package edu.sjsu.airline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.airline.model.RewardLog;
import edu.sjsu.airline.repository.PurchaseLogRepository;

@Service
public class RewardLogService {
	
	private final PurchaseLogRepository purchaseLogRepository;
	
	@Autowired
	public RewardLogService( PurchaseLogRepository purchaseLogRepository ) {
		
		this.purchaseLogRepository = purchaseLogRepository;
		
	}
	
	public void addPurchaseLog( RewardLog purchaseLog ) {
		
		purchaseLogRepository.save(purchaseLog);
		
	}

}
