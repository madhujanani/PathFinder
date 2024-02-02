package com.mars.trainticketbooking.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mars.trainticketbooking.springboot.entity.Ticket;
import com.mars.trainticketbooking.springboot.model.PassengerDetails;
import com.mars.trainticketbooking.springboot.service.TicketService;

/**
 * @author Madhu
 */
@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    TicketService service;   
    
    
    @PostMapping("/bookticket")
    public ResponseEntity<Ticket> bookticket( @RequestBody PassengerDetails passengerdetails){
		Ticket newTicket = service.bookTicket(passengerdetails);
		return  new ResponseEntity<Ticket>(newTicket,HttpStatus.CREATED);
	}

    /**
     * Modfies one ticket, based on id (pnr).
     * The RequestBody should have an "updatedTicketDate": "dd-mm-yyyy" property,
     * in addition to passengerName, toStation, fromStation, dateOfTravel, and trainNo props.
     * Your ticket fare will be increased by 1.5x, because capitalism.
     * @author Tom
     * @param ticket
     * @param pnr
     * @return ResponseEntity
     */
    @PutMapping("/{pnr}")
    public ResponseEntity<Ticket> putTicket(
            @RequestBody Ticket ticket, @PathVariable(name = "pnr") String pnr)
    {
        Ticket updatedTicket = service.putTicketByPnr(ticket, pnr);
        return new ResponseEntity<>(updatedTicket, HttpStatus.OK);
    }

}
