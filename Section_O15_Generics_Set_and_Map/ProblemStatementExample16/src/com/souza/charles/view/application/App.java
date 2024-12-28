package com.souza.charles.view.application;
/*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Exercise done by: Charles Fernandes de Souza
  Date: December 28, 2024
 */
import java.util.Map;
import java.util.TreeMap;

public class App {

    public static void main(String[] args) {

        Map<String, String> cookies = new TreeMap<>();
        cookies.put("username", "balthazar");
        cookies.put("email", "balthazar@email.com");
        cookies.put("phone", "999999999");

        cookies.put("phone", "999999991");
        cookies.remove("email");

        System.out.println("Contains 'phone' key: " + cookies.containsKey("phone"));
        System.out.println("Phone number: " + cookies.get("phone"));
        System.out.println("Email: " + cookies.get("email"));
        System.out.println("Size: " + cookies.size());

        for (String key : cookies.keySet()) {
            System.out.println(key +": "+ cookies.get(key));
        }
    }
}