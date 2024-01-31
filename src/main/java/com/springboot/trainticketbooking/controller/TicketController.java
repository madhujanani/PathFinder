package com.springboot.trainticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.trainticketbooking.entity.PassengerDetails;
import com.springboot.trainticketbooking.service.TicketService;

/**
 * @author Madhu
 */
@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    TicketService service;

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
    public ResponseEntity<PassengerDetails> putTicket(
            @RequestBody PassengerDetails ticket, @PathVariable(name = "pnr") String pnr)
    {
        PassengerDetails updatedTicket = service.putTicketByPnr(ticket, pnr);
        return new ResponseEntity<>(updatedTicket, HttpStatus.OK);
    }

}
