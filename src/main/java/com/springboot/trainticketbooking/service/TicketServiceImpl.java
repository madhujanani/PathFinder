package com.springboot.trainticketbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.trainticketbooking.entity.PassengerDetails;
import com.springboot.trainticketbooking.repository.PassengerDetailsRepository;

public class TicketServiceImpl implements TicketService {

	@Autowired
	PassengerDetailsRepository repository;

	@Override
	public List<PassengerDetails> getpassengers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
