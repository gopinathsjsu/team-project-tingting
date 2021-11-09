package edu.sjsu.airline.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Employee extends User {

	private LocalDate hiredDate;
	
	@Enumerated( EnumType.STRING )
	private Position position;
	
	@JsonIgnore
	@ManyToMany( mappedBy = "crew" )
	private Set<Flight> flights = new HashSet<>();
	
	public Employee( ) { super(); }
	
	public Employee(LocalDate hiredDate, Position position) {
		
		super();
		
		this.hiredDate = hiredDate;
		this.position = position;
		
	}

	public LocalDate getHiredDate() {
		return hiredDate;
	}

	public void setHiredDate(LocalDate hiredDate) {
		this.hiredDate = hiredDate;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Set<Flight> getFlights() {
		return flights;
	}

	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}

	@Override
	public String toString() {
		return "Employee [hiredDate=" + hiredDate + ", position=" + position + ", flights=" + flights + "]";
	}
	
}