package edu.sjsu.airline.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table
public class Employee extends Person {

	private LocalDate hiredDate;
	
	@Enumerated( EnumType.STRING )
	private Position position;
	
	public Employee (  ) { super(); }

	public Employee(LocalDate hiredDate, Position position) {
		
		super();
		
		this.hiredDate = hiredDate;
		this.position = position;
		
	}

	public LocalDate getHiredDate() {
		return hiredDate;
	}

	public void setHiredDate(LocalDate hiredDate) {
		this.hiredDate = hiredDate;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Employee [hiredDate=" + hiredDate + ", position=" + position + "]";
	}
	
}

