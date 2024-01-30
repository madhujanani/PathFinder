package com.springboot.trainticketbooking.service;

import java.util.List;

import com.springboot.trainticketbooking.entity.PassengerDetails;

/**
 * @authors madhu, tom, brian, ankita, sai
 */
public interface TicketService {
    /**
     * @return List
     */
    List<PassengerDetails> getpassengers();

    // create other methods too
    /**
     * @param ticket
     * @param pnr
     * @return PassengerDetails
     */
    PassengerDetails putTicketByPnr(PassengerDetails ticket, String pnr);

}
