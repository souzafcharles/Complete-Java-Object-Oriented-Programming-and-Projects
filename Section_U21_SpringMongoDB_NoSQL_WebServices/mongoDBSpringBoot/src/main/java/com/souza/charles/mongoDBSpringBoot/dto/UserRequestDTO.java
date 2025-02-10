package com.souza.charles.mongoDBSpringBoot.dto;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 04, 2025
 */

import java.io.Serializable;

public record UserRequestDTO(String id, String name, String email) implements Serializable {
}