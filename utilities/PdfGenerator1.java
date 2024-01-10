package com.flight_reservation_app.utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.flight_reservation_app.entity.Reservation;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class PdfGenerator1 {
	
	public void generateItinerary(Reservation reservation,String filePath) {  //takes reservation object and filepath from service layer
		
		Document document = new Document();          //built-in or predefined classes
		try {
		
		PdfWriter.getInstance(document, new FileOutputStream(filePath));  //outputstream writes content into file
		
		document.open();
		
		document.add(generateTable(reservation));
		
		document.close();
		} catch (Exception e) {   //catch (FileNotFoundException | DocumentException e)
		e.printStackTrace();
		}
		}
		
		
		private Element generateTable(Reservation reservation) {
		// TODO Auto-generated method stub
			
		PdfPTable table= new PdfPTable(2);  //no.of columns
		table.setWidthPercentage(100);
		PdfPCell cell;
		
		cell = new PdfPCell(new Phrase("Flight itinerary"));
		cell.setColspan(2);
		table.addCell(cell);                                     //incomplete
		
		cell=new PdfPCell(new Phrase("Flight details"));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);       //to make elements center
		cell.setColspan(2);
		table.addCell(cell); 
		
		table.addCell("Departure city");
		table.addCell(reservation.getFlight().getDepartureCity());  //one to one mapping // so getflight will give flight object address
		
		table.addCell("Arrival city");
		table.addCell(reservation.getFlight().getArrivalCity());
		
		table.addCell("Flight Number");
		table.addCell(reservation.getFlight().getFlightNumber());
		
		table.addCell("operating airline");
		table.addCell(reservation.getFlight().getOperatingAirlines());
		
		table.addCell("departure date");
		table.addCell(reservation.getFlight().getDateofDeparture().toString());
		
		table.addCell("departure time");
		table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());
		
		cell= new PdfPCell(new Phrase("Passenger details"));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);               
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("First name");
		table.addCell(reservation.getPassenger().getFirstName());
		
		table.addCell("Last name");
		table.addCell(reservation.getPassenger().getLastName());
		
		table.addCell("Email");
		table.addCell(reservation.getPassenger().getEmail());
		
		table.addCell("mobile number");
		table.addCell(reservation.getPassenger().getPhone());
			
		return table;
	}


	}//18:00


//component :- is a stereotype
// if we want to create a bean in class then autowired will see for @component and then creation will happen
//is an annotation that allows Spring to detect our custom beans automatically


