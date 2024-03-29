package com.mars.trainticketbooking.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mars.trainticketbooking.springboot.entity.Ticket;

/**
 * @author Madhu
 */
public interface TicketRepository extends JpaRepository<Ticket, String> {

}
