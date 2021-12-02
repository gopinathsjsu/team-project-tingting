package edu.sjsu.airline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import edu.sjsu.airline.model.User;
import edu.sjsu.airline.model.UserDetail;
import edu.sjsu.airline.repository.UserRepository;


@Service
public class UserService implements UserDetailsService {
	
	@Autowired
    UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) {
		
		User user = userRepository.findByEmail(email).get();
		
		if (user == null)  throw new IllegalStateException("Message:our email or password is incorrect" );
        
        return new UserDetail(user);
		
	}

}
