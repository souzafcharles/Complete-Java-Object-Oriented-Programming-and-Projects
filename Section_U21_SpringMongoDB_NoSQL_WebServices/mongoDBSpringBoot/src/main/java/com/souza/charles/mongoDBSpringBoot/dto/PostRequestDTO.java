package com.souza.charles.mongoDBSpringBoot.dto;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 11, 2025
 */

import java.io.Serializable;
import java.time.Instant;

public record PostRequestDTO(String id, Instant date, String title, String body) implements Serializable {
}