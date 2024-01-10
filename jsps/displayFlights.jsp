 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display flights</title>
</head>

<style>
body {
  background-image: url("flight.jpg");
}
</style>

<body>

<body>

	<h2>Flight Search Results</h2>
	<h2>List of flights</h2>
	
<table border="1">
   <tr>
   <th>Airlines</th>
   <th>Departure City</th>
   <th>Arrival City</th>
   <th>Departure Time</th>
   <th>Select Flight</th>
   </tr>
	
	<c:forEach items="${findFlights1 }" var="findFlights"> 
     <tr>
       <td>${findFlights.operatingAirlines}</td>
       <td>${findFlights.departureCity}</td>
       <td>${findFlights.arrivalCity}</td>
       <td>${findFlights.estimatedDepartureTime}</td>
       <td><a href="showCompleteReservation?flightId=${findFlights.id}">select</a></td>
       
     </tr>
   </c:forEach>

</table>

</body>
</html>