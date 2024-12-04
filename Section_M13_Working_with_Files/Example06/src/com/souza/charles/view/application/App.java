package com.souza.charles.view.application;

import java.io.*;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a folder path: ");
        String strPath = scanner.nextLine();
        File path = new File(strPath);
        System.out.println("getPath: " + path.getPath());
        System.out.println("getParent: " + path.getParent());
        System.out.println("getName: " + path.getName());
        scanner.close();
    }
}