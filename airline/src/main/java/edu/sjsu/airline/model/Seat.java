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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Entity
@Table
public class Seat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seat_generator")
	@SequenceGenerator(name="seat_generator", sequenceName = "seat_seq", allocationSize=1)
	private Long seatId;
	
	@JsonIgnore
	@ManyToOne( cascade = CascadeType.ALL )
	@JoinColumn( name = "flight_id" )
	private Flight flight;
	
	@OneToOne( mappedBy = "seat" )
	private Ticket ticket;
	
	@Enumerated( EnumType.STRING )
	private SeatStatus seatStatus;
	
	@Enumerated( EnumType.STRING )
	private CabinClass cabinClass;
	
	private int seatNumber;
	
	private char seatPosition;
	
	private double price;
	
	private double milesReward;
	
	public Seat(Flight flight, SeatStatus seatStatus, CabinClass cabinClass, int seatNumber, char seatPosition, double price, double milesReward) {
	
		this.flight = flight;
		this.seatStatus = seatStatus;
		this.cabinClass = cabinClass;
		this.seatNumber = seatNumber;
		this.seatPosition = seatPosition;
		this.price = price;
		this.milesReward = milesReward;
	
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
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getMilesReward() {
		return milesReward;
	}

	public void setMilesReward(double milesReward) {
		this.milesReward = milesReward;
	}
	
}
