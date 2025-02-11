package com.souza.charles.mongoDBSpringBoot.dto;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 11, 2025
 */

import com.souza.charles.mongoDBSpringBoot.domain.Comment;

import java.io.Serializable;
import java.time.Instant;

public record CommentResponseDTO(String text, Instant date, AuthorResponseDTO author) implements Serializable {

    public CommentResponseDTO(Comment comment) {
        this(comment.getText(), comment.getDate(), comment.getAuthor());
    }
}