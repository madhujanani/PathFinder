package com.mars.trainticketbooking.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    
    @PostMapping("/new")
    public ResponseEntity<Ticket> bookticket( @RequestBody PassengerDetails passengerdetails){
		Ticket newTicket = service.bookTicket(passengerdetails);
		return  new ResponseEntity<Ticket>(newTicket,HttpStatus.CREATED);
	}
    
    
	@GetMapping("/passengers")
	public ResponseEntity< List<Ticket> >users(){  // as we need to give the httpstatus to client,, we should not use thes user class object directly,,so we are using ResponseEntity to also send the httpstatus.
		List <Ticket>userList = service.getpassengers();
		return  new ResponseEntity<>(userList,HttpStatus.OK);
		}
	
	
	@GetMapping("/passenger/{pnr}")//get the row by unique id
	public ResponseEntity<Ticket>getUserById(@PathVariable("pnr")String id){
		Ticket userById = service.getPassengerByPnr(id);
		return new ResponseEntity<Ticket>(userById,HttpStatus.OK);
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
    
    /**
	 * Cancel one ticket, based on (pnr)
	 * 
	 * @author Ankita
	 * @param pnr
	 */
	@DeleteMapping("cancelticket/{pnr}")
	public ResponseEntity<Ticket> ticketCancellation(@PathVariable String pnr) {
		service.cancelTicket(pnr);
		return new ResponseEntity<Ticket>(HttpStatus.OK);
	}


}
