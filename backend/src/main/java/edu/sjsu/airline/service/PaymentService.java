package edu.sjsu.airline.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.airline.model.Payment;
import edu.sjsu.airline.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	public void cancelPayment( Payment payment, LocalDateTime dateTime ) {
		
		payment.setCancelDateTime( LocalDateTime.now() );
		
		paymentRepository.save( payment );
		
	}
	
}
