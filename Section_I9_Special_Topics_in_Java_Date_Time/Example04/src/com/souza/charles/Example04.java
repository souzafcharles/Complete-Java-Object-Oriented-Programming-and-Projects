package com.souza.charles;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 19, 2024
 */
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Example04 {

    public static void main(String[] args) {
        LocalDate date04 = LocalDate.parse("2024-11-19");
        LocalDateTime date05 = LocalDateTime.parse("2024-11-19T01:30:26");
        Instant date06 = Instant.parse("2024-11-19T01:30:26Z");
        LocalDate pastWeekDate = date04.minusDays(7);
        LocalDate nextWeekDate = date04.plusDays(7);
        LocalDateTime pastWeekLocalDate = date05.minusDays(7);
        LocalDateTime nextWeekLocalDate = date05.plusDays(7);
        Instant pastWeekInstant = date06.minus(7, ChronoUnit.DAYS);
        Instant nextWeekInstant = date06.plus(7, ChronoUnit.DAYS);
        System.out.println("pastWeekDate = " + pastWeekDate);
        System.out.println("nextWeekDate = " + nextWeekDate);
        System.out.println("pastWeekLocalDate = " + pastWeekLocalDate);
        System.out.println("nextWeekLocalDate = " + nextWeekLocalDate);
        System.out.println("pastWeekInstant = " + pastWeekInstant);
        System.out.println("nextWeekInstant = " + nextWeekInstant);
        Duration time01 = Duration.between(pastWeekDate.atStartOfDay(), date04.atStartOfDay());
        Duration time02 = Duration.between(pastWeekLocalDate, date05);
        Duration time03 = Duration.between(pastWeekInstant, date06);
        Duration time04 = Duration.between(date06, pastWeekInstant);
        System.out.println("time01 days = " + time01.toDays());
        System.out.println("time02 days = " + time02.toDays());
        System.out.println("time03 days = " + time03.toDays());
        System.out.println("time04 days = " + time04.toDays());
    }
}