package edu.sjsu.airline.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Route {
	
	@Id
	private String routeCode;
	
	@ManyToOne( cascade = CascadeType.ALL )
	private Airport originAirport;
	
	@ManyToOne( cascade = CascadeType.ALL )
	private Airport destinationAirport;
	
	private double distance;
	
	private boolean isActive;
	
	public Route( ) { }

	public Route(String routeCode, Airport originAirport, Airport destinationAirport, double distance, boolean isActive) {

		this.routeCode = routeCode;
		this.originAirport = originAirport;
		this.destinationAirport = destinationAirport;
		this.distance = distance;
		this.isActive = isActive;
		
	}

	public String getRouteCode() {
		return routeCode;
	}

	public void setRouteCode(String routeCode) {
		this.routeCode = routeCode;
	}

	public Airport getOriginAirport() {
		return originAirport;
	}

	public void setOriginAirport(Airport originAirport) {
		this.originAirport = originAirport;
	}

	public Airport getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Route [routeCode=" + routeCode + ", originAirport=" + originAirport + ", destinationAirport="
				+ destinationAirport + ", distance=" + distance + ", isActive=" + isActive + "]";
	}
	
}
