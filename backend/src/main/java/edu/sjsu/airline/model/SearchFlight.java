package edu.sjsu.airline.model;

import java.time.LocalDate;

import javax.validation.constraints.Min;

import edu.sjsu.airline.customValidator.AirportCode;
import edu.sjsu.airline.customValidator.PastDate;

public class SearchFlight {
	
	@AirportCode
	private String originAirport;
	
	@AirportCode
	private String returnAirport;
	
	@PastDate( message = "Departure date shouldn't be in the past." )
	private LocalDate departureDate;
	
	@PastDate( message = "Return date shouldn't be in the past." )
	private LocalDate returnDate;
	
	@Min( value = 1, message = "The minimum number of passenger is 1")
	private int qtyPassager;
	
	public SearchFlight( ) { }
	
	public SearchFlight(String originAirport, String returnAirport, LocalDate departureDate, LocalDate returnDate, int qtyPassager) {
		
		this.originAirport = originAirport;
		this.returnAirport = returnAirport;
		this.departureDate = departureDate;
		this.returnDate = returnDate;
		this.qtyPassager = qtyPassager;
		
	}

	public String getOriginAirport() {
		return originAirport;
	}

	public void setOriginAirport(String originAirport) {
		this.originAirport = originAirport;
	}

	public String getReturnAirport() {
		return returnAirport;
	}

	public void setReturnAirport(String returnAirport) {
		this.returnAirport = returnAirport;
	}



	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public int getQtyPassager() {
		return qtyPassager;
	}

	public void setQtyPassager(int qtyPassager) {
		this.qtyPassager = qtyPassager;
	}

	@Override
	public String toString() {
		return "SearchFlight [originAirport=" + originAirport + ", returnAirport=" + returnAirport + ", departureDate="
				+ departureDate + ", returnDate=" + returnDate + ", qtyPassager=" + qtyPassager + "]";
	}

}