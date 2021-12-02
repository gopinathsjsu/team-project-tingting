package edu.sjsu.airline.model;

import java.time.LocalDateTime;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

import edu.sjsu.airline.customValidator.AirportCode;
import edu.sjsu.airline.customValidator.PastDateTime;

public class NewFlightRequest {
	
	private Long flightId;
	
	@Digits( fraction = 0, integer = 4, message = "Flight number should contain 4 characters" )
	@Min( value = 999, message = "Flight number should contain 4 characters")
	private int flightNumber;
	
	@PastDateTime( message = "Estimated Departure time shouldn't be in the past." )
	private LocalDateTime estimatedDepartureDateTime;
	
	@PastDateTime( message = "Estimated Arrival time shouldn't be in the past." )
	private LocalDateTime estimatedArrivalDateTime;
	
	@AirportCode
	private String routeCode;
	
	private Long airplaneId;
	
	public NewFlightRequest( ) { }

	public NewFlightRequest(int flightNumber, LocalDateTime estimatedDepartureDateTime, LocalDateTime estimatedArrivalDateTime, String routeCode, Long airplaneId) {
		
		this.flightNumber = flightNumber;
		this.estimatedDepartureDateTime = estimatedDepartureDateTime;
		this.estimatedArrivalDateTime = estimatedArrivalDateTime;
		this.routeCode = routeCode;
		this.airplaneId = airplaneId;
		
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

	public String getRouteCode() {
		return routeCode;
	}

	public void setRouteCode(String routeCode) {
		this.routeCode = routeCode;
	}

	public Long getAirplaneId() {
		return airplaneId;
	}

	public void setAirplaneId(Long airplaneId) {
		this.airplaneId = airplaneId;
	}

	@Override
	public String toString() {
		return "NewFlightRequest [flightId=" + flightId + ", flightNumber=" + flightNumber
				+ ", estimatedDepartureDateTime=" + estimatedDepartureDateTime + ", estimatedArrivalDateTime="
				+ estimatedArrivalDateTime + ", routeCode=" + routeCode + ", airplaneId=" + airplaneId + "]";
	}

}
