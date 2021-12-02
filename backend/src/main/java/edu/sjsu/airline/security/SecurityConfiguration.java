package edu.sjsu.airline.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.sjsu.airline.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userService; 
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
    	
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        
        authProvider.setUserDetailsService(userService);
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
        auth.authenticationProvider(authenticationProvider());
        
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	
    	http.csrf().disable();
    	
    	http.authorizeRequests()
			.antMatchers("/api**").permitAll();
    	
    	/*
    	http.authorizeRequests()
    		.antMatchers("/api/v1/airplane").hasRole("ADMIN")
    		.antMatchers("/api/v1/airport").hasRole("ADMIN")
    		.antMatchers("/api/v1/employee").hasRole("ADMIN")
    		.antMatchers("/api/v1/route").hasRole("ADMIN")
    		.antMatchers("/api/v1/seat").hasRole("ADMIN");
    	
    	http.authorizeRequests()
			.antMatchers("/api/v1/flight/find").hasAnyRole("USER", "ADMIN")
			.antMatchers("/api/v1/login").hasAnyRole("USER", "ADMIN");;
    	
    	http.authorizeRequests()
    		.antMatchers(HttpMethod.POST, "/api/v1/customer").permitAll();
    	
    	
    	http.logout().logoutUrl("/api/v1/logout");
    	
    	http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    	*/
    	
    	
    	
    }
	
}