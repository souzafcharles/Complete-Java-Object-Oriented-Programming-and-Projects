package com.souza.charles.view.application;
/*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Exercise done by: Charles Fernandes de Souza
  Date: December 28, 2024
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> votes = new LinkedHashMap<>();
        System.out.print("Enter file full path: ");
        String path = scanner.nextLine();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String candidate = bufferedReader.readLine();
            while (candidate != null) {
                String[] fields = candidate.split(",");
                String name = fields[0];
                int voteCount = Integer.parseInt(fields[1]);
                votes.put(name, votes.containsKey(name) ? votes.get(name) + voteCount : voteCount);
                candidate = bufferedReader.readLine();
            }
            for (String key : votes.keySet()) {
                System.out.println(key + ": " + votes.get(key));
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }
}