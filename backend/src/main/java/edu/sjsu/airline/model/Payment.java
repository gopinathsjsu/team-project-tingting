package edu.sjsu.airline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paymt_generator")
	@SequenceGenerator(name="paymt_generator", sequenceName = "payment_seq", allocationSize=1)
	private Long paymentId;

	@JsonIgnore
	@OneToOne
	private Reservation reservation;
	
	private double total;
	
	private double totalCreditCardPayment;
	
	private double totalRewardPayment;
	
	private String creditCardNumber;
	
	private String cardExpDate;
	
	private String cardName;
	
	private String billingAddress1;
	
	private String billingAddress2;
	
	private String billingCity;
	
	private String billingState;
	
	private String billingZipCode;
	
	private String billingCountry;
	
	private String billingPhoneNumber;
	
	private String billingEmail;
	
	public Payment( ) { }

	public Payment(Reservation reservation, double total, double totalCreditCardPayment, double totalRewardPayment,
			String creditCardNumber, String cardExpDate, String cardName, String billingAddress1,
			String billingAddress2, String billingCity, String billingState, String billingZipCode,
			String billingCountry, String billingPhoneNumber, String billingEmail) {
		
		this.reservation = reservation;
		this.total = total;
		this.totalCreditCardPayment = totalCreditCardPayment;
		this.totalRewardPayment = totalRewardPayment;
		this.creditCardNumber = creditCardNumber;
		this.cardExpDate = cardExpDate;
		this.cardName = cardName;
		this.billingAddress1 = billingAddress1;
		this.billingAddress2 = billingAddress2;
		this.billingCity = billingCity;
		this.billingState = billingState;
		this.billingZipCode = billingZipCode;
		this.billingCountry = billingCountry;
		this.billingPhoneNumber = billingPhoneNumber;
		this.billingEmail = billingEmail;
	
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotalCreditCardPayment() {
		return totalCreditCardPayment;
	}

	public void setTotalCreditCardPayment(double totalCreditCardPayment) {
		this.totalCreditCardPayment = totalCreditCardPayment;
	}

	public double getTotalRewardPayment() {
		return totalRewardPayment;
	}

	public void setTotalRewardPayment(double totalRewardPayment) {
		this.totalRewardPayment = totalRewardPayment;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getCardExpDate() {
		return cardExpDate;
	}

	public void setCardExpDate(String cardExpDate) {
		this.cardExpDate = cardExpDate;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getBillingAddress1() {
		return billingAddress1;
	}

	public void setBillingAddress1(String billingAddress1) {
		this.billingAddress1 = billingAddress1;
	}

	public String getBillingAddress2() {
		return billingAddress2;
	}

	public void setBillingAddress2(String billingAddress2) {
		this.billingAddress2 = billingAddress2;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getBillingState() {
		return billingState;
	}

	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}

	public String getBillingZipCode() {
		return billingZipCode;
	}

	public void setBillingZipCode(String billingZipCode) {
		this.billingZipCode = billingZipCode;
	}

	public String getBillingCountry() {
		return billingCountry;
	}

	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}

	public String getBillingPhoneNumber() {
		return billingPhoneNumber;
	}

	public void setBillingPhoneNumber(String billingPhoneNumber) {
		this.billingPhoneNumber = billingPhoneNumber;
	}

	public String getBillingEmail() {
		return billingEmail;
	}

	public void setBillingEmail(String billingEmail) {
		this.billingEmail = billingEmail;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", reservation=" + reservation + ", total=" + total
				+ ", totalCreditCardPayment=" + totalCreditCardPayment + ", totalRewardPayment=" + totalRewardPayment
				+ ", creditCardNumber=" + creditCardNumber + ", cardExpDate=" + cardExpDate + ", cardName=" + cardName
				+ ", billingAddress1=" + billingAddress1 + ", billingAddress2=" + billingAddress2 + ", billingCity="
				+ billingCity + ", billingState=" + billingState + ", billingZipCode=" + billingZipCode
				+ ", billingCountry=" + billingCountry + ", billingPhoneNumber=" + billingPhoneNumber
				+ ", billingEmail=" + billingEmail + "]";
	}
	
}
