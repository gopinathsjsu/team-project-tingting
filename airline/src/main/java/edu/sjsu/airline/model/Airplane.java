package edu.sjsu.airline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Airplane {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long airplaneId;
	
	private String airplaneCode;
	
	private String model;
	
	private String manufacture;
	
	private int numberOfSeats;
	
	public Airplane() {}

	public Airplane(String airplaneCode, String model, String manufacture, int numberOfSeats) {
		
		this.airplaneCode = airplaneCode;
		this.model = model;
		this.manufacture = manufacture;
		this.numberOfSeats = numberOfSeats;
		
	}

	public Long getAirplaneId() {
		return airplaneId;
	}

	public void setAirplaneId(Long airplaneId) {
		this.airplaneId = airplaneId;
	}

	public String getAirplaneCode() {
		return airplaneCode;
	}

	public void setAirplaneCode(String airplaneCode) {
		this.airplaneCode = airplaneCode;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	@Override
	public String toString() {
		return "Airplane [airplaneId=" + airplaneId + ", airplaneCode=" + airplaneCode + ", model=" + model
				+ ", manufacture=" + manufacture + ", numberOfSeats=" + numberOfSeats + "]";
	}
	
}
