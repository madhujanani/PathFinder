package com.mars.trainticketbooking.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

import com.mars.trainticketbooking.springboot.model.HtmlEmailRequest;
import com.mars.trainticketbooking.springboot.model.SimpleEmailRequest;
import com.mars.trainticketbooking.springboot.service.EmailService;

/**
 * @author tjspitz
 */
@RestController
@RequestMapping("/api/email")
public class EmailController {

	private final EmailService service;

	@Autowired
	public EmailController(EmailService service) {
		this.service = service;
	}

	@PostMapping("/send-simple")
	public String sendSimpleEmail(@RequestBody SimpleEmailRequest email) {
		service.sendSimpleEmail(email);
		return "Success: simple email sent!";
	}
	
	@PostMapping("/send-html")
	public String sendHtmlEmail(@RequestBody HtmlEmailRequest email) {
		Context context = new Context();
		context.setVariable("pnr", email.getPnr());
		context.setVariable("travelDate", email.getTravelDate());
		context.setVariable("fare", email.getFare());

		service.sendHtmlEmail(email, "email", context);
		return "Success: HTML email sent!";
	}
}
