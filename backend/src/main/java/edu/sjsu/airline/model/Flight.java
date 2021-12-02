package edu.sjsu.airline.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long flightId;
	
	private int flightNumber;
	
	private LocalDateTime estimatedDepartureDateTime;
	
	private LocalDateTime estimatedArrivalDateTime;
	
	private LocalDateTime departureDateTime;
	
	private LocalDateTime arrivalDateTime;
	
	@ManyToOne
	private Route route;
	
	@ManyToOne
	private Airplane flightEquipment;
	
	@ManyToMany
	@JoinTable( name = "crew" )
	private Set<Employee> crew;
	
	@OneToMany(mappedBy = "flight" )
	private Set<Seat> seats;
	
	public Flight( ) {  }

	public Flight(int flightNumber, LocalDateTime estimatedDepartureDateTime, LocalDateTime estimatedArrivalDateTime ) {
		
		this.flightNumber = flightNumber;
		this.estimatedDepartureDateTime = estimatedDepartureDateTime;
		this.estimatedArrivalDateTime = estimatedArrivalDateTime;

	}
	
	public Flight(int flightNumber, Route route, Airplane flightEquipment, LocalDateTime estimatedDepartureDateTime,
			LocalDateTime estimatedArrivalDateTime, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime,
			Set<Employee> crew, Set<Seat> seats) {
		
		this.flightNumber = flightNumber;
		this.route = route;
		this.flightEquipment = flightEquipment;
		this.estimatedDepartureDateTime = estimatedDepartureDateTime;
		this.estimatedArrivalDateTime = estimatedArrivalDateTime;
		this.departureDateTime = departureDateTime;
		this.arrivalDateTime = arrivalDateTime;
		this.crew = crew;
		this.seats = seats;
		
	}
	
	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public LocalDateTime getEstimatedDepartureDateTime() {
		return estimatedDepartureDateTime;
	}

	public void setEstimatedDepartureDateTime(LocalDateTime estimatedDepartureDateTime) {
		this.estimatedDepartureDateTime = estimatedDepartureDateTime;
	}

	public LocalDateTime getEstimatedArrivalDateTime() {
		return estimatedArrivalDateTime;
	}

	public void setEstimatedArrivalDateTime(LocalDateTime estimatedArrivalDateTime) {
		this.estimatedArrivalDateTime = estimatedArrivalDateTime;
	}

	public LocalDateTime getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(LocalDateTime departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public LocalDateTime getArrivalDateTime() {
		return arrivalDateTime;
	}

	public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}

	public Set<Seat> getSeats() {
		return seats;
	}

	public void setSeats(Set<Seat> seats) {
		this.seats = seats;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Airplane getFlightEquipment() {
		return flightEquipment;
	}

	public void setFlightEquipment(Airplane flightEquipment) {
		this.flightEquipment = flightEquipment;
	}

	public Set<Employee> getCrew() {
		return crew;
	}

	public void setCrew(Set<Employee> crew) {
		this.crew = crew;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", flightNumber=" + flightNumber + ", route=" + route
				+ ", flightEquipment=" + flightEquipment + ", estimatedDepartureDateTime=" + estimatedDepartureDateTime
				+ ", estimatedArrivalDateTime=" + estimatedArrivalDateTime + ", departureDateTime=" + departureDateTime
				+ ", arrivalDateTime=" + arrivalDateTime + ", crew=" + crew + ", seats=" + seats + "]";
	}
	
}