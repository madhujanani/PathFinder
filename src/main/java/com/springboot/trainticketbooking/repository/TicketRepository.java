package com.springboot.trainticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.trainticketbooking.entity.Ticket;

/**
 * @author Sai
 */
public interface TicketRepository extends JpaRepository<Ticket, String> {

}