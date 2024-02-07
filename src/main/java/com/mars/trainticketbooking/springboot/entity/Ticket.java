package com.mars.trainticketbooking.springboot.entity;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mars.trainticketbooking.springboot.constant.BookingStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Ticket {

    @Id
    private String pnr;

    private String passengerName;
    private String fromStation;
    private String toStation;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateOfTravel;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date updatedTicketDate;

    private String trainNo;

    private LocalDate dateOfBooking = java.time.LocalDate.now();

    /**
     * @author Sai
     *
     */
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;
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
    public Ticket(String passengerName, String fromStation, 
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
