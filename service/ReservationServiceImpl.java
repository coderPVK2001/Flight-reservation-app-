package com.flight_reservation_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight_reservation_app.dto.ReservationRequest;
import com.flight_reservation_app.entity.Flight;
import com.flight_reservation_app.entity.Passenger;
import com.flight_reservation_app.entity.Reservation;
import com.flight_reservation_app.repository.FlightRepository;
import com.flight_reservation_app.repository.PassengerRepository;
import com.flight_reservation_app.repository.ReservationRepository;
import com.flight_reservation_app.utilities.EmailUtil;
import com.flight_reservation_app.utilities.PdfGenerator1;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	
	@Autowired
	private PassengerRepository passengerRepo;

	@Autowired
	private FlightRepository flightRepo;

	@Autowired
	private ReservationRepository reservationRepo;
	
	@Autowired
	private PdfGenerator1 pdf;

	@Autowired
	private EmailUtil email;

	public Reservation bookFlight(ReservationRequest request) {
//		String firstName  = request.getFirstName();
//		String middleName = request.getMiddleName();
//		String lastName   = request.getLastName();	
//		String email      = request.getEmail();
//		String phone      = request.getPhone();
		
		
		
		Passenger passenger=new Passenger();                          
		passenger.setFirstName(request.getFirstName()); 
		passenger.setLastName(request.getLastName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		passengerRepo.save(passenger);                        
		
		long id = request.getFlightId();
		Optional<Flight> findById = flightRepo.findById(id);
		Flight flight = findById.get();                      
		 
//		Optional<Flight> findById = flightRepo.findById(request.getFlightId());
//		Flight flight = findById.get();
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);            
		reservation.setPassenger(passenger);      
		reservation.setCheckedIn(false);         
		reservation.setNumberofBags(0);           
		
	    reservationRepo.save(reservation);       
		
		String filePath = "C:\\Users\\Prajwal\\OneDrive\\Desktop\\programs\\flight_reservation_app\\flight_reservation_app\\Tickets\\reservation"+reservation.getId()+".pdf";  //will save pdf by unique name by diff. reservation id.	
		pdf.generateItinerary(reservation, filePath);
		
		email.sendItinerary(passenger.getEmail(), filePath);
		
			
		return reservation;  
	} 

//implementation of service layer happens here 
//service layer cannot interact with view layer whereas only controller can

//	for dealing with multiple tables we use service layer
//to inject passenger data
// to inject flight data
//	will save flight details in reservation table
	
//Steps
//once click on form "complete reservation" which calls controller
//reservationrequest dto object is being created ,that objects reference is passed to "request" in above argument
	
//pdf generation starts from here filepath and reservation object is passed to pdfgen1
}