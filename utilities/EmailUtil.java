package com.flight_reservation_app.utilities;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtil {
	
	@Autowired
	private JavaMailSender sender;
	
	public void sendItinerary(String toAddress, String filePath) {
		
	MimeMessage message = sender.createMimeMessage();
	try {
	MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
	messageHelper.setTo(toAddress);
	messageHelper.setSubject("Itinerary Of Flight");
	messageHelper.setText("Your ticket is booked successfully !!\nPlease find the reservation details in the attached pdf");
	messageHelper.addAttachment("Itinerary", new File(filePath) );
	sender.send(message);
	}catch (MessagingException e) {
	e.printStackTrace();
	}
	}

}
