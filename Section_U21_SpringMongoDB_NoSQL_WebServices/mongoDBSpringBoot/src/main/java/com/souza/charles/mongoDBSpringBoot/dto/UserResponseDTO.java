package com.souza.charles.mongoDBSpringBoot.dto;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 04, 2025
 */

import com.souza.charles.mongoDBSpringBoot.domain.User;

import java.io.Serializable;

public record UserResponseDTO(String id, String name, String email) implements Serializable {

    public UserResponseDTO(User user) {
        this(user.getId(), user.getName(), user.getEmail());
    }
}