package edu.sjsu.airline.security;

import static javax.servlet.http.HttpServletResponse.SC_FORBIDDEN;
//import static javax.servlet.http.HttpServletResponse.SC_OK;
import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.sjsu.airline.service.UserService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserService userService;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
        auth.userDetailsService( userService );
        
        
    }
	
    @Override
	protected void configure( HttpSecurity http ) throws Exception { 
		
    	http
		.csrf().disable()
		.httpBasic().and()
		.authorizeRequests()
			.antMatchers(HttpMethod.POST ,"/api/v*/customer").permitAll()
			.antMatchers("/api/v1/airport").hasRole("CUSTOMER")
			.antMatchers("/api/v1/airplane").hasRole("ADMIN");
		//.exceptionHandling()
        //    .accessDeniedHandler((req, resp, ex) -> resp.setStatus( SC_FORBIDDEN ) )
        //    .authenticationEntryPoint((req, resp, ex) -> resp.setStatus( SC_UNAUTHORIZED ) ).and()
        //.formLogin();
    	
	}
    
    @Bean
    public PasswordEncoder getPasswordEncoder( ) { return NoOpPasswordEncoder.getInstance(); }
		
}
