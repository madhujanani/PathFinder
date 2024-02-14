package com.mars.trainticketbooking.springboot.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.trainticketbooking.springboot.constant.BookingStatus;
import com.mars.trainticketbooking.springboot.entity.Ticket;
import com.mars.trainticketbooking.springboot.model.PassengerDetails;
import com.mars.trainticketbooking.springboot.repository.TicketRepository;

/**
 * @author Madhu
 */
@Service
public class TicketServiceImpl implements TicketService {
  /**
   * @author Sunil
   */
  // @Autowired
  private TicketRepository repository;

  @Autowired
  public TicketServiceImpl(TicketRepository repository) {
    super();
    this.repository = repository;
  }

  /**
   * @author Madhu
   */
  @Override
  public List<Ticket> getpassengers() {
    return repository.findAll();
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
    ticket.setEmail(passengerdetails.getEmail());
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

  /**
   * @author Tom
   */
  @Override
  public Ticket putTicketByPnr(Ticket ticket, String pnr) {
    Ticket ticketToUpdate = repository.getReferenceById(pnr);
    ticketToUpdate.setPassengerName(ticket.getPassengerName());
    ticketToUpdate.setToStation(ticket.getToStation());
    ticketToUpdate.setFromStation(ticket.getFromStation());
    ticketToUpdate.setDateOfTravel(ticket.getDateOfTravel());
    ticketToUpdate.setUpdatedTicketDate(ticket.getUpdatedTicketDate());
    ticketToUpdate.setTrainNo(ticket.getTrainNo());

    ticketToUpdate.setTicketFare(ticketToUpdate.getTicketFare() * 1.5);

    return repository.save(ticketToUpdate);
  }

  /**
   * @author Tom
   */
  @Override
  public Ticket putTicketConfirmedByPnr(String pnr) {
    Optional<Ticket> preUpdateTicket = repository.findById(pnr);

    if (preUpdateTicket.isPresent()) {
      Ticket postUpdateTicket = preUpdateTicket.get();
      postUpdateTicket.setBookingStatus(BookingStatus.CONFIRMED);
      return repository.save(postUpdateTicket);
    }
    return null;
  }

  /**
   * @author Ankita
   */

  @Override
  public void cancelTicket(String pnr) {
    repository.deleteById(pnr);
  }

}
