package com.souza.charles.model.services;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Example adapted by: Charles Fernandes de Souza
  Date: December 18, 2024
 */

import java.util.ArrayList;
import java.util.List;

public class PrintService {

    List<Integer> list = new ArrayList<>();

    public void addValue(int value) {
        list.add(value);
    }

    public int first() {
        if (list.isEmpty()) {
            throw new IllegalStateException("List is empty!");
        }
        return list.getFirst();
    }

    public void print() {
        System.out.print("[");
        if (!list.isEmpty()) {
            System.out.print(list.getFirst());
        }
        for (int i = 1; i < list.size(); i++) {
            System.out.print(", " + list.get(i));
        }
        System.out.print("]");
    }
}