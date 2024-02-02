
package com.springboot.trainticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.trainticketbooking.entity.Ticket;
import com.springboot.trainticketbooking.model.PassengerDetails;
import com.springboot.trainticketbooking.service.TicketService;

/**
 * @author Madhu Sai
 */
@RestController
@RequestMapping("/api/ticket")
public class TicketController {

	@Autowired
	TicketService service;

	/**
	 * @author sai
	 */

	@PostMapping("/bookticket")
	public ResponseEntity<Ticket> bookticket(@RequestBody PassengerDetails passengerdetails) {
		Ticket newTicket = service.bookTicket(passengerdetails);
		return new ResponseEntity<Ticket>(newTicket, HttpStatus.CREATED);
	}

}
