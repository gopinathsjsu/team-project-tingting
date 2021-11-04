package edu.sjsu.airline.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	private String email;
	
	private String password;
	
	private List<GrantedAuthority> authorities;
	
	
	public User(String email, String password ) {
		
		this.email = email;
		this.password = password;
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority("CUSTOMER");
		
		return Collections.singleton(authority);
		
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {

		return email;
	}

	@Override
	public boolean isAccountNonExpired() {

		return false;
	}

	@Override
	public boolean isAccountNonLocked() {

		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return false;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}
