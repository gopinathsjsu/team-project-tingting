package edu.sjsu.airline.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Airport {
	
	@Id
	@Column( unique = true)
	private String airportCode;
	
	private String name;
	
	private String city;
	
	private String state;
	
	private String country;
	
	@OneToMany
	private Set<Route> routesOrigin;
	
	@OneToMany
	private Set<Route> routesDestination;
	
	public Airport( ) { }

	public Airport(String airportCode, String name, String city, String state, String country) {
		
		this.airportCode = airportCode;
		this.name = name;
		this.city = city;
		this.state = state;
		this.country = country;
		
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "Airport [airportCode=" + airportCode + ", name=" + name + ", city=" + city + ", state=" + state
				+ ", country=" + country + "]";
	}
	
}
