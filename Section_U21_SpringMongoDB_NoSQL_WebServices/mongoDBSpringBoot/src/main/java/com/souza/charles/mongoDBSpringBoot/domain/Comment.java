package com.souza.charles.mongoDBSpringBoot.domain;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 11, 2025
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import com.souza.charles.mongoDBSpringBoot.dto.AuthorResponseDTO;

import java.io.Serializable;
import java.time.Instant;

public class Comment implements Serializable {

    private String text;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant date;
    private AuthorResponseDTO author;

    public Comment() {
    }

    public Comment(String text, Instant date, AuthorResponseDTO author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public AuthorResponseDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorResponseDTO author) {
        this.author = author;
    }
}