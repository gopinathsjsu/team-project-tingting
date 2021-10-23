package edu.sjsu.airline.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Customer extends Person {
	
	private String accountnumber;
	
	private String password;
	
	private String identification;
	
	private String identificationType;
	
	public Customer (  ) { super(); }

	public Customer(String accountnumber, String password, String identification, String identificationType) {
		
		super();
		
		this.accountnumber = accountnumber;
		this.password = password;
		this.identification = identification;
		this.identificationType = identificationType;
		
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "Employee [accountnumber=" + accountnumber + ", password=" + password + ", identification="
				+ identification + ", identificationType=" + identificationType + "]";
	}

}
