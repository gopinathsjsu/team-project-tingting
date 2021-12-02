package edu.sjsu.airline.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.sjsu.airline.customValidator.EnumPattern;

@Entity
@Table
public class Seat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seat_generator")
	@SequenceGenerator(name="seat_generator", sequenceName = "seat_seq", allocationSize=1)
	private Long seatId;
	
	@EnumPattern( regexp = "NotAvaiable|Avaiable" )
	@Enumerated( EnumType.STRING )
	private SeatStatus seatStatus;
	
	@EnumPattern( regexp = "Economy|Business|FirstClass" )
	@Enumerated( EnumType.STRING )
	private CabinClass cabinClass;
	
	@Min( value = 1, message = "Seat number is mandatory")
	private int seatNumber;
	
	@NotNull(message = "Seat position is mandatory.")
	private char seatPosition;
	
	@DecimalMin( value = "0.00", message = "Seat price is mandatory")
	private double seatPrice;
	
	@JsonIgnore
	@ManyToOne( cascade = CascadeType.MERGE )
	@JoinColumn( name = "flight_id" )
	private Flight flight;
	
	@JsonIgnore
	@OneToOne
	private Ticket ticket;
	
	@Transient
	private Long flightId;
	
	public Seat( ) { }
	
	public Seat(Flight flight, SeatStatus seatStatus, CabinClass cabinClass, int seatNumber, char seatPosition, double price ) {
	
		this.flight = flight;
		this.seatStatus = seatStatus;
		this.cabinClass = cabinClass;
		this.seatNumber = seatNumber;
		this.seatPosition = seatPosition;
		this.seatPrice = price;
		
	}

	public Long getSeatId() {
		return seatId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public SeatStatus getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(SeatStatus seatStatus) {
		this.seatStatus = seatStatus;
	}

	public CabinClass getCabinClass() {
		return cabinClass;
	}

	public void setCabinClass(CabinClass cabinClass) {
		this.cabinClass = cabinClass;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public char getSeatPosition() {
		return seatPosition;
	}

	public void setSeatPosition(char seatPosition) {
		this.seatPosition = seatPosition;
	}

	public double getPrice() {
		return seatPrice;
	}

	public void setPrice(double price) {
		this.seatPrice = price;
	}

	public Long getFlightId() {
		
		return flight == null ? flightId : flight.getFlightId() ;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}
	
}
