package com.souza.charles.model.entities;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 22, 2024
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String nameClient;
    private String emailClient;
    private LocalDate birthDate;

    public Client() {
    }

    public Client(String nameClient, String emailClient, LocalDate birthDate) {
        this.nameClient = nameClient;
        this.emailClient = emailClient;
        this.birthDate = birthDate;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - %s", nameClient, dateTimeFormatter.format(birthDate), emailClient);
    }
}