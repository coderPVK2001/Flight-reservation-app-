package com.flight_reservation_app.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight_reservation_app.entity.Flight;
import com.flight_reservation_app.repository.FlightRepository;

@Controller
public class FlightController {

	@Autowired
	private FlightRepository flightRepo1;
	
	
	@RequestMapping("/findFlights")
	public String findFlights(@RequestParam("from") String from,@RequestParam("to") String to,@RequestParam("departureDate") @DateTimeFormat(pattern="MM-dd-yyyy") Date departureDate, ModelMap modelmap) {   //1 
		List<Flight> findFlights = flightRepo1.findFlights(from ,to , departureDate);
		
		modelmap.addAttribute("findFlights1", findFlights);                              
		return "displayFlights";
	}
	
	
	@RequestMapping("showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelmap1) {
		Optional<Flight> findById = flightRepo1.findById(flightId);
		Flight flight = findById.get();
		modelmap1.addAttribute("flight", flight);
		return "showReservation";
		
//		System.out.println(flight.getArrivalCity());
//		System.out.println(flight.getId());
		
		
	}
	
//	void jio() {
//		flightRepo.findAll();
//	}
	
}

//flight, reservation and others are modules
//in query : INSERT into flight VALUES(1,'AA1','American Airlines','AUS','NYC', STR_TO_DATE('02-03-2023', '%m-%d-%Y'),'2023-02-03 04:12:08')  //IN database it will be stored as YY-MM-DD bcoz of String to date conversion
//while searching in form search by "MM-dd-yyyy" this format
//list of flights to see multiple records
//if 2 objects are created then 2 records will be displayed

//param is opp. of req.param

//Q. what is sql injection?
//-->through edit boxes of app we try to inject sql queries(cheatsheets of sql ) which will reveal all sensitive data(i.e database name ,...) || cheatsheets of sql 1=1 login in hp enter "1=1" it will say enter password which says it is not well tested
//--> we are going to build application without using sql queries in framework due to security threats in sql queries
