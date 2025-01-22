package com.souza.charles.webServices.config;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: January 22, 2025
 */

import com.souza.charles.webServices.entities.Order;
import com.souza.charles.webServices.entities.User;
import com.souza.charles.webServices.entities.enums.OrderStatus;
import com.souza.charles.webServices.repositories.OrderRepository;
import com.souza.charles.webServices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User user01 = new User(null, "Balthazar de Bigode", "balthazar@email.com", "+5599999999999", "******");
        User user02 = new User(null, "Ophelia Birrenta", "ophelia@email.com", "+5511111111111", "******");
        User user03 = new User(null, "Ludovico Crispim", "ludovico@email.com", "+5522222222222", "******");
        User user04 = new User(null, "Vitalina Simplicio", "vitalina@email.com", "+5533333333333", "******");

        userRepository.saveAll(Arrays.asList(user01, user02, user03, user04));

        Order order01 = new Order(null, Instant.parse("2025-01-19T19:53:07Z"), OrderStatus.PAID, user01);
        Order order02 = new Order(null, Instant.parse("2025-01-19T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user02);
        Order order03 = new Order(null, Instant.parse("2025-01-20T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user01);
        Order order04 = new Order(null, Instant.parse("2025-01-21T17:10:10Z"), OrderStatus.SHIPPED, user03);
        Order order05 = new Order(null, Instant.parse("2025-01-22T13:18:33Z"), OrderStatus.CANCELED, user03);
        Order order06 = new Order(null, Instant.parse("2025-01-19T10:47:02Z"), OrderStatus.DELIVERED, user04);

        orderRepository.saveAll(Arrays.asList(order01, order02, order03, order04, order05, order06));

    }
}