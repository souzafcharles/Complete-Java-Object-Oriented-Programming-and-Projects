package com.souza.charles.view.application;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Example adapted by: Charles Fernandes de Souza
  Date: December 04, 2024
 */
import java.io.*;

public class App {

    public static void main(String[] args) {
        String[] lines = new String[]{"Good morning", "Good afternoon", "Good night"};
        String path = "C:\\tmp\\out.txt";
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            for (String line : lines) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}