package com.mars.trainticketbooking.springboot.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PassengerDetails {
	 private String passengerName;
	    private String fromStation;
	    private String toStation;

	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	    private Date dateOfTravel;
	    private String trainNo;

}
