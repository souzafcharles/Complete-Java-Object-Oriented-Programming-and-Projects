package com.souza.charles;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Example adapted by: Charles Fernandes de Souza
 Date: November 19, 2024
 */

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Example01 {

    public static void main(String[] args) {
        // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDate date01 = LocalDate.now();
        LocalDateTime date02 = LocalDateTime.now();
        Instant date03 = Instant.now();
        LocalDate date04 = LocalDate.parse("2024-11-19");
        LocalDateTime date05 = LocalDateTime.parse("2024-11-19T01:30:26");
        Instant date06 = Instant.parse("2024-11-19T01:30:26Z");
        Instant date07 = Instant.parse("2024-11-19T01:30:26-03:00");
        // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html
        LocalDate date08 = LocalDate.parse("19/11/2024", fmt1);
        LocalDateTime date09 = LocalDateTime.parse("19/11/2024 01:30", fmt2);
        LocalDate date10 = LocalDate.of(2024, 11, 19);
        LocalDateTime date11 = LocalDateTime.of(2024, 11, 19, 12, 30);
        System.out.println("date01 = " + date01.toString());
        System.out.println("date02 = " + date02.toString());
        System.out.println("date03 = " + date03.toString());
        System.out.println("date04 = " + date04.toString());
        System.out.println("date05 = " + date05.toString());
        System.out.println("date06 = " + date06.toString());
        System.out.println("date07 = " + date07.toString());
        System.out.println("date08 = " + date08.toString());
        System.out.println("date09 = " + date09.toString());
        System.out.println("date10 = " + date10.toString());
        System.out.println("date11 = " + date11.toString());
    }
}