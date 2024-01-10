package com.flight_reservation_app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight_reservation_app.dto.ReservationUpdateRequest;
import com.flight_reservation_app.entity.Passenger;
import com.flight_reservation_app.entity.Reservation;
import com.flight_reservation_app.repository.PassengerRepository;
import com.flight_reservation_app.repository.ReservationRepository;

@RestController    //java object to json object and reverse of that
public class ReservationRestController {
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	@Autowired
	private PassengerRepository pr;
	
	@RequestMapping("/reservation/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {  //pathvariable fetches the id from url i.e postman
		Optional<Reservation> findById = reservationRepo.findById(id);
		Reservation reservation = findById.get();                    //gives exact entity class object
		return reservation;                                         // converts java object into json objects and gives it to user
		
	}
		
	
	@RequestMapping("reservation")
	public Reservation UpdateReservation(@RequestBody ReservationUpdateRequest request ){  //json to java objecti
		Optional<Reservation> findById = reservationRepo.findById(request.getId());
		Reservation reservation = findById.get();                       //we are updating only checkedin and no.of bags in reservation object
		reservation.setCheckedIn(request.isCheckedIn());
		reservation.setNumberofBags(request.getNumberofBags());
		
//		Optional<Passenger> findById2 = pr.findById(request.getId());  //for demo if we want to only change the passenger phonenumber
//		Passenger passenger = findById2.get();
//		passenger.setPhone(request.getPhone());
		
		return reservationRepo.save(reservation);
	}
		
	}


//full json url data is being taken and covert it into java object (in reservationupdaterequest)

//25:23
//Steps:-
//enter the url in postman:-"localhost:8095/flights/reservation/12"
//restcontroller is helpful for restful services

// 2nd is in post add all the details
