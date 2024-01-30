package com.springboot.trainticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.trainticketbooking.service.TicketService;

@RestController
@RequestMapping(" ")
public class TicketController {

	@Autowired
	TicketService service;

}
