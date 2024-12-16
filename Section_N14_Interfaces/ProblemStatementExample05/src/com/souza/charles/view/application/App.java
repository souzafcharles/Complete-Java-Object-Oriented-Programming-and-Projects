package com.souza.charles.view.application;

import com.souza.charles.model.entities.Printer;
import com.souza.charles.model.entities.Scanner;

public class App {

    public static void main(String[] args) {

        Printer p = new Printer("1080");
        p.processDoc("My Letter");
        p.print("My Letter");

        Scanner s = new Scanner("2003");
        s.processDoc("My Email");
        System.out.println("Scan result: " + s.scan());
    }
}
