package edu.sjsu.airline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Airplane {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airplane_generator")
	@SequenceGenerator(name="airplane_generator", sequenceName = "airplane_seq", allocationSize=1)
	private Long airplaneId;
	
	private String airplaneCode;
	
	private String airplaneModel;
	
	private String airplaneManufacture;
	
	private int numberOfSeats;
	
	public Airplane( ) { }
	
	public Airplane(String airplaneCode, String airplaneModel, String airplaneManufacture, int numberOfSeats) {
		
		this.airplaneCode = airplaneCode;
		this.airplaneModel = airplaneModel;
		this.airplaneManufacture = airplaneManufacture;
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

	public String getAirplaneModel() {
		return airplaneModel;
	}

	public void setAirplaneModel(String airplaneModel) {
		this.airplaneModel = airplaneModel;
	}

	public String getAirplaneManufacture() {
		return airplaneManufacture;
	}

	public void setAirplaneManufacture(String airplaneManufacture) {
		this.airplaneManufacture = airplaneManufacture;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	@Override
	public String toString() {
		return "Airplane [airplaneId=" + airplaneId + ", airplaneCode=" + airplaneCode + ", airplaneModel="
				+ airplaneModel + ", airplaneManufacture=" + airplaneManufacture + ", numberOfSeats=" + numberOfSeats
				+ "]";
	}
	
}
