package com.mars.trainticketbooking.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.mars.trainticketbooking.springboot.model.HtmlEmailRequest;
import com.mars.trainticketbooking.springboot.model.SimpleEmailRequest;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

/**
 * @author tjspitz
 */
@Service
public class EmailServiceImpl implements EmailService {

	private final JavaMailSender mailSender;
	private final TemplateEngine templateEngine;

	/**
	 * @param mailSender
	 * @param templateEngine
	 */
	@Autowired
	public EmailServiceImpl(JavaMailSender mailSender, TemplateEngine templateEngine) {
		this.mailSender = mailSender;
		this.templateEngine = templateEngine;
	}

	@Override
	public void sendSimpleEmail(SimpleEmailRequest details) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(details.getRecipient());
		message.setSubject(details.getSubject());
		message.setText(details.getBody());
		mailSender.send(message);
	}

	@Override
	public void sendHtmlEmail(HtmlEmailRequest details, String templateName, Context context) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");

		try {
			helper.setTo(details.getRecipient());
			helper.setSubject(details.getSubject());
			String htmlContent = templateEngine.process(templateName, context);
			helper.setText(htmlContent, true);
			mailSender.send(mimeMessage);
		} catch (MessagingException e) {
			System.out.println("Error sending HTML email...");
			e.printStackTrace();
		}
	}
}
