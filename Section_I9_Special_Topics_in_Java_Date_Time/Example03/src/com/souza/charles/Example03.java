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

public class Example03 {
    public static void main(String[] args) {
        // for (String s : ZoneId.getAvailableZoneIds())
        // System.out.println(s);
        LocalDate date04 = LocalDate.parse("2024-11-19");
        LocalDateTime date05 = LocalDateTime.parse("2024-11-19T01:30:26");
        Instant date06 = Instant.parse("2024-11-19T01:30:26Z");
        LocalDate result01 = LocalDate.ofInstant(date06, ZoneId.systemDefault());
        LocalDate result02 = LocalDate.ofInstant(date06, ZoneId.of("Portugal"));
        LocalDateTime result03 = LocalDateTime.ofInstant(date06, ZoneId.systemDefault());
        LocalDateTime result04 = LocalDateTime.ofInstant(date06, ZoneId.of("Portugal"));
        System.out.println("result01 = " + result01);
        System.out.println("result02 = " + result02);
        System.out.println("result03 = " + result03);
        System.out.println("result04 = " + result04);
        System.out.println("date04 day = " + date04.getDayOfMonth());
        System.out.println("date04 month = " + date04.getMonthValue());
        System.out.println("date04 year = " + date04.getYear());
        System.out.println("date05 hour = " + date05.getHour());
        System.out.println("date05 minutes = " + date05.getMinute());

    }
}