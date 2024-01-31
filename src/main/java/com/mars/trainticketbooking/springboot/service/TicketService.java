package com.mars.trainticketbooking.springboot.service;

import java.util.List;

import com.mars.trainticketbooking.springboot.entity.PassengerDetails;

/**
 * @authors madhu, tom, brian, ankita, sai
 */
public interface TicketService {
    /**
     * @return List
     */
    List<PassengerDetails> getpassengers();

    /**
     * Modfies one ticket, based on id (pnr)
     * @author Tom
     * @param ticket
     * @param pnr
     * @return PassengerDetails
     */
    PassengerDetails putTicketByPnr(PassengerDetails ticket, String pnr);

}
