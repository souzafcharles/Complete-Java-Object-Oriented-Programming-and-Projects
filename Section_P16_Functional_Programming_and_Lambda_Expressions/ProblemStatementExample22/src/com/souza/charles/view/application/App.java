package com.souza.charles.view.application;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Example adapted by: Charles Fernandes de Souza
  Date: January 06, 2025
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Stream<Integer> stream01 = list.stream();
        System.out.println(Arrays.toString(stream01.toArray()));

        Stream<Integer> stream02 = list.stream().map(x -> x * 10);
        System.out.println(Arrays.toString(stream02.toArray()));

        Stream<String> stream03 = Stream.of("Balthazar", "Ophelia", "Ludovico");
        System.out.println(Arrays.toString(stream03.toArray()));

        Stream<Integer> stream04 = Stream.iterate(0, x -> x + 2);
        System.out.println(Arrays.toString(stream04.limit(10).toArray()));

        Stream<Long> stream05 = Stream.iterate(new long[]{0L, 1L}, p -> new long[]{p[1], p[0] + p[1]}).map(p -> p[0]);
        System.out.println(Arrays.toString(stream05.limit(15).toArray()));
    }
}
