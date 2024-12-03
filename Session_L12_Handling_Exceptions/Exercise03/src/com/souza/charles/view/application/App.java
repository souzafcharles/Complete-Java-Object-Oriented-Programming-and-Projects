package com.souza.charles.view.application;
/*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Exercise done by: Charles Fernandes de Souza
  Date: December 03, 2024
 */

import com.souza.charles.model.entities.Reservation;
import com.souza.charles.model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Room number: ");
            int roomNumber = scanner.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            LocalDate checkIn = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.print("Check-out date (dd/MM/yyyy): ");
            LocalDate checkOut = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));


            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            reservation.updateDates(checkIn, checkOut);
            System.out.println(reservation);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format!");
        } catch (DomainException e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }
}