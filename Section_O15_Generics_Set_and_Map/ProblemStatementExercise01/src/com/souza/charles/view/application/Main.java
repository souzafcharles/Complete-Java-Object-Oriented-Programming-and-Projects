package com.souza.charles.view.application;
/*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Exercise done by: Charles Fernandes de Souza
  Date: December 26, 2024
 */

import com.souza.charles.model.entities.LogAccess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<LogAccess> logAccesses = new HashSet<>();
        System.out.print("Enter file full path: ");
        String path = scanner.nextLine();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String logName = bufferedReader.readLine();
            while (logName != null) {
                String[] fields = logName.split(" ");
                if (fields.length == 2) {
                    String userName = fields[0];
                    Instant moment = Instant.parse(fields[1]);
                    logAccesses.add(new LogAccess(userName, moment));
                }
                logName = bufferedReader.readLine();
            }
            /*
            int count = 0;
            for (LogAccess logAccess : logAccesses) {
                if (logAccesses.contains(logAccess)) {
                    count++;
                }
            }
            System.out.println("Total users: " + count);
            */
            System.out.println("Total users: " + logAccesses.size());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }
}