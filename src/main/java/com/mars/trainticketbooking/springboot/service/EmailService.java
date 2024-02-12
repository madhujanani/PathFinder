package com.mars.trainticketbooking.springboot.service;

import org.thymeleaf.context.Context;

import com.mars.trainticketbooking.springboot.model.HtmlEmailRequest;
import com.mars.trainticketbooking.springboot.model.SimpleEmailRequest;

/**
 * @author tjspitz
 */
public interface EmailService {

	/**
	 * @param details
	 */
	public void sendSimpleEmail(SimpleEmailRequest details);
	
	/**
	 * @param details
	 * @param templateName
	 * @param context
	 */
	public void sendHtmlEmail(HtmlEmailRequest details, String templateName, Context context);
}
