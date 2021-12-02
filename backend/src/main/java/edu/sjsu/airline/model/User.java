package edu.sjsu.airline.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import edu.sjsu.airline.customValidator.DateOfBirth;
import edu.sjsu.airline.customValidator.UniqueEmail;

@Entity
@Table
@Inheritance( strategy = InheritanceType.JOINED )
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
	@SequenceGenerator(name="user_generator", sequenceName = "user_seq", allocationSize=1)
	private Long userId;
	
	@NotBlank(message = "First name is mandatory.")
	@Size(min = 2, message = "Provide at least 2 characters.")
	private String firstName;
	
	private String middleName;
	
	@NotBlank(message = "Last name is mandatory.")
	@Size(min = 2, message = "Provide at least 2 characters.")
	private String lastName;
	
	@DateOfBirth( )
	private LocalDate dateOfBirth;
	
	@NotBlank(message = "Address is mandatory.")
	private String address1;
	
	private String address2;
	
	@NotBlank(message = "City is mandatory.")
	private String city;
	
	@NotBlank(message = "State is mandatory.")
	private String state;
	
	@NotBlank(message = "Country is mandatory.")
	private String country;
	
	@NotBlank(message = "Zipcode is mandatory.")
	private String zipCode;
	
	@NotBlank(message = "Email is mandatory.")
	@Email(message = "This is not a valid Email." )
	@UniqueEmail( )
	private String email;
	
	@NotBlank(message = "Phone number is mandatory.")
	private String phoneNumber;
	
	@NotBlank(message = "Password is mandatory.")
	@Size(min = 6, message = "Provide at least 6 characters.")
	private String password;
	
	private boolean active;
	
	private String roles;
	
	public User() { }
	
	public User(String firstName, String middleName, String lastName, LocalDate dataOfBith, String address1,
			String address2, String city, String state, String country, String zipCode, String email,
			String phoneNumber, String password, boolean active, String roles) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dataOfBith;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.active = active;
		this.roles = roles;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDataOfBith() {
		return dateOfBirth;
	}

	public void setDataOfBith(LocalDate dataOfBith) {
		this.dateOfBirth = dataOfBith;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = true;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", dataOfBith=" + dateOfBirth + ", address1=" + address1 + ", address2=" + address2
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", zipCode=" + zipCode + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", password=" + password + ", active=" + active + ", roles="
				+ roles + "]";
	}
    
}
