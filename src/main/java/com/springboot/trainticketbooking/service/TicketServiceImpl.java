package com.springboot.trainticketbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.trainticketbooking.entity.PassengerDetails;
import com.springboot.trainticketbooking.repository.PassengerDetailsRepository;

/**
 * @author Madhu, Tom
 */
public class TicketServiceImpl implements TicketService {

    @Autowired
    PassengerDetailsRepository repository;

    @Override
    public List<PassengerDetails> getpassengers() {
        return repository.findAll();
    }

    @Override
    public PassengerDetails putTicketByPnr(PassengerDetails ticket, String pnr) {
        PassengerDetails ticketToUpdate = repository.getReferenceById(pnr);
        ticketToUpdate.setPassengerName(ticket.getPassengerName());
        ticketToUpdate.setToStation(ticket.getToStation());
        ticketToUpdate.setFromStation(ticket.getFromStation());
        ticketToUpdate.setDateOfTravel(ticket.getDateOfTravel());
        ticketToUpdate.setUpdatedTicketDate(ticket.getUpdatedTicketDate());
        ticketToUpdate.setTrainNo(ticket.getTrainNo());

        ticketToUpdate.setTicketFair(ticketToUpdate.getTicketFair() * 1.5);

        return repository.save(ticketToUpdate);
    }

}
