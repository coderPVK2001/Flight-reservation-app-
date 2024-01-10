package com.flight_reservation_app.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass              //Designates a class whose mapping information is applied to the entities that inherit from it.
//                               A mapped superclass has no separate table defined for it.

public class AbstractEntity {                     //***inheritance concept is implemented in project to show that id is common so we used inheritance                   
	
	@Id                                                     //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)     //auto generated values
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
