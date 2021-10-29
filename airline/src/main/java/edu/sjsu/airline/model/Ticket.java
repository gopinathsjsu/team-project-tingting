package edu.sjsu.airline.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_generator")
	@SequenceGenerator(name="ticket_generator", sequenceName = "ticket_seq", allocationSize=1)
	private Long ticketId;
	
	@ManyToOne( cascade = CascadeType.ALL )
	private Customer customer;
	
	@OneToOne( cascade = CascadeType.ALL )
	private Seat seat;
	
	private Long eTicketNumber;
	
	private String passengerFirstName;
	
	private String passengerLastName;
	
	private String passengerIdentification;
	
	private String passengerTypeOfIdentification;
	
	private String passengerPhoneNumber;
	
	private String passengerAddress1;
	
	private String passengerAddress2;
	
	private String passengerCity;
	
	private String passengerState;
	
	private String passengerCountry;
	
	public Ticket() { }

	public Ticket(Customer customer, Seat seat, Long eTicketNumber, String passengerFirstName, String passengerLastName,
			String passengerIdentification, String passengerTypeOfIdentification, String passengerPhoneNumber,
			String passengerAddress1, String passengerAddress2, String passengerCity, String passengerState,
			String passengerCountry) {
		
		this.customer = customer;
		this.seat = seat;
		this.eTicketNumber = eTicketNumber;
		this.passengerFirstName = passengerFirstName;
		this.passengerLastName = passengerLastName;
		this.passengerIdentification = passengerIdentification;
		this.passengerTypeOfIdentification = passengerTypeOfIdentification;
		this.passengerPhoneNumber = passengerPhoneNumber;
		this.passengerAddress1 = passengerAddress1;
		this.passengerAddress2 = passengerAddress2;
		this.passengerCity = passengerCity;
		this.passengerState = passengerState;
		this.passengerCountry = passengerCountry;
		
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public String getPassengerLastName() {
		return passengerLastName;
	}

	public void setPassengerLastName(String passengerLastName) {
		this.passengerLastName = passengerLastName;
	}

	public String getPassengerIdentification() {
		return passengerIdentification;
	}

	public void setPassengerIdentification(String passengerIdentification) {
		this.passengerIdentification = passengerIdentification;
	}

	public String getPassengerTypeOfIdentification() {
		return passengerTypeOfIdentification;
	}

	public void setPassengerTypeOfIdentification(String passengerTypeOfIdentification) {
		this.passengerTypeOfIdentification = passengerTypeOfIdentification;
	}

	public String getPassengerPhoneNumber() {
		return passengerPhoneNumber;
	}

	public void setPassengerPhoneNumber(String passengerPhoneNumber) {
		this.passengerPhoneNumber = passengerPhoneNumber;
	}

	public String getPassengerAddress1() {
		return passengerAddress1;
	}

	public void setPassengerAddress1(String passengerAddress1) {
		this.passengerAddress1 = passengerAddress1;
	}

	public String getPassengerAddress2() {
		return passengerAddress2;
	}

	public void setPassengerAddress2(String passengerAddress2) {
		this.passengerAddress2 = passengerAddress2;
	}

	public String getPassengerCity() {
		return passengerCity;
	}

	public void setPassengerCity(String passengerCity) {
		this.passengerCity = passengerCity;
	}

	public String getPassengerState() {
		return passengerState;
	}

	public void setPassengerState(String passengerState) {
		this.passengerState = passengerState;
	}

	public String getPassengerCountry() {
		return passengerCountry;
	}

	public void setPassengerCountry(String passengerCountry) {
		this.passengerCountry = passengerCountry;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", customer=" + customer + ", seat=" + seat + ", eTicketNumber="
				+ eTicketNumber + ", passengerFirstName=" + passengerFirstName + ", passengerLastName="
				+ passengerLastName + ", passengerIdentification=" + passengerIdentification
				+ ", passengerTypeOfIdentification=" + passengerTypeOfIdentification + ", passengerPhoneNumber="
				+ passengerPhoneNumber + ", passengerAddress1=" + passengerAddress1 + ", passengerAddress2="
				+ passengerAddress2 + ", passengerCity=" + passengerCity + ", passengerState=" + passengerState
				+ ", passengerCountry=" + passengerCountry + "]";
	}
	
}
