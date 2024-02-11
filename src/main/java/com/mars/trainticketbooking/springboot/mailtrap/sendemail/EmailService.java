package com.mars.trainticketbooking.springboot.mailtrap.sendemail;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	@Autowired
	private final JavaMailSender mailSender;  //to send emails
	
	public EmailService(JavaMailSender mailSender) { //instance of JMS in constructor
		this.mailSender=mailSender;
	}
	
	@Async
	public void sendEmail(String to,String subject,String body) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(to);
		message.setFrom("madhujananimj@gmail.com");
		message.setSubject(subject);
		message.setText(body);
		
		mailSender.send(message); //JMS instance to send email
		System.out.println("mail send successfully...");
	}
	
	
	public void sendHtmlEmail() throws AddressException, MessagingException {
		MimeMessage message =mailSender.createMimeMessage();
		message.setFrom(new InternetAddress("madhujananimj@gmail.com"));
		message.setRecipients(MimeMessage.RecipientType.TO,"jananisrimj@gmail.com");
		message.setSubject("Test Email for Spring boot without templete with html");
		
		String htmlContent="<h1>Hello i am H1 tag</h1>" +
						"<p>Hi i am a para tag</P>"+
						"<button>Well, i am a button </button>";
		
		message.setContent(htmlContent,"text/html;charset=utf-8");
		mailSender.send(message);
		System.out.println("mail send  using Html successfully...");
	}
	
	public void sendHtmlTemplate() throws AddressException, MessagingException, IOException {
		MimeMessage message =mailSender.createMimeMessage();
		message.setFrom(new InternetAddress("madhujananimj@gmail.com"));
		message.setRecipients(MimeMessage.RecipientType.TO,"jananisrimj@gmail.com");
		String htmlTemplate=readFile("C:\\Users\\gowre\\PathFinder\\src\\main\\resources\\template.html");
		String htmlContent =htmlTemplate.replace("${name}", "John Miller");
	    htmlContent=htmlContent.replace("${message}", "This is a test email for html with template");
		
		message.setContent(htmlContent, "text/html;charset=utf-8");

		mailSender.send(message);
		System.out.println("Html using Template successfully...");

	
	}
	public String readFile(String filePath) throws IOException {
		Path path =Paths.get(filePath);
		return Files.readString(path,StandardCharsets.UTF_8);
	
	}
}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

