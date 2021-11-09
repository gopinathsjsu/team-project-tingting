package edu.sjsu.airline.model;

import java.time.LocalDate;

public class Traveler {
	
	private int internalId; 
	
	private String passengerFirstName;
	
	private String passengerMiddleName;
	
	private String passengerLastName;
	
	private String passengerSuffix;
	
	private LocalDate dataOfBirth;
	
	private String passengerPhoneNumber;
	
	public Traveler( ) { }

	public Traveler( int internalId, String passengerFirstName, String passengerMiddleName, String passengerLastName, String passengerSuffix, LocalDate dataOfBirth, String passengerPhoneNumber ) {
		
		this.internalId = internalId;
		this.passengerFirstName = passengerFirstName;
		this.passengerMiddleName = passengerMiddleName;
		this.passengerLastName = passengerLastName;
		this.passengerSuffix = passengerSuffix;
		this.dataOfBirth = dataOfBirth;
		this.passengerPhoneNumber = passengerPhoneNumber;
		
	}
	
	public int getInternalId() {
		return internalId;
	}

	public void setInternalId(int internalId) {
		this.internalId = internalId;
	}

	public String getPassengerFirstName() {
		return passengerFirstName;
	}

	public void setPassengerFirstName(String passengerFirstName) {
		this.passengerFirstName = passengerFirstName;
	}

	public String getPassengerMiddleName() {
		return passengerMiddleName;
	}

	public void setPassengerMiddleName(String passengerMiddleName) {
		this.passengerMiddleName = passengerMiddleName;
	}

	public String getPassengerLastName() {
		return passengerLastName;
	}

	public void setPassengerLastName(String passengerLastName) {
		this.passengerLastName = passengerLastName;
	}

	public String getPassengerSuffix() {
		return passengerSuffix;
	}

	public void setPassengerSuffix(String passengerSuffix) {
		this.passengerSuffix = passengerSuffix;
	}

	public LocalDate getDataOfBirth() {
		return dataOfBirth;
	}

	public void setDataOfBirth(LocalDate dataOfBirth) {
		this.dataOfBirth = dataOfBirth;
	}

	public String getPassengerPhoneNumber() {
		return passengerPhoneNumber;
	}

	public void setPassengerPhoneNumber(String passengerPhoneNumber) {
		this.passengerPhoneNumber = passengerPhoneNumber;
	}

	@Override
	public String toString() {
		return "Traveler [passengerFirstName=" + passengerFirstName + ", passengerMiddleName=" + passengerMiddleName
				+ ", passengerLastName=" + passengerLastName + ", passengerSuffix=" + passengerSuffix + ", dataOfBirth="
				+ dataOfBirth + ", passengerPhoneNumber=" + passengerPhoneNumber + "]";
	}
	
}