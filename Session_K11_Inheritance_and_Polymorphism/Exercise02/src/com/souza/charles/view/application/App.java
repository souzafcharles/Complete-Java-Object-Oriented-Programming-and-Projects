package com.souza.charles.view.application;

import com.souza.charles.model.entities.ImportedProduct;
import com.souza.charles.model.entities.Product;
import com.souza.charles.model.entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        System.out.print("Enter the number of products: ");
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            System.out.println("Product #" + (1 + i) + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char isCommonUsedOrImported;
            isCommonUsedOrImported = Character.toLowerCase(scanner.next().charAt(0));
            scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Price: ");
            Double price = scanner.nextDouble();
            if (isCommonUsedOrImported == 'i') {
                System.out.print("Customs fee: ");
                Double customsFee = scanner.nextDouble();
                products.add(new ImportedProduct(name, price, customsFee));
            } else if (isCommonUsedOrImported == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate manufactureDate = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                products.add(new UsedProduct(name, price, manufactureDate));
            } else {
                products.add(new Product(name, price));
            }
        }
        System.out.print("\nPRICE TAGS:\n");
        for (Product product : products) {
            System.out.println(product.priceTag());
        }
        scanner.close();
    }
}