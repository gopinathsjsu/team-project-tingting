package edu.sjsu.airline.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
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
	
	@JsonIgnore
	@OneToMany
	private Set<Route> routesOrigin;
	
	@JsonIgnore
	@OneToMany
	private Set<Route> routesDestination;
	
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

	public Set<Route> getRoutesOrigin() {
		return routesOrigin;
	}

	public void setRoutesOrigin(Set<Route> routesOrigin) {
		this.routesOrigin = routesOrigin;
	}

	public Set<Route> getRoutesDestination() {
		return routesDestination;
	}

	public void setRoutesDestination(Set<Route> routesDestination) {
		this.routesDestination = routesDestination;
	}
	
}
