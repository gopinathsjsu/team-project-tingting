package edu.sjsu.airline.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.sjsu.airline.customValidator.UniqueAirport;

@Entity
@Table
public class Airport {
	
	@Id
	@Column( unique = true)
	@UniqueAirport
	@NotBlank(message = "Airport Code is mandatory.")
	@Size(min = 3, max = 3, message = "Airport Code should contain 3 characters.")
	private String airportCode;
	
	@NotBlank(message = "Airport name is mandatory.")
	@Size(min = 3, message = "Provide at least 3 characters.")
	private String airportName;
	
	@NotBlank(message = "City is mandatory.")
	@Size(min = 3, message = "Provide at least 3 characters.")
	private String airportCity;
	
	@NotBlank(message = "State is mandatory.")
	@Size(min = 2, message = "Provide at least 2 characters.")
	private String airportState;
	
	@NotBlank(message = "Country is mandatory.")
	@Size(min = 2, message = "Provide at least 2 characters.")
	private String airportCountry;
	
	@JsonIgnore
	@OneToMany
	private Set<Route> routesOrigin;
	
	@JsonIgnore
	@OneToMany
	private Set<Route> routesDestination;
	
	public Airport( ) { }  
	
	public Airport(String airportCode, String name, String city, String state, String country) {
		
		this.airportCode = airportCode;
		this.airportName = name;
		this.airportCity = city;
		this.airportState = state;
		this.airportCountry = country;
		
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getName() {
		return airportName;
	}

	public void setName(String name) {
		this.airportName = name;
	}

	public String getCity() {
		return airportCity;
	}

	public void setCity(String city) {
		this.airportCity = city;
	}

	public String getState() {
		return airportState;
	}

	public void setState(String state) {
		this.airportState = state;
	}

	public String getCountry() {
		return airportCountry;
	}

	public void setCountry(String country) {
		this.airportCountry = country;
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

	@Override
	public String toString() {
		return "Airport [airportCode=" + airportCode + ", airportName=" + airportName + ", airportCity=" + airportCity
				+ ", airportState=" + airportState + ", airportCountry=" + airportCountry + ", routesOrigin="
				+ routesOrigin + ", routesDestination=" + routesDestination + "]";
	}
	
}