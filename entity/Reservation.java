package com.flight_reservation_app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Reservation extends AbstractEntity{

	private boolean checkedIn;
	
	@Column(name = "number_ofBags") 
	private int numberofBags;
	
	@OneToOne
	private Passenger passenger;   //1 to 1 mapping        passenger table is mapped with reservation table
	
	@OneToOne
	private Flight flight;
	
	public boolean isCheckedIn() {
		return checkedIn;
	}
	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	public int getNumberofBags() {
		return numberofBags;
	}
	public void setNumberofBags(int numberofBags) {
		this.numberofBags = numberofBags;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	
}
