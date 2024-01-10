<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight details</title>
</head>

<style>
body {
  background-image: url("flight.jpg");
}
</style>

<body>

<body>

	<h2>Flight details</h2>
	${flight.id}
	Flight Number : ${flight.flightNumber }</br>
	Operating Airlines  :${flight.operatingAirlines}</br>
	Departure City: ${flight.departureCity }</br>
	Arrival City  : ${flight.arrivalCity }</br>
	Departure Date:${flight.dateofDeparture }</br>
	
	<h2>Enter passenger details</h2>
	<form action="confirmReservation" method="post">
	<pre>
	first name      <input type="text" name="firstName">
	middle name     <input type="text" name="middleName">
	last name       <input type="text" name="lastName">
	email           <input type="text" name="email">
	phone           <input type="text" name="phone">
	<input type="hidden" name="flightId" value="${flight.id}">
	
	
	
	<input type="submit" value="complete reservation">
	
	</pre>
	</form>


</body>
</html>