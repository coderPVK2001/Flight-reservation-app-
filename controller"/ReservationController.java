package com.flight_reservation_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flight_reservation_app.dto.ReservationRequest;
import com.flight_reservation_app.entity.Reservation;
import com.flight_reservation_app.service.ReservationService;
import com.flight_reservation_app.service.ReservationServiceImpl;
import com.flight_reservation_app.utilities.PdfGenerator;

@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;   
	
	@RequestMapping("/confirmReservation")           
	public String confirmReservation(ReservationRequest request, ModelMap modelmap) {  
		Reservation reservationId = reservationService.bookFlight(request);         
//		modelmap.addAttribute("reservationId",reservationId);
		
//	    we can generate pdf here as well
//		PdfGenerator pdf = new PdfGenerator();
//		pdf.generatePDF(filePath+reservationId.getId()+".pdf", reservationId.getPassenger().getFirstName(), reservationId.getPassenger().getEmail(), reservationId.getPassenger().getPhone(), reservationId.getFlight().getOperatingAirlines(), reservationId.getFlight().getDateofDeparture(), reservationId.getFlight().getDepartureCity(), reservationId.getFlight().getArrivalCity());
		
		modelmap.addAttribute("reservationId",reservationId.getId());
		
		
		
		return "confirmReservation";                                  
	
	}
}

// steps --> view layer-->controller-->service-->database

//to get info from showreservation jsp we need to use @requestparam for too many times so we created a class called "ReservationRequest" 
//which will take data from form and put this in object "request" in [1]
//process also called as dto data object which takes data from form  and transfers data into object
//dto layer which reduces the code length   lengthier


//steps :- after taking data and storing it in "request" object it will be transferred to Service layer 
//now service layer has method bookFlight

// itextpdf is an API in pom.xml
// itext is java library
//create utilities layer //common layer for all modules

//34:54
