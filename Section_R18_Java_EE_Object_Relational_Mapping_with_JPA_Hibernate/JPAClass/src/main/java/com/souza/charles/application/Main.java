package com.souza.charles.application;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Example adapted by: Charles Fernandes de Souza
  Date: January 20, 2025
 */

import com.souza.charles.domain.entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Person person01 = new Person(null, "Balthazar de Bigode", "balthazar@email.com");
        Person person02 = new Person(null, "Ophelia Cassandra Birrenta", "ophelia@email.com");
        Person person03 = new Person(null, "Ludovico Crispim", "ludovico@email.com");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Person personToUpdate = entityManager.find(Person.class, 10);
        personToUpdate.setName("Balthazar Vitalino de Bigode");
        entityManager.merge(personToUpdate);
        entityManager.getTransaction().commit();

        System.out.println("Transaction committed!");

        entityManagerFactory.close();
        entityManager.close();
    }
}
