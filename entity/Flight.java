package com.flight_reservation_app.entity;

import java.sql.Timestamp;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Flight extends AbstractEntity{
	
private String flightNumber;
private String operatingAirlines;
private String departureCity;
private String arrivalCity;

//@Temporal(value = TemporalType.DATE)

@Column(name = "date_ofDeparture")   //to encounter error :-java.sql.SQLSyntaxErrorException: Unknown column 'f1_0.dateof_departure' in 'field list'
private Date dateofDeparture;
private Timestamp estimatedDepartureTime;


public String getFlightNumber() {
	return flightNumber;
}
public void setFlightNumber(String flightNumber) {
	this.flightNumber = flightNumber;
}
public String getOperatingAirlines() {
	return operatingAirlines;
}
public void setOperatingAirlines(String operatingAirlines) {
	this.operatingAirlines = operatingAirlines;
}
public String getDepartureCity() {
	return departureCity;
}
public void setDepartureCity(String departureCity) {
	this.departureCity = departureCity;
}
public String getArrivalCity() {
	return arrivalCity;
}
public void setArrivalCity(String arrivalCity) {
	this.arrivalCity = arrivalCity;
}
public Date getDateofDeparture() {
	return dateofDeparture;
}
public void setDateofDeparture(Date dateofDeparture) {
	this.dateofDeparture = dateofDeparture;
}
public Timestamp getEstimatedDepartureTime() {
	return estimatedDepartureTime;
}
public void setEstimatedDepartureTime(Timestamp estimatedDepartureTime) {
	this.estimatedDepartureTime = estimatedDepartureTime;
}


//inheritence concept is used here for the resusability of the code . id is being inherited here

}
