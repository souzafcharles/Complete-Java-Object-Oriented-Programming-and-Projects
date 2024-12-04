package com.souza.charles.view.application;
/*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Exercise done by: Charles Fernandes de Souza
  Date: December 04, 2024
 */

import com.souza.charles.model.dao.FileSourceDAO;
import com.souza.charles.model.entities.Product;

import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter file path: ");
        String sourceFileStr = scanner.nextLine();

        List<Product> list = FileSourceDAO.readProductsFromFile(sourceFileStr);
        String sourceFolderStr = new File(sourceFileStr).getParent();

        boolean success = FileSourceDAO.createDirectory(sourceFolderStr + "\\out");

        String targetFileStr = sourceFolderStr + "\\out\\summary.csv";
        FileSourceDAO.writeProductsToFile(targetFileStr, list);

        System.out.println(targetFileStr + " CREATED!");

        scanner.close();
    }
}