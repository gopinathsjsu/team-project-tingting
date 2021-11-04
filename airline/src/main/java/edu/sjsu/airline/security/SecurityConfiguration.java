package edu.sjsu.airline.security;

import static javax.servlet.http.HttpServletResponse.SC_FORBIDDEN;
//import static javax.servlet.http.HttpServletResponse.SC_OK;
import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.sjsu.airline.service.UserService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private UserService userService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
        auth.authenticationProvider(daoAuthenticationProvider());
    }
	
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
    	
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        
        provider.setPasswordEncoder( bCryptPasswordEncoder );
        provider.setUserDetailsService( userService );
        
        return provider;
    }
    
	@Override
	protected void configure( HttpSecurity http ) throws Exception { 
		
		http
			.csrf().disable()
			.requestCache().disable()
			.authorizeRequests()
				.antMatchers("/api/v*/airport").permitAll()
				.antMatchers("/api/v*/customer/login").permitAll()
				.antMatchers("/**").hasRole("CUSTOMER").and()
			.exceptionHandling()
                .accessDeniedHandler((req, resp, ex) -> resp.setStatus( SC_FORBIDDEN ) )
                .authenticationEntryPoint((req, resp, ex) -> resp.setStatus( SC_UNAUTHORIZED ) );
		
	}
	
}
