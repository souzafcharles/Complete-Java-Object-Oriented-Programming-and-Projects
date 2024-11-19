package com.souza.charles;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 19, 2024
 */
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Example02 {
    public static void main(String[] args) {
        LocalDate date04 = LocalDate.parse("2022-07-20");
        LocalDateTime date05 = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant date06 = Instant.parse("2022-07-20T01:30:26Z");
        // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter fmt5 = DateTimeFormatter.ISO_INSTANT;
        System.out.println("date04 = " + date04.format(fmt1));
        System.out.println("date04 = " + fmt1.format(date04));
        System.out.println("date04 = " + date04.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("date05 = " + date05.format(fmt1));
        System.out.println("date05 = " + date05.format(fmt2));
        System.out.println("date05 = " + date05.format(fmt4));
        System.out.println("date06 = " + fmt3.format(date06));
        System.out.println("date06 = " + fmt5.format(date06));
        System.out.println("date06 = " + date06.toString());
    }
}