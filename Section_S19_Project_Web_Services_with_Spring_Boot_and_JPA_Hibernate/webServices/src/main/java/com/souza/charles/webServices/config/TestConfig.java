package com.souza.charles.webServices.config;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: January 22, 2025
 */

import com.souza.charles.webServices.entities.*;
import com.souza.charles.webServices.entities.enums.OrderStatus;
import com.souza.charles.webServices.repositories.*;
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

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

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
        Order order10 = new Order(null, Instant.parse("2025-01-26T14:14:14Z"), OrderStatus.PAID, user08);
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

        Product product01 = new Product(null, "The Lord of the Rings", "An epic fantasy novel by J.R.R. Tolkien. Follow the journey of Frodo Baggins as he attempts to destroy the One Ring.", 90.5, "https://github.com/souzafcharles/1.png");
        product01.getCategories().add(category02);
        Product product02 = new Product(null, "Smart TV", "Enjoy your favorite shows on this sleek Smart TV with vibrant colors and crisp resolution.", 2190.0, "https://github.com/souzafcharles/2.png");
        product02.getCategories().add(category01);
        product02.getCategories().add(category03);
        Product product03 = new Product(null, "Macbook Pro", "Power through your day with this high-performance Macbook Pro, featuring a sleek design and powerful hardware.", 1250.0, "https://github.com/souzafcharles/3.png");
        Product product04 = new Product(null, "PC Gamer", "Experience top-notch gaming performance with this powerful gaming PC, designed for the ultimate gaming experience.", 1200.0, "https://github.com/souzafcharles/4.png");
        product03.getCategories().add(category03);
        Product product05 = new Product(null, "Rails for Dummies", "A comprehensive guide to Ruby on Rails for beginners. Learn how to build web applications from scratch.", 100.99, "https://github.com/souzafcharles/5.png");
        product05.getCategories().add(category02);
        Product product06 = new Product(null, "Moroccanoil Hydrating Shampoo", "Moisturizing shampoo with argan oil and vitamins, perfect for dry hair.", 18.99, "https://github.com/souzafcharles/6.png");
        product06.getCategories().add(category06);
        Product product07 = new Product(null, "Wilson Pro Staff RF97 V13 Tennis Racket", "Federer’s signature tennis racket for precision and control on the court.", 269.99, "https://github.com/souzafcharles/7.png");
        product07.getCategories().add(category07);
        Product product08 = new Product(null, "Catan: Seafarers Board Game", "The expansion for Catan with new islands, ships, and adventure.", 44.99, "https://github.com/souzafcharles/8.png");
        product08.getCategories().add(category08);
        Product product09 = new Product(null, "Lavazza Super Crema Espresso Coffee Beans", "Premium Italian espresso blend with a rich, creamy taste.", 19.99, "https://github.com/souzafcharles/9.png");
        product09.getCategories().add(category09);
        Product product10 = new Product(null, "Michelin Pilot Sport 4 Tires", "High-performance tires with excellent grip and stability for sports cars.", 159.99, "https://github.com/souzafcharles/10.png");
        product10.getCategories().add(category10);
        Product product11 = new Product(null, "Apple iPad Air (2023)", "Sleek, responsive tablet with the latest M1 chip and 10.9-inch display.", 599.99, "https://github.com/souzafcharles/11.png");
        product11.getCategories().add(category01);
        Product product12 = new Product(null, "The Food Lab: Better Home Cooking through Science", "Comprehensive cookbook by J. Kenji López-Alt focusing on the science of cooking.", 39.99, "https://github.com/souzafcharles/12.png");
        product12.getCategories().add(category02);
        Product product13 = new Product(null, "Nike Dri-FIT Cotton T-Shirt", "Comfortable athletic T-shirt with moisture-wicking fabric, available in multiple sizes.", 25.99, "https://github.com/souzafcharles/13.png");
        product13.getCategories().add(category04);
        Product product14 = new Product(null, "Garmin Forerunner 245 Music", "GPS running smartwatch with music storage and heart-rate monitoring.", 249.99, "https://github.com/souzafcharles/14.png");
        product14.getCategories().add(category01);
        product14.getCategories().add(category03);
        Product product15 = new Product(null, "LG InstaView French Door Refrigerator", "Smart refrigerator with InstaView door, sleek design, and energy efficiency.", 1299.99, "https://github.com/souzafcharles/15.png");
        product15.getCategories().add(category05);

        productRepository.saveAll(Arrays.asList(product01, product02, product03, product04, product05, product06, product07, product08, product09, product10, product11, product12, product13, product14, product15));

        OrderItem orderItem01 = new OrderItem(order01, product01, 2, product01.getPrice());
        OrderItem orderItem02 = new OrderItem(order01, product03, 1, product03.getPrice());
        OrderItem orderItem03 = new OrderItem(order02, product03, 2, product03.getPrice());
        OrderItem orderItem04 = new OrderItem(order03, product05, 2, product05.getPrice());
        OrderItem orderItem05 = new OrderItem(order04, product02, 1, product02.getPrice());
        OrderItem orderItem06 = new OrderItem(order05, product04, 1, product04.getPrice());
        OrderItem orderItem07 = new OrderItem(order06, product06, 3, product06.getPrice());
        OrderItem orderItem08 = new OrderItem(order07, product07, 2, product07.getPrice());
        OrderItem orderItem09 = new OrderItem(order08, product08, 1, product08.getPrice());
        OrderItem orderItem10 = new OrderItem(order09, product09, 4, product09.getPrice());
        OrderItem orderItem11 = new OrderItem(order10, product10, 2, product10.getPrice());
        OrderItem orderItem12 = new OrderItem(order11, product11, 1, product11.getPrice());
        OrderItem orderItem13 = new OrderItem(order12, product12, 1, product12.getPrice());
        OrderItem orderItem14 = new OrderItem(order01, product13, 1, product13.getPrice());
        OrderItem orderItem15 = new OrderItem(order02, product14, 2, product14.getPrice());
        OrderItem orderItem16 = new OrderItem(order03, product15, 1, product15.getPrice());

        orderItemRepository.saveAll(Arrays.asList(orderItem01, orderItem02, orderItem03, orderItem04, orderItem05, orderItem06, orderItem07, orderItem08, orderItem09, orderItem10, orderItem11, orderItem12, orderItem13, orderItem14, orderItem15, orderItem16));

        Payment payment01 = new Payment(null, Instant.parse("2025-01-19T20:31:07Z"), order01);
        order01.setPayment(payment01);
        Payment payment02 = new Payment(null, Instant.parse("2025-01-23T11:57:59Z"), order07);
        order07.setPayment(payment02);
        Payment payment03 = new Payment(null, Instant.parse("2025-01-26T15:03:34Z"), order10);
        order10.setPayment(payment03);

        orderRepository.saveAll(Arrays.asList(order01, order07, order10));
    }
}