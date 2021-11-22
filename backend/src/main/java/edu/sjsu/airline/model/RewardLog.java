package edu.sjsu.airline.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class RewardLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_generator")
	@SequenceGenerator(name="log_generator", sequenceName = "log_seq", allocationSize=1)
	private Long purchaseLogId;
	
	private double miles;
	
	@ManyToOne( cascade = CascadeType.MERGE )
	private RewardAccount rewardAccount;
	
	@ManyToOne( cascade = CascadeType.MERGE )
	private Reservation reservation;
	
	@Enumerated( EnumType.STRING )
	private TypeOfTransaction typeOfTransaction;
	
	private LocalDateTime dateTime;

	public RewardLog( ) { }
			
	public RewardLog( RewardAccount rewardAccount, Reservation reservation, TypeOfTransaction typeOfTransaction ) {
		
		this.rewardAccount = rewardAccount;
		this.reservation = reservation;
		this.typeOfTransaction = typeOfTransaction;
	
	}

	public RewardLog(double miles, RewardAccount rewardAccount, Reservation reservation, TypeOfTransaction typeOfTransaction) {
		
		this.miles = miles;
		this.rewardAccount = rewardAccount;
		this.reservation = reservation;
		this.typeOfTransaction = typeOfTransaction;
	
	}

	public Long getPurchaseLogId() {
		return purchaseLogId;
	}

	public void setPurchaseLogId(Long purchaseLogId) {
		this.purchaseLogId = purchaseLogId;
	}

	public double getMiles() {
		return miles;
	}

	public void setMiles(double miles) {
		this.miles = miles;
	}

	public RewardAccount getRewardAccount() {
		return rewardAccount;
	}

	public void setRewardAccount(RewardAccount rewardAccount) {
		this.rewardAccount = rewardAccount;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public TypeOfTransaction getTypeOfTransaction() {
		return typeOfTransaction;
	}

	public void setTypeOfTransaction(TypeOfTransaction typeOfTransaction) {
		this.typeOfTransaction = typeOfTransaction;
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "PurchaseLog [purchaseLogId=" + purchaseLogId + ", miles=" + miles + ", rewardAccount=" + rewardAccount
				+ ", reservation=" + reservation + ", typeOfTransaction=" + typeOfTransaction + "]";
	}
	
}
