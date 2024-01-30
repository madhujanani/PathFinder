package com.springboot.trainticketbooking.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
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

	private Random pnr = new Random();

	private LocalDate dateOfBooking = java.time.LocalDate.now();

	private String bookingStatus = new Random().nextBoolean() ? "confirmed" : "waiting";

	private double ticketFair = Math.floor(Math.random() * 31) + 50;

}
