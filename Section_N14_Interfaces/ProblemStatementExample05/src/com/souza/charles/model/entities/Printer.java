package com.souza.charles.model.entities;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Example adapted by: Charles Fernandes de Souza
  Date: December 16, 2024
 */
public class Printer extends Device {

    public Printer(String serialNumber) {
        super(serialNumber);
    }

    @Override
    public void processDoc(String doc) {
        System.out.println("Printer processing: " + doc);
    }

    public void print(String doc) {
        System.out.println("Printing: " + doc);
    }
}
