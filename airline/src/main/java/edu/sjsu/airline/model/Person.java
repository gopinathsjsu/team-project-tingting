package edu.sjsu.airline.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table
@Inheritance( strategy = InheritanceType.JOINED )
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long personId;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private LocalDate dataOfBith;
	
	private String address1;
	
	private String address2;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String zipCode;
	
	private String email;
	
	private String phoneNumber;
	
	public Person() { }

	public Person(String firstName, String middleName, String lastName, LocalDate dataOfBith, String address1,
			String address2, String city, String state, String country, String zipCode, String email,
			String phoneNumber) {
		
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dataOfBith = dataOfBith;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
		this.email = email;
		this.phoneNumber = phoneNumber;
		
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDataOfBith() {
		return dataOfBith;
	}

	public void setDataOfBith(LocalDate dataOfBith) {
		this.dataOfBith = dataOfBith;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", dataOfBith=" + dataOfBith + ", address1=" + address1 + ", address2="
				+ address2 + ", city=" + city + ", state=" + state + ", country=" + country + ", zipCode=" + zipCode
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
	
}
