package com.springboot.trainingticketbooking.repository;


	
import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.trainticketbooking.entity.Ticket;
	 
	/**
	* @author Madhu
	*/
	public interface TicketRepository extends JpaRepository<Ticket, String> {
	 
	}


