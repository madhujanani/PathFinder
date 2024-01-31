package com.mars.trainticketbooking.springboot.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Madhu, Tom
 * 
 */

@NoArgsConstructor
@Entity
@Data
public class PassengerDetails {

    @Id
    private String pnr = UUID
            .randomUUID()
            .toString()
            .replace("-", "")
            .toUpperCase()
            .substring(0,7);

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

    private double ticketFare = Math.floor(Math.random() * 31) + 50;

    // We need a constructor that can requires only the fields present in a POST or
    // PUT request... an AllArgsConstructor won't work
    /**
     * @param passengerName
     * @param fromStation
     * @param toStation
     * @param dateOfTravel
     * @param trainNo
     */
    public PassengerDetails(String passengerName, String fromStation, 
            String toStation, Date dateOfTravel, String trainNo) 
    {
        super();
        this.passengerName = passengerName;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.dateOfTravel = dateOfTravel;
        this.trainNo = trainNo;
    }

}
