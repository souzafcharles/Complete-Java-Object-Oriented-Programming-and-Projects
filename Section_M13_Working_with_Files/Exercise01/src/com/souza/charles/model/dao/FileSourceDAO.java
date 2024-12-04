package com.souza.charles.model.dao;
/*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Exercise done by: Charles Fernandes de Souza
  Date: December 04, 2024
 */

import com.souza.charles.model.entities.Product;
import com.souza.charles.model.exceptions.FileNotFoundException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileSourceDAO {

    public static List<Product> readProductsFromFile(String sourceFileStr) {
        List<Product> list = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFileStr))) {

            String itemCsv = bufferedReader.readLine();
            while (itemCsv != null) {

                String[] fields = itemCsv.split(",");
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int quantity = Integer.parseInt(fields[2]);

                list.add(new Product(name, price, quantity));

                itemCsv = bufferedReader.readLine();
            }

        } catch (IOException e) {
            throw new FileNotFoundException("Error reading file: " + e.getMessage());
        }
        return list;
    }

    public static void writeProductsToFile(String targetFileStr, List<Product> list) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(targetFileStr))) {

            for (Product item : list) {
                bufferedWriter.write(String.format("%s, %.2f", item.getName(), item.total()));
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            throw new FileNotFoundException("Error writing file: " + e.getMessage());
        }
    }

    public static boolean createDirectory(String path) {
        return new File(path).mkdir();
    }
}