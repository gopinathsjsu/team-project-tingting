package edu.sjsu.airline.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.airline.model.RewardAccount;
import edu.sjsu.airline.model.RewardLog;
import edu.sjsu.airline.model.Ticket;
import edu.sjsu.airline.model.TypeOfTransaction;
import edu.sjsu.airline.repository.PurchaseLogRepository;
import edu.sjsu.airline.repository.RewardAccountRepository;

@Service
public class RewardLogService {
	
	@Autowired
	private PurchaseLogRepository purchaseLogRepository;
	
	@Autowired
	private RewardAccountRepository rewardAccountRepository;
	
	public void addPurchaseLog( RewardLog purchaseLog ) {
		
		purchaseLogRepository.save(purchaseLog);
		
	}
	
	public ArrayList<RewardLog> getPurchaseLog( Long purchaseLogId ) {
		
		return purchaseLogRepository.findByReservationId(purchaseLogId).get();
		
	}
	
	public void cancelPurchase( ArrayList<RewardLog> purchaseLogs, LocalDateTime dateTime ) {
		
		double balance = 0;
		
		RewardAccount rewardAccount = null;
		
		for( RewardLog rewardLog : purchaseLogs ) {
			
			if( rewardLog.getTypeOfTransaction() == TypeOfTransaction.CANCEL ) continue;
				
			RewardLog cancelPurchaseLog = new RewardLog( rewardLog.getMiles(), rewardLog.getRewardAccount(), rewardLog.getReservation(), TypeOfTransaction.CANCEL );
			
			cancelPurchaseLog.setDateTime(dateTime);
			
			purchaseLogRepository.save(cancelPurchaseLog);
			
			if( rewardLog.getTypeOfTransaction() == TypeOfTransaction.BUY ) {
				
				balance -= rewardLog.getMiles();  
				
			} else if ( rewardLog.getTypeOfTransaction() == TypeOfTransaction.SELL ) {
				
				balance += rewardLog.getMiles();
				
			}
			
			if ( rewardAccount == null ) rewardAccount = rewardLog.getRewardAccount();
			
		}
		
		rewardAccount.setBalance( rewardAccount.getBalance() + balance );
		
		rewardAccountRepository.save( rewardAccount );
		
	}
	
	public void refundTicket( Ticket ticket, LocalDateTime dateTime ) {
		
		RewardAccount rewardAccount = ticket.getReservation().getCustomer().getRewardAccount();
		
		RewardLog cancelPurchaseLog = new RewardLog( ticket.getSeat().getPrice(), rewardAccount, ticket.getReservation(), TypeOfTransaction.REFUND );
		
		cancelPurchaseLog.setDateTime(dateTime);
		
		purchaseLogRepository.save(cancelPurchaseLog);
		
		rewardAccount.setBalance( rewardAccount.getBalance() + ticket.getSeat().getPrice() );
		
		rewardAccountRepository.save( rewardAccount );
		
	}

}
