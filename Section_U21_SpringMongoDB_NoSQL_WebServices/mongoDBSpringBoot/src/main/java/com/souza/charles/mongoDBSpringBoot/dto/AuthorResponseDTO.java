package com.souza.charles.mongoDBSpringBoot.dto;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 11, 2025
 */

import com.souza.charles.mongoDBSpringBoot.domain.User;

import java.io.Serializable;

public record AuthorResponseDTO(String id, String name) implements Serializable {

    public AuthorResponseDTO(User user) {
        this(user.getId(), user.getName());
    }
}