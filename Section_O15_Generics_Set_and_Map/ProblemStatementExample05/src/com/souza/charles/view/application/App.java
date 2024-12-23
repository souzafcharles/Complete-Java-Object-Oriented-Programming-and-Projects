package com.souza.charles.view.application;

import com.souza.charles.model.entities.Product;
import com.souza.charles.model.services.CalculationService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        String path = "C:\\tmp\\in.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                list.add(new Product(fields[0], Double.parseDouble(fields[1])));
                line = bufferedReader.readLine();
            }
            Product product = CalculationService.max(list);
            System.out.println("Most expensive:");
            System.out.println(product);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
