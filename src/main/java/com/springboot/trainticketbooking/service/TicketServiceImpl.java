
package com.springboot.trainticketbooking.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.trainticketbooking.constant.BookingStatus;
import com.springboot.trainticketbooking.entity.Ticket;
import com.springboot.trainticketbooking.model.PassengerDetails;
import com.springboot.trainticketbooking.repository.TicketRepository;

/**
 * @author Madhu
 */

@Service
public class TicketServiceImpl implements TicketService {

	// @Autowired
	private TicketRepository repository;

	@Autowired
	public TicketServiceImpl(TicketRepository repository) {
		super();
		this.repository = repository;
	}

	/**
	 * @author Sai
	 */

	@Override
	public Ticket bookTicket(PassengerDetails passengerdetails) {
		// generate the random booking status to the train ticket
		Random random = new Random();
		int index = random.nextInt(BookingStatus.values().length);
		BookingStatus randomStatus = BookingStatus.values()[index];
		// generate a PNR ticket using Random, UUID, or external API
		UUID uuid = UUID.randomUUID();
		String pnr = uuid.toString().replace("-", "").substring(0, 7);
		// generate a random TicketFair
		int randomNumber = (int) (Math.random() * 9999);
		if (randomNumber <= 1000) {
			randomNumber = randomNumber + 1000;
		}

		Ticket ticket = new Ticket();
		ticket.setPassengerName(passengerdetails.getPassengerName());
		ticket.setToStation(passengerdetails.getToStation());
		ticket.setFromStation(passengerdetails.getFromStation());
		ticket.setDateOfTravel(passengerdetails.getDateOfTravel());
		ticket.setTrainNo(passengerdetails.getTrainNo());
		ticket.setPnr(pnr);
		ticket.setDateOfBooking(java.time.LocalDate.now());
		ticket.setBookingStatus(randomStatus);
		ticket.setTicketFare(randomNumber);

		// save the ticket to the database using the ticketRepository
		repository.save(ticket);

		// return the ticket
		return ticket;
	}

}
