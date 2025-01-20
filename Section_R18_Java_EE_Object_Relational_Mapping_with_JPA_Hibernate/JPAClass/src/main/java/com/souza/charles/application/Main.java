package com.souza.charles.application;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Example adapted by: Charles Fernandes de Souza
  Date: January 20, 2025
 */

import com.souza.charles.domain.entities.Person;

public class Main {
    public static void main(String[] args) {
        Person person01 = new Person(1001, "Balthazar de Bigode", "balthazar@email.com");
        Person person02 = new Person(2002, "Ophelia Cassandra Birrenta", "ophelia@email.com");
        Person person03 = new Person(3003, "Ludovico Crispim", "ludovico@email.com");

        System.out.print(person01);
        System.out.print(person02);
        System.out.print(person03);
    }
}
