package com.flight_reservation_app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flight_reservation_app.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {


//	void findFlights();         change it to list of flights and start writing code

	@Query("from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateofDeparture=:dateofDeparture ")   //departureCity(entity class) is mapped with database table
	List<Flight> findFlights(@Param("departureCity") String from,@Param("arrivalCity") String to,@Param("dateofDeparture") Date departureDate);
//	List<Flight> findFlights(@Param("departureCity")String from,@Param("arrivalCity") String to,@Param("dateofDeparture") Date departureDate);
	
}

// whenever we call the method("findFlights" in flightcontroller)  it will get called here ,
//@param will take the data from ("from" :-eg. "mumbai") and copy it in departureCity ,same for all
// departureCity, arrivalCity ,.. are entity class and it will get stored in particular query with syntax (" =: ")
//we are returning flights objects/ data in list

//
//
