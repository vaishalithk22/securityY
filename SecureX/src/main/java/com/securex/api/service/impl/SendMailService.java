package com.securex.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class SendMailService
{
	
	@Autowired
	private JavaMailSender javaMailSender;

	
	public void sendMail(String to,String ac) {

	    System.out.println("Sending email...");

	    SimpleMailMessage message = new SimpleMailMessage();
	    message.setTo("vaishalithk22@gmail.com");
	    message.setFrom("securexdonotreply@gmail.com");
	    message.setSubject("Activation Code for registration.");
	    message.setText("The activation code to activate your SecureX accouunt is: "+ac);
	    javaMailSender.send(message);

	    System.out.println("Email Sent!");
	    }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public void sendEmail(String to,String ac)
//	{
//		 String from="securexdonotreply@gmail.com";
//		 String host = "127.0.0.1";
//		 Properties properties = System.getProperties();
//		 properties.setProperty("mail.smtp.host", host);
//		 Session session = Session.getDefaultInstance(properties);
//		 try
//		 {
//			 MimeMessage message = new MimeMessage(session);
//			 message.setFrom(new InternetAddress(from));
//			 message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//			 message.setSubject("Activation Code for login.");
//			 message.setText(ac);
//			 Transport.send(message);
//		 }
//		 catch(MessagingException e) 
//		 {
//	         e.printStackTrace();
//		 }
//
//	}
	
	
	
	
	
	
}
