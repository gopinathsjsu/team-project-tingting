package edu.sjsu.airline.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reser_generator")
	@SequenceGenerator(name="reser_generator", sequenceName = "reservation_seq", allocationSize=1)
	private Long reservationId;
	
	private LocalDateTime date;
	
	private LocalDateTime canceledDate;
	
	@JsonIgnore
	@ManyToOne
	private Customer customer;
	
	@OneToOne( mappedBy = "reservation", cascade = CascadeType.ALL )
	private Payment payment;
	
	@OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL )
	private Set<Ticket> tickets = new HashSet<Ticket>();
	
	public Reservation( ) { }
	
	public Reservation( LocalDateTime date, Customer customer ) {
		
		this.date = date;
		this.customer = customer;
		
	}
	
	public Reservation(LocalDateTime date, Customer customer, Payment payment, Set<Ticket> tickets ) {
		
		this.date = date;
		this.customer = customer;
		this.payment = payment;
		this.tickets = tickets;
		
	}

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public LocalDateTime getCanceledDate() {
		return canceledDate;
	}

	public void setCanceledDate(LocalDateTime canceledDate) {
		this.canceledDate = canceledDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", date=" + date + ", customer=" + customer
				+ ", payment=" + payment + ", tickets=" + tickets + "]";
	}
	
}
