package com.souza.charles.model.entities;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Example adapted by: Charles Fernandes de Souza
  Date: December 16, 2024
 */
public class Scanner extends Device {

    public Scanner(String serialNumber) {
        super(serialNumber);
    }

    @Override
    public void processDoc(String doc) {
        System.out.println("Scanner processing: " + doc);
    }

    public String scan() {
        return "Scanned content";
    }
}
