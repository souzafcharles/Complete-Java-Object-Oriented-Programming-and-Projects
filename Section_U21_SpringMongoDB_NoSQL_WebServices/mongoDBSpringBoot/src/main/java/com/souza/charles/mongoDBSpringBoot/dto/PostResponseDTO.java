package com.souza.charles.mongoDBSpringBoot.dto;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 11, 2025
 */

import com.souza.charles.mongoDBSpringBoot.domain.Post;

import java.io.Serializable;
import java.time.Instant;

public record PostResponseDTO(String id, Instant date, String title, String body) implements Serializable {

    public PostResponseDTO(Post post) {
        this(post.getId(), post.getDate(), post.getTitle(), post.getBody());
    }
}