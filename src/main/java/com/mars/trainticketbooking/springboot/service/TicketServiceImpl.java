package com.mars.trainticketbooking.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.trainticketbooking.springboot.entity.PassengerDetails;
import com.mars.trainticketbooking.springboot.repository.PassengerDetailsRepository;

/**
 * @author Madhu
 */
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    PassengerDetailsRepository repository;

    @Override
    public List<PassengerDetails> getpassengers() {
        return repository.findAll();
    }

    /**
     * @author Tom
     */
    @Override
    public PassengerDetails putTicketByPnr(PassengerDetails ticket, String pnr) {
        PassengerDetails ticketToUpdate = repository.getReferenceById(pnr);
        ticketToUpdate.setPassengerName(ticket.getPassengerName());
        ticketToUpdate.setToStation(ticket.getToStation());
        ticketToUpdate.setFromStation(ticket.getFromStation());
        ticketToUpdate.setDateOfTravel(ticket.getDateOfTravel());
        ticketToUpdate.setUpdatedTicketDate(ticket.getUpdatedTicketDate());
        ticketToUpdate.setTrainNo(ticket.getTrainNo());

        ticketToUpdate.setTicketFare(ticketToUpdate.getTicketFare() * 1.5);

        return repository.save(ticketToUpdate);
    }
}
