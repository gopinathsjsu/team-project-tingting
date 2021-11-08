package edu.sjsu.airline.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Customer extends User {
	
	private String identification;
	
	private String identificationType;
	
	@OneToOne( mappedBy = "customer", cascade = CascadeType.ALL )
	private RewardAccount rewardAccount;
	
	@OneToMany(mappedBy = "customer" )
	private Set<Reservation> reservartions;
	
	public Customer( ) { super(); }
		
	public Customer( String identification, String identificationType) {
		
		super();
		
		this.identification = identification;
		this.identificationType = identificationType;
		
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(String identificationType) {
		this.identificationType = identificationType;
	}

	public RewardAccount getRewardAccount() {
		return rewardAccount;
	}

	public void setRewardAccount(RewardAccount rewardAccount) {
		this.rewardAccount = rewardAccount;
	}

	public Set<Reservation> getReservartions() {
		return reservartions;
	}

	public void setReservartions(Set<Reservation> reservartions) {
		this.reservartions = reservartions;
	}

	@Override
	public String toString() {
		return "Customer [identification=" + identification + ", identificationType=" + identificationType 
				+ ", rewardAccount=" + rewardAccount + ", reservartions=" + reservartions + "]";
	}

}