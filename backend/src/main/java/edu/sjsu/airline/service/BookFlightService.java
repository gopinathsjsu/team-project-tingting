package edu.sjsu.airline.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import edu.sjsu.airline.model.Flight;
import edu.sjsu.airline.model.Payment;
import edu.sjsu.airline.model.RewardLog;
import edu.sjsu.airline.model.Reservation;
import edu.sjsu.airline.model.SeatStatus;
import edu.sjsu.airline.model.Ticket;
import edu.sjsu.airline.model.Traveler;
import edu.sjsu.airline.model.TypeOfTransaction;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BookFlightService {

	@Autowired
	private FlightService flightService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private SeatService seatService;

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private RewardLogService purchaseLogService;

	private Reservation reservation;

	private Flight departingFlight;

	private Flight returningFlight;

	private HashMap<Integer, Ticket> departingTickets = new HashMap<>();

	private HashMap<Integer, Ticket> returningTickets = new HashMap<>();

	public void assignCustomer(Long userId) {

		reservation = new Reservation(LocalDateTime.now(), customerService.getByCustomerId(userId));

	}

	public void assignDepartingFlight(Long flightId) {

		departingFlight = flightService.getByFlightId(flightId);

	}

	public void assignReturnFlight(Long flightId) {

		returningFlight = flightService.getByFlightId(flightId);

	}

	public void assignTravelersToTicket(List<Traveler> travelers) {

		for (Traveler traveler : travelers) {

			Ticket ticket = new Ticket(reservation, traveler.getPassengerFirstName(), traveler.getPassengerMiddleName(),
					traveler.getPassengerLastName(), traveler.getPassengerSuffix(), traveler.getDataOfBirth(),
					traveler.getPassengerPhoneNumber());

			if (departingFlight != null)

				departingTickets.put(traveler.getInternalId(), ticket);

			if (returningFlight != null)

				returningTickets.put(traveler.getInternalId(), ticket);

		}

	}

	public void assignSeatToTicket(int travelerId, Long flightId, boolean isDeparting) {

		if (isDeparting)

			departingTickets.get(travelerId).setSeat(seatService.getBySeatId(flightId));

		else

			returningTickets.get(travelerId).setSeat(seatService.getBySeatId(flightId));

	}

	public void checkoutFlight(Payment payment) {

		double totalValue = 0;

		double totalReward = payment.getTotalCreditCardPayment() / 20;
		double totalPaid = payment.getTotalCreditCardPayment() + payment.getTotalRewardPayment();

		RewardLog purchaseLogSell = new RewardLog();
		RewardLog purchaseLogBuy = new RewardLog();

		payment.setTotal(totalPaid);
		payment.setReservation(reservation);

		for (Ticket ticket : departingTickets.values()) {

			ticket.getSeat().setSeatStatus(SeatStatus.NotAvaiable);

			ticket.seteTicketNumber(System.currentTimeMillis());

			totalValue += ticket.getSeat().getPrice();

			reservation.getTickets().add(ticket);

		}

		for (Ticket ticket : returningTickets.values()) {

			ticket.getSeat().setSeatStatus(SeatStatus.NotAvaiable);

			ticket.seteTicketNumber(System.currentTimeMillis());

			totalValue += ticket.getSeat().getPrice();

			reservation.getTickets().add(ticket);

		}

		// Raise exception if user don't pay for the whole reservation
		if (totalPaid != totalValue) {

			throw new IllegalStateException("The amount paid ( " + totalPaid
					+ " ) does not correspond to the total amount of the reservation ( " + totalValue + " ).");

		}

		// New entry on the Purchase Log for using the reward as payment
		if (payment.getTotalRewardPayment() > 0) {

			// Raise exception if user try to use more reward that they have
			if (payment.getTotalRewardPayment() > reservation.getCustomer().getRewardAccount().getBalance()) {

				throw new IllegalStateException("The maximum amount of reward available is "
						+ reservation.getCustomer().getRewardAccount().getBalance() + ".");

			}

			purchaseLogSell.setRewardAccount(reservation.getCustomer().getRewardAccount());
			purchaseLogSell.setReservation(reservation);
			purchaseLogSell.setTypeOfTransaction(TypeOfTransaction.SELL);
			purchaseLogSell.setMiles(payment.getTotalRewardPayment());

		}

		reservation.getCustomer().getRewardAccount()
				.setBalance(reservation.getCustomer().getRewardAccount().getBalance() - payment.getTotalRewardPayment()
						+ totalReward);

		// New entry on the Purchase Log for buying a new ticket
		if (totalReward > 0) {

			purchaseLogBuy.setRewardAccount(reservation.getCustomer().getRewardAccount());
			purchaseLogBuy.setReservation(reservation);
			purchaseLogBuy.setTypeOfTransaction(TypeOfTransaction.BUY);
			purchaseLogBuy.setMiles(totalReward);

		}

		reservation.setPayment(payment);

		reservationService.addReservation(reservation);

		updateSeats();

		customerService.updateRewardAccount(reservation.getCustomer().getRewardAccount());

		if (purchaseLogSell.getMiles() > 0) {

			purchaseLogService.addPurchaseLog(purchaseLogSell);

		}

		if (purchaseLogBuy.getMiles() > 0) {

			purchaseLogService.addPurchaseLog(purchaseLogBuy);

		}

	}

	public List<Ticket> getTickets() {

		ArrayList<Ticket> tickets = new ArrayList<>();

		tickets.addAll(departingTickets.values());

		tickets.addAll(returningTickets.values());

		return tickets;

	}

	private void updateSeats() {

		for (Ticket ticket : departingTickets.values()) {

			seatService.updateSeat(ticket.getSeat());

		}

		for (Ticket ticket : returningTickets.values()) {

			seatService.updateSeat(ticket.getSeat());

		}

	}

}