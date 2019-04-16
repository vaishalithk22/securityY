package com.securex.api.service.impl;
//package com.securex.api.service.impl;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//@Service
//public class SendMailService
//{
//	
//	@Autowired
//	private JavaMailSender javaMailSender;
//
//	
//	public void sendMail(String to,String ac) {
//
//	    System.out.println("Sending email...");
//
//	    SimpleMailMessage message = new SimpleMailMessage();
//	    message.setTo("vaishalithk22@gmail.com");
//	    message.setFrom("securexdonotreply@gmail.com");
//	    message.setSubject("Activation Code for registration.");
//	    message.setText("The activation code to activate your SecureX accouunt is: "+ac);
//	    javaMailSender.send(message);
//
//	    System.out.println("Email Sent!");
//	    }
//
//	
//}
