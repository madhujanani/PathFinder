package com.mars.trainticketbooking.springboot.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author tjspitz
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class HtmlEmailRequest extends SimpleEmailRequest {
	
	private String pnr;
	private LocalDate travelDate;
	private double fare;
}
