package com.souza.charles.webServices.config;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: January 22, 2025
 */

import com.souza.charles.webServices.entities.Category;
import com.souza.charles.webServices.entities.Order;
import com.souza.charles.webServices.entities.User;
import com.souza.charles.webServices.entities.enums.OrderStatus;
import com.souza.charles.webServices.repositories.CategoryRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        User user01 = new User(null, "Balthazar de Bigode", "balthazar@email.com", "+5599999999999", "******");
        User user02 = new User(null, "Ophelia Birrenta", "ophelia@email.com", "+5511111111111", "******");
        User user03 = new User(null, "Ludovico Crispim", "ludovico@email.com", "+5522222222222", "******");
        User user04 = new User(null, "Vitalina Simplicio", "vitalina@email.com", "+5533333333333", "******");
        User user05 = new User(null, "Sebastiana Pacheco", "sebastiana@email.com", "+5544444444444", "******");
        User user06 = new User(null, "Gumercindo Epaminondas", "gumercindo@email.com", "+5555555555555", "******");
        User user07 = new User(null, "Filisbina Junqueira", "filisbina@email.com", "+5566666666666", "******");
        User user08 = new User(null, "Florentino Fidalgo", "florentino@email.com", "+5577777777777", "******");
        User user09 = new User(null, "Margareth Ponticia", "margareth@email.com", "+5588888888888", "******");
        User user10 = new User(null, "Ferdinando Sarmento", "ferdinando@email.com", "+5500000000000", "******");

        userRepository.saveAll(Arrays.asList(user01, user02, user03, user04, user05, user06, user07, user08, user09, user10));

        Order order01 = new Order(null, Instant.parse("2025-01-19T19:53:07Z"), OrderStatus.PAID, user01);
        Order order02 = new Order(null, Instant.parse("2025-01-19T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user02);
        Order order03 = new Order(null, Instant.parse("2025-01-20T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user01);
        Order order04 = new Order(null, Instant.parse("2025-01-21T17:10:10Z"), OrderStatus.SHIPPED, user03);
        Order order05 = new Order(null, Instant.parse("2025-01-22T13:18:33Z"), OrderStatus.CANCELED, user03);
        Order order06 = new Order(null, Instant.parse("2025-01-19T10:47:02Z"), OrderStatus.DELIVERED, user04);
        Order order07 = new Order(null, Instant.parse("2025-01-23T11:11:11Z"), OrderStatus.PAID, user05);
        Order order08 = new Order(null, Instant.parse("2025-01-24T12:12:12Z"), OrderStatus.SHIPPED, user06);
        Order order09 = new Order(null, Instant.parse("2025-01-25T13:13:13Z"), OrderStatus.WAITING_PAYMENT, user07);
        Order order10 = new Order(null, Instant.parse("2025-01-26T14:14:14Z"), OrderStatus.CANCELED, user08);
        Order order11 = new Order(null, Instant.parse("2025-01-15T15:15:15Z"), OrderStatus.DELIVERED, user09);
        Order order12 = new Order(null, Instant.parse("2025-01-28T16:16:16Z"), OrderStatus.SHIPPED, user10);

        orderRepository.saveAll(Arrays.asList(order01, order02, order03, order04, order05, order06, order07, order08, order09, order10, order11, order12));

        Category category01 = new Category(null, "Electronics");
        Category category02 = new Category(null, "Books");
        Category category03 = new Category(null, "Computers");
        Category category04 = new Category(null, "Clothing");
        Category category05 = new Category(null, "Home Appliances");
        Category category06 = new Category(null, "Beauty & Personal Care");
        Category category07 = new Category(null, "Sports & Outdoors");
        Category category08 = new Category(null, "Toys & Games");
        Category category09 = new Category(null, "Groceries");
        Category category10 = new Category(null, "Automotive");

        categoryRepository.saveAll(Arrays.asList(category01, category02, category03, category04, category05, category06, category07, category08, category09, category10));

    }
}