package com.springboot.trainticketbooking.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Madhu, Tom
 * 
 */

@NoArgsConstructor
@Entity
@Data
@AllArgsConstructor
public class PassengerDetails {

    @Id
    private String pnr = makeId();

    private String passengerName;
    private String fromStation;
    private String toStation;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateOfTravel;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date updatedTicketDate;

    private String trainNo;

    private LocalDate dateOfBooking = java.time.LocalDate.now();

    private String bookingStatus = new Random().nextBoolean() ? "confirmed" : "waiting";

    private double ticketFair = Math.floor(Math.random() * 31) + 50;

    private String makeId() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase().substring(0, 7);
    }

}
