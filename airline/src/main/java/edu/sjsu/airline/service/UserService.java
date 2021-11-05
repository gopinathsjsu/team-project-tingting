package edu.sjsu.airline.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.sjsu.airline.model.User;
import edu.sjsu.airline.model.UserDetail;
import edu.sjsu.airline.repository.CustomerRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
    CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		System.out.println("Teste 1 :" + email);
		
		Optional<User> user = customerRepository.findByEmail( email );
				
		user.orElseThrow(() -> new UsernameNotFoundException( "User not found: " + email ) );
		
		System.out.println("Teste 3");

        return user.map( UserDetail::new ).get();
		
	}

}
