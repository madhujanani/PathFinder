package com.mars.trainticketbooking.springboot;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import com.mars.trainticketbooking.springboot.mailtrap.sendemail.EmailService;

import com.mars.trainticketbooking.springboot.mailtrap.sendemail.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;

/**
 * @author madhu
 *
 */
@SpringBootApplication
public class TrainTicketBookingApplication {

	/**org.springframework.mail.javamail.JavaMailSender'
	 * @param args
	 */
	
	@Autowired
	private EmailService emailService;
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new  WebMvcConfigurer() {
			
			@Override
			public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**").allowedOrigins("http://localhost:3000");
			}
			};
		};
		
		
		
		
	public static void main(String[] args) {
		 SpringApplication.run(TrainTicketBookingApplication.class, args);
//		 ApplicationContext run =
//		TrainTicketBookingApplication app = run.getBean(TrainTicketBookingApplication.class);
//		app.Run();
//			}
//	private void Run() {
//		emailService.sendEmail("jananisrimj@gmail.com", "email from spring boot", "welcome spring boot email");
//	
	}
	
	//for gmail Spring boot email
	@EventListener(ApplicationReadyEvent.class)
	public void sendEmail() {
	emailService.sendEmail("jananisrimj@gmail.com", "email from spring boot", "welcome spring boot email");
	}
	
	@EventListener(ApplicationReadyEvent.class)
	private void htmlMail() throws AddressException, MessagingException {
		emailService.sendHtmlEmail();
	}
	
	@EventListener(ApplicationReadyEvent.class)
	private void htmlWithTemplete() throws AddressException, MessagingException, IOException {
		emailService.sendHtmlTemplate();
	}
	}

