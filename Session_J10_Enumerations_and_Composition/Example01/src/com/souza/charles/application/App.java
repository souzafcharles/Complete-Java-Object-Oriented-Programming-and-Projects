package com.souza.charles.application;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Example adapted by: Charles Fernandes de Souza
 Date: November 19, 2024
 */
import com.souza.charles.entities.Order;
import com.souza.charles.entities.OrderStatus;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import static com.souza.charles.entities.OrderStatus.DELIVERED;

public class App {
    public static void main(String[] args) {
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Order order = new Order(1080, new Date(), DELIVERED);
        System.out.println(order);
        OrderStatus os1 = OrderStatus.DELIVERED;
        OrderStatus os2 = OrderStatus.valueOf("DELIVERED");
        System.out.println(os1);
        System.out.println(os2);
    }
}
