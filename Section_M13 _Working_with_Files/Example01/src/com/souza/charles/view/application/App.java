package com.souza.charles.view.application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        File file = new File("C:\\tmp\\in.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());;
        } finally {
            if (scanner != null){
                scanner.close();
            }
        }
    }
}
