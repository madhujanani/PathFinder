package com.mars.trainticketbooking.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mars.trainticketbooking.springboot.entity.PassengerDetails;

/**
 * @author Madhu
 */
public interface PassengerDetailsRepository extends JpaRepository<PassengerDetails, String> {

}
