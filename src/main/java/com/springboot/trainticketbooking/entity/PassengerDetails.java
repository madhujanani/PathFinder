package com.springboot.trainticketbooking.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author madhu
 *
 */

@NoArgsConstructor
@Entity
@Data
@AllArgsConstructor
public class PassengerDetails {

	private String passengerName;
	private String fromStation;
	private String toStation;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateOfTravel;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date updatedTicketDate;

	private String trainNo;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String pnr;

	private Date dateOfBooking;

	private String bookingStatus;

	private long ticketFair;

}
