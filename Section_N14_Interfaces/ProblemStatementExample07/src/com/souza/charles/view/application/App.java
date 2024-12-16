package com.souza.charles.view.application;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Example adapted by: Charles Fernandes de Souza
  Date: December 16, 2024
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class App {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        String path = "C:\\tmp\\in.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String name = bufferedReader.readLine();
            while (name != null) {
                list.add(name);
                name = bufferedReader.readLine();
            }
            Collections.sort(list);
            for (String s : list) {
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}