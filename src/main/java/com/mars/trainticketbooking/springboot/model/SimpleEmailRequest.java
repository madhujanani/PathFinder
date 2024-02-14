package com.mars.trainticketbooking.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tjspitz
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleEmailRequest {

  private String recipient;
  private String subject;
  private String body;
}
