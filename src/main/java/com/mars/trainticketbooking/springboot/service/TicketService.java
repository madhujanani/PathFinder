package com.mars.trainticketbooking.springboot.service;

import java.util.List;

import com.mars.trainticketbooking.springboot.entity.Ticket;
import com.mars.trainticketbooking.springboot.model.PassengerDetails;

/**
 * @authors madhu, tom, brian, ankita, sai
 */
public interface TicketService {
    /**
     * @return List
     */
    List<Ticket> getpassengers();

    /**
     * Modfies one ticket, based on id (pnr)
     * @author Tom
     * @param ticket
     * @param pnr
     * @return PassengerDetails
     */
    Ticket putTicketByPnr(Ticket ticket, String pnr);
    
    /**
     * @author Tom
     * @param pnr
     * @return Ticket
     */
    public Ticket putTicketConfirmedByPnr(String pnr);
    
	Ticket bookTicket(PassengerDetails passengerdetails);
	void cancelTicket(String pnr);
	

}
