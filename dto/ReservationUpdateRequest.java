package com.flight_reservation_app.dto;

public class ReservationUpdateRequest {
	
	private long id;
	private boolean checkedIn;
	private int numberofBags;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	
	
//same as dto layer 
	//but here data will be taken from json object and stored it in this class java object 
	
//	private String phone; //for demo purpose
//
//	public String getPhone() {
//		return phone;
//	}
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
}
