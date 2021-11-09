package edu.sjsu.airline.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
*/
import edu.sjsu.airline.service.UserService;
import lombok.AllArgsConstructor;

//@AllArgsConstructor
//@Configuration
//@EnableWebSecurity
public class SecurityConfiguration /*extends WebSecurityConfigurerAdapter*/ {
	
	/*
	@Autowired
	UserService userService;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
        auth.userDetailsService( userService );
        
    }
	
    @Override
	protected void configure( HttpSecurity http ) throws Exception { 
    	
    	http.authorizeRequests().anyRequest().permitAll();
    	
	}
    
    @Bean
    public PasswordEncoder getPasswordEncoder( ) { return NoOpPasswordEncoder.getInstance(); }
	*/
}
