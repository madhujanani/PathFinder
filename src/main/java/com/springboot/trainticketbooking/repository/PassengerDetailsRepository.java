package com.springboot.trainticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.trainticketbooking.entity.PassengerDetails;

/**
 * @author Madhu
 */
public interface PassengerDetailsRepository extends JpaRepository<PassengerDetails, String> {

}
