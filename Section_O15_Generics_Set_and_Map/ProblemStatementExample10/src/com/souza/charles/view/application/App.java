package com.souza.charles.view.application;

import java.util.HashSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Computer");
        set.add("Smartphone");
        set.add("Tablet");

        for (String print : set) {
            System.out.println(print);
        }

        System.out.println(set.contains("Notebook"));
        System.out.println(set.contains("Smartphone"));
    }
}
