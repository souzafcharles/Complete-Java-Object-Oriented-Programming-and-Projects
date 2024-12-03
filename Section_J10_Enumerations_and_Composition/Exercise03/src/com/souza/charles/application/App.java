package com.souza.charles.application;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 22, 2024
 */
import com.souza.charles.model.entities.Client;
import com.souza.charles.model.entities.Order;
import com.souza.charles.model.entities.OrderItem;
import com.souza.charles.model.entities.Product;
import com.souza.charles.model.enums.OrderStatus;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String clientName = scanner.nextLine();
        System.out.print("Email: ");
        String clientEmail = scanner.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        LocalDate birthDate = LocalDate.parse(scanner.next(), dateTimeFormatter);
        Client client = new Client(clientName, clientEmail, birthDate);
        System.out.println("Enter order data:");
        System.out.print("Status: ");
        int statusValue = scanner.nextInt();
        OrderStatus status = null;
        for (OrderStatus orderStatus : OrderStatus.values()) {
            if (orderStatus.getValueOrderStatus() == statusValue) {
                status = orderStatus;
                break;
            }
        }
        Order order = new Order(LocalDateTime.now(), status, client);
        System.out.print("How many items to this order? ");
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            scanner.nextLine();
            System.out.println("Enter #" + (1 + i) + " item data:");
            System.out.print("Product name: ");
            String productName = scanner.nextLine();
            System.out.print("Product price: ");
            Double productPrice = scanner.nextDouble();
            Product product = new Product(productName, productPrice);
            System.out.print("Quantity: ");
            Integer itemQuantity = scanner.nextInt();
            OrderItem orderItem = new OrderItem(itemQuantity, productPrice, product);
            order.addItem(orderItem);
        }
        System.out.println(order);
        scanner.close();
    }
}