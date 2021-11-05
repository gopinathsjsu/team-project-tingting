package edu.sjsu.airline.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Entity
@Table
public class Customer extends User {
	
	private String accountnumber;
	
	private String identification;
	
	private String identificationType;
	
	@OneToOne( mappedBy = "customer" )
	private RewardAccount rewardAccount;
	
	@OneToMany( mappedBy = "customer" )
	private Set<Ticket> ticket;
	
	public Customer(String accountnumber, String password, String identification, String identificationType) {
		
		super();
		
		this.accountnumber = accountnumber;
		this.identification = identification;
		this.identificationType = identificationType;
		
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
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

	public Set<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(Set<Ticket> ticket) {
		this.ticket = ticket;
	}

}
