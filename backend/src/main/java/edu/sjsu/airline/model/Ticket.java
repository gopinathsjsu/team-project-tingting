package edu.sjsu.airline.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_generator")
	@SequenceGenerator(name="ticket_generator", sequenceName = "ticket_seq", allocationSize=1)
	private Long ticketId;
	
	@JsonIgnore
	@ManyToOne
	private Reservation reservation;
	
	@OneToOne( cascade = CascadeType.MERGE )
	private Seat seat;
	
	private Long eTicketNumber;
	
	private String passengerFirstName;
	
	private String passengerMiddleName;
	
	private String passengerLastName;
	
	private String passengerSuffix;
	
	private LocalDate dataOfBirth;
	
	private String passengerPhoneNumber;
	
	private LocalDateTime cancelDateTime;
	
	public Ticket( ) {  }

	public Ticket( Reservation reservation, String passengerFirstName, String passengerMiddleName, String passengerLastName,
			String passengerSuffix, LocalDate dataOfBirth, String passengerPhoneNumber) {
		
		this.reservation = reservation;
		this.passengerFirstName = passengerFirstName;
		this.passengerMiddleName = passengerMiddleName;
		this.passengerLastName = passengerLastName;
		this.passengerSuffix = passengerSuffix;
		this.dataOfBirth = dataOfBirth;
		this.passengerPhoneNumber = passengerPhoneNumber;
		
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Long geteTicketNumber() {
		return eTicketNumber;
	}

	public void seteTicketNumber(Long eTicketNumber) {
		this.eTicketNumber = eTicketNumber;
	}

	public String getPassengerFirstName() {
		return passengerFirstName;
	}

	public void setPassengerFirstName(String passengerFirstName) {
		this.passengerFirstName = passengerFirstName;
	}

	public String getPassengerMiddleName() {
		return passengerMiddleName;
	}

	public void setPassengerMiddleName(String passengerMiddleName) {
		this.passengerMiddleName = passengerMiddleName;
	}

	public String getPassengerLastName() {
		return passengerLastName;
	}

	public void setPassengerLastName(String passengerLastName) {
		this.passengerLastName = passengerLastName;
	}

	public String getPassengerSuffix() {
		return passengerSuffix;
	}

	public void setPassengerSuffix(String passengerSuffix) {
		this.passengerSuffix = passengerSuffix;
	}

	public LocalDate getDataOfBirth() {
		return dataOfBirth;
	}

	public void setDataOfBirth(LocalDate dataOfBirth) {
		this.dataOfBirth = dataOfBirth;
	}

	public String getPassengerPhoneNumber() {
		return passengerPhoneNumber;
	}

	public void setPassengerPhoneNumber(String passengerPhoneNumber) {
		this.passengerPhoneNumber = passengerPhoneNumber;
	}
	
	public LocalDateTime getCancelDateTime() {
		return cancelDateTime;
	}

	public void setCancelDateTime(LocalDateTime cancelDateTime) {
		this.cancelDateTime = cancelDateTime;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", reservation=" + reservation + ", seat="
				+ seat + ", eTicketNumber=" + eTicketNumber + ", passengerFirstName=" + passengerFirstName
				+ ", passengerMiddleName=" + passengerMiddleName + ", passengerLastName=" + passengerLastName
				+ ", passengerSuffix=" + passengerSuffix + ", dataOfBirth=" + dataOfBirth + ", passengerPhoneNumber="
				+ passengerPhoneNumber + "]";
	}

}