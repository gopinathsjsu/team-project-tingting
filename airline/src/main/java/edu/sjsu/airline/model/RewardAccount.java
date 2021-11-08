package edu.sjsu.airline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class RewardAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reward_account_generator")
	@SequenceGenerator(name="reward_account_generator", sequenceName = "reward_account_seq", allocationSize=1)
	private Long rewardAccountId;
	
	private String accountnumber;
	
	private double balance;
	
	@JsonIgnore
	@OneToOne
	private Customer customer;
	
	public RewardAccount( ) { }
	
	public RewardAccount(Customer customer, String accountnumber, double balance) {
		
		this.customer = customer;
		this.accountnumber = accountnumber;
		this.balance = balance;
		
	}

	public Long getRewardAccountId() {
		return rewardAccountId;
	}

	public void setRewardAccountId(Long rewardAccountId) {
		this.rewardAccountId = rewardAccountId;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "RewardAccount [rewardAccountId=" + rewardAccountId + ", accountnumber=" + accountnumber + ", balance="
				+ balance + ", customer=" + customer + "]";
	}
	
}