package com.souza.charles.view.application;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Example adapted by: Charles Fernandes de Souza
  Date: December 24, 2024
 */

import com.souza.charles.model.entities.Client;
public class App {
    public static void main(String[] args) {
        Client client01 = new Client("Balthazar", "balthazar@mail.com");
        Client client02 = new Client("Ophelia", "Ophelia@mail.com");
        System.out.println(client01.hashCode());
        System.out.println(client02.hashCode());
        System.out.println(client01.equals(client02));
    }
}