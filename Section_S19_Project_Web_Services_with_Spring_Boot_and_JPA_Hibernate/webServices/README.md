# Project: Web Services with Spring Boot and JPA/Hibernate
***
## Instructions:
<p align="justify">
Develop a Java application using the <code>Spring Boot</code> framework to implement an order management system based on the domain model presented in the provided diagram. The application should be able to manage the entities represented in the diagram, implementing the necessary logical layers, such as <code>REST</code> resources, services for business logic, and repositories for data access. Configure the <code>H2</code> test database and insert initial data to simulate a realistic environment. The system should include <code>create</code>, <code>read</code>, <code>update</code>, and <code>delete</code> (<code>CRUD</code>) functionalities for all entities, ensuring the correct functioning of associations and the <code>OrderStatus</code> enum. Additionally, implement an <code>exception handling</code> mechanism to handle errors appropriately and provide clear responses to the user. The created <code>REST API</code> should allow for complete management of the system, ensuring data consistency and efficient execution of operations.
</p>

### Logical Layers:
![Logical Layers](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_S19_Project_Web_Services_with_Spring_Boot_and_JPA_Hibernate/webServices/src/main/resources/static/img/logical-layers.png)
***
## Steps to Follow and Documentation:
### 1. Project Created:
#### 1.1. Requirements Specification:
- Spring Initializr:
    - Maven;
    - Java 21;
    - Packing JAR;
    - Dependencies: Spring Web.
##### 1.2. Domain Model Entity:
![Domain Model Entity](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_S19_Project_Web_Services_with_Spring_Boot_and_JPA_Hibernate/webServices/src/main/resources/static/img/domain-model.png)
***
### 2. User Entity and Resource Class:
#### 2.1. Entity Class Requirements for User:
- Create the `User` Entity Class;
- Basic Attributes;
- Associations (Instantiate Collections);
- Constructors;
- Getters & Setters (Collections: only get);
- hashCode & equals;
- Serializable.
#### 2.2. Resource Class Requirements for User:
- Use `@RestController` annotation.
- Map requests (`@RequestMapping`) to the `/users` endpoint;
- Implement a method to handle `GET` requests and return all `Users` (`@GetMapping`).
#### 2.3. UserResource Class:
```java
@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User(1L, "Balthazar de Bigode", "balthazar@email.com", "+5516999999999", "******");
        return ResponseEntity.ok().body(user);
    }
}
```
#### 2.4. Summary of the Annotations:
- `@RestController`: Defines the class as a RESTful controller;
- `@RequestMapping(value = "/users")`: Maps the class to the `/users` endpoint;
- `@GetMapping`: Maps HTTP GET requests to the `findAll` method;
- `ResponseEntity<User> findAll()`: Returns an HTTP response containing a `User` object.
#### 2.5. Uniform Resource Locator (URL) Field:
```URL
http://localhost:8080/users
```
***
### 3. H2 Database Engine, Test Profile and JPA Repository:
#### 3.1. Setting up the JPA and H2 Database Dependencies in pom.xml File:
```xml

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
</dependencies>
````
#### 3.2. Setting up the application.properties File:
```properties
spring.profiles.active=test
spring.jpa.open-in-view=true
````
#### 3.3. Create and Setting up the application-test.properties File:
```properties
# DATASOURCE
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
# H2 CLIENT
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
# JPA, SQL
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.defer-datasource-initialization=true
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```
#### 3.4. Entity: JPA Mapping:
```java
@Entity
@Table(name = "tb_user")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
```
#### 3.5. Summary of the Annotations:
- `@Entity`: Defines the class as a JPA entity, mapping it to a database table;
- `@Table(name = "tb_user")`: Specifies that the table in the database will be named tb_user;
- `@Serial`: Indicates that a field is a serial number used during serialization;
- `@Id` Marks the field as the primary key of the entity;
- `@GeneratedValue(strategy = GenerationType.IDENTITY)`: Specifies that the primary key values will be generated by the
  database using an identity column.
#### 3.6. Uniform Resource Locator (URL) Field:
```URL
http://localhost:8080/h2-console
```
***
### 4. JPA Repository, Dependency Injection and Database Seeding:
#### 4.1. UserRepository extends JPARepository<User, Long>:
```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
```
#### 4.2. Configuration Class for "test" Profile:
```java
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
}
```
#### 4.3. @Autowired UserRepository:
```java
@Autowired
private UserRepository userRepository;
```
#### 4.4. Instantiate Objects in Memory:
```java
@Override
public void run(String... args) throws Exception {
    User user01 = new User(null, "Balthazar de Bigode", "balthazar@email.com", "+5599999999999", "******");
    User user02 = new User(null, "Ophelia Birrenta", "ophelia@email.com", "+5511111111111", "******");
    User user03 = new User(null, "Ludovico Crispim", "ludovico@email.com", "+5522222222222", "******");
}
```
#### 4.5. Persist Objects:
```java
userRepository.saveAll(Arrays.asList(user01, user02, user03));
```
#### 4.6. Database Seeding with Users in TestConfig Class:
```java
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user01 = new User(null, "Balthazar de Bigode", "balthazar@email.com", "+5599999999999", "******");
        User user02 = new User(null, "Ophelia Birrenta", "ophelia@email.com", "+5511111111111", "******");
        User user03 = new User(null, "Ludovico Crispim", "ludovico@email.com", "+5522222222222", "******");

        userRepository.saveAll(Arrays.asList(user01, user02, user03));
    }
}
```
#### 4.7. Summary of the Annotations and Commands:
- `@Configuration`: Indicates that the class can be used by the Spring IoC container as a source of bean definitions;
- `@Profile("test")`: Specifies that the configuration of the class will only be active when the "test" profile is
  active;
- `@Autowired`: Allows Spring to resolve and automatically inject the marked dependency;
- `CommandLineRunner`: Interface used to execute specific code when the Spring Boot application starts.
***
### 5. Service Layer and Component Registration:
#### 5.1. Service Class Requirements for User:
- Use `@Service` annotation;
- Inject `UserRepository` using `@Autowired`;
- Implement methods to retrieve all `User` (`findAll`);
- Implement method to retrieve specific `User` by ID (`findById`);
- Use `@Transactional`(readOnly = true) to ensure the method runs within a read-only transaction.
#### 5.2. Resource Class Requirements for User:
- Use `@RestController` annotation;
- Map requests (`@RequestMapping`) to the `/users` endpoint;
- Inject `UserService` using `@Autowired`;
- Implement a method to handle `GET` requests and return all `User` (`@GetMapping`);
- Implement a method to handle `GET` requests for a specific `User` by ID (`@GetMapping(value = "/{id}")`).
#### 5.3. Summary of the Annotations and Commands:
- `@Service`: Marks the class as a Spring service component, used for business logic;
- `@GetMapping(value = "/{id}")`: Maps HTTP GET requests to the findById method;
- `@PathVariable`: Binds a method parameter to a URI template variable;
- `Optional`: A class that represents a value that may or may not be present;
- `get()`: Retrieves the value if present, throws NoSuchElementException if not.
#### 5.4. Retrieving User Data via Spring Boot RESTful API:
#### 5.4.1. Endpoint:
* GET `/users`: Retrieves a list of all Users.
#### 5.4.2. Example GET Request:
```markdown
http://localhost:8080/users
```
#### 5.4.3. Example Response:
```json
[
  {
    "id": 1,
    "name": "Balthazar de Bigode",
    "email": "balthazar@email.com",
    "phone": "+5599999999999",
    "password": "******"
  },
  {
    "id": 2,
    "name": "Ophelia Birrenta",
    "email": "ophelia@email.com",
    "phone": "+5511111111111",
    "password": "******"
  },
  {
    "id": 3,
    "name": "Ludovico Crispim",
    "email": "ludovico@email.com",
    "phone": "+5522222222222",
    "password": "******"
  }
]
```
#### 5.4.4. Endpoint:
* GET `/users/{id}`: Retrieves a specific User by their ID.
#### 5.4.5. Example GET Request:
```markdown
http://localhost:8080/users/1
```
#### 5.4.6. Example Response:
```json
{
  "id": 1,
  "name": "Balthazar de Bigode",
  "email": "balthazar@email.com",
  "phone": "+5599999999999",
  "password": "******"
}
```
***
### 6. Order Entity Class, Instant Class and ISO 8601:
#### 6.1. Entity Class Requirements for Order:
- Create the `Order` Entity Class;
- Annotate the class with `@Entity` and `@Table`(name = "tb_order") to map it to the database table;
- Basic Attributes;
- Associations (Instantiate Collections);
- Annotate `@Id` and `@GeneratedValue` for the primary key, and `@Column` for other fields;
- Constructors;
- Getters & Setters (Collections: only get);
- hashCode & equals;
- Serializable.
#### 6.2. Repository Class Requirements for Order:
- Create an interface that extends `JpaRepository` for the `Order` entity (`extends JpaRepository<Order, Long>`).
#### 6.3. Service Class Requirements for Order:
- Use `@Service` annotation;
- Inject `OrderRepository` using `@Autowired`;
- Implement methods to retrieve all `Order` (`findAll`);
- Implement method to retrieve `Order` by ID (`findById`);
- Use `@Transactional`(readOnly = true) to ensure the method runs within a read-only transaction.
#### 6.4. Resource Class Requirements for Order:
- Use `@RestController` annotation;
- Map requests (`@RequestMapping`) to the `/orders` endpoint;
- Inject `OrderService` using `@Autowired`;
- Implement a method to handle `GET` requests and return all `Order` (`@GetMapping`);
- Implement a method to handle `GET` requests and return `Order` find by id (`@GetMapping(value = "/{id}"`).
#### 6.5. Include Instant Class and ISO 8601:
```java
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
private Instant moment;
```
#### 6.6. "To Many" Association, Lazy Loading, JsonIgnore:
```java
@ManyToOne
@JoinColumn(name = "user_id")
private User user;

@JsonIgnore
@OneToMany(mappedBy = "user")
private List<Order> orders = new ArrayList<>();
```
#### 6.7. Database Seeding with Orders in TestConfig Class and Persist Objects:
```java
Order order01 = new Order(null, Instant.parse("2025-01-19T19:53:07Z"), user01);
Order order02 = new Order(null, Instant.parse("2025-01-19T03:42:10Z"), user02);
Order order03 = new Order(null, Instant.parse("2025-01-20T15:21:22Z"), user01);
Order order04 = new Order(null, Instant.parse("2025-01-21T15:21:22Z"), user03);
orderRepository.saveAll(Arrays.asList(order01, order02, order03, order04));
```
#### 6.8. Summary of the Annotations:
- `@JsonFormat`: Specifies how a field should be formatted when serialized to JSON;
- `@ManyToOne`: Defines a many-to-one relationship between entities;
- `@JoinColumn(name = "user_id")`: Specifies the column used to join the Order table with the User table;
- `@JsonIgnore`: Indicates that a field should be ignored during JSON serialization and deserialization;
- `@OneToMany(mappedBy = "user")`: Defines a one-to-many relationship between entities, with the user field in the Order
  entity being the owner of the relationship;
#### 6.9. Retrieving Order Data via Spring Boot RESTful API:
#### 6.9.1. Endpoint:
* GET `/orders`: Retrieves a list of all Orders.
#### 6.9.2. Example GET Request:
```markdown
http://localhost:8080/orders
```
#### 6.9.3. Example Response:
```json
[
  {
    "id": 1,
    "moment": "2025-01-19T19:53:07Z",
    "user": {
      "id": 1,
      "name": "Balthazar de Bigode",
      "email": "balthazar@email.com",
      "phone": "+5599999999999",
      "password": "******"
    }
  },
  {
    "id": 2,
    "moment": "2025-01-19T03:42:10Z",
    "user": {
      "id": 2,
      "name": "Ophelia Birrenta",
      "email": "ophelia@email.com",
      "phone": "+5511111111111",
      "password": "******"
    }
  },
  {
    "id": 3,
    "moment": "2025-01-20T15:21:22Z",
    "user": {
      "id": 1,
      "name": "Balthazar de Bigode",
      "email": "balthazar@email.com",
      "phone": "+5599999999999",
      "password": "******"
    }
  },
  {
    "id": 4,
    "moment": "2025-01-21T15:21:22Z",
    "user": {
      "id": 3,
      "name": "Ludovico Crispim",
      "email": "ludovico@email.com",
      "phone": "+5522222222222",
      "password": "******"
    }
  }
]
```
#### 6.9.4. Endpoint:
* GET `/orders/{id}`: Retrieves a specific Order by its ID.
#### 6.9.5. Example GET Request:
```markdown
http://localhost:8080/orders/1
```
#### 6.9.6. Example Response:
```json
{
  "id": 1,
  "moment": "2025-01-19T19:53:07Z",
  "user": {
    "id": 1,
    "name": "Balthazar de Bigode",
    "email": "balthazar@email.com",
    "phone": "+5599999999999",
    "password": "******"
  }
}
```
***
### 7. OrderStatus Enum Class:
#### 7.1. Enum Class Requirements for OrderStatus:
- Declare `enum` constants for different the `OrderStatus`;
- Assign unique integer codes to each `enum` constant;
- Define a `private` field to store the `code` variable;
- Implement a `private` `constructor` to initialize the `code`;
- Provide a `getter` method to retrieve the `code`;
- Implement a `public` `static` method `valueOf` to convert an integer `code` back to the corresponding `enum` constant:
````java
public static OrderStatus valueOf(int code) {
    for (OrderStatus orderStatus : OrderStatus.values()) {
        if (orderStatus.getCode() == code) {
            return orderStatus;
        }
    }
    throw new IllegalArgumentException("Invalid OrderStatus Code!");
}
````
#### 7.2. Order Class Requirements:
- Declare a `private` field to store the `OrderStatus` as an `Integer` `code`;
- Implement a constructor to initialize the fields, including setting the `OrderStatus` using the `enum`;
- Provide a `getter` method to convert the `Integer` `code` back to the `OrderStatus` `enum`;
- Provide a `setter` method to convert the `OrderStatus` `enum` to its corresponding `Integer` code.
##### 7.3. Order Class:
```java
public class Order {

    private Integer orderStatus; // Stores the OrderStatus as an integer code

    // Constructor initializing the fields, including setting the order status using the enum
    public Order(Long id, Instant moment, OrderStatus orderStatus, User user) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus); // Sets the order status using the setter method to ensure proper conversion
        this.user = user;
    }

    // Getter method that converts the integer code back to the OrderStatus enum
    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    // Setter method that converts the OrderStatus enum to its corresponding integer code
    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }
}
```
#### 7.4. Database Seeding with Orders and OrderStatus in TestConfig Class and Persist Objects:
```java
Order order01 = new Order(null, Instant.parse("2025-01-19T19:53:07Z"), OrderStatus.PAID, user01);
Order order02 = new Order(null, Instant.parse("2025-01-19T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user02);
Order order03 = new Order(null, Instant.parse("2025-01-20T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user01);
Order order04 = new Order(null, Instant.parse("2025-01-21T17:10:10Z"), OrderStatus.SHIPPED, user03);
Order order05 = new Order(null, Instant.parse("2025-01-22T13:18:33Z"), OrderStatus.CANCELED, user03);
Order order06 = new Order(null, Instant.parse("2025-01-19T10:47:02Z"), OrderStatus.DELIVERED, user04);
orderRepository.saveAll(Arrays.asList(order01, order02, order03, order04, order05, order06));
```
***
### 8. Category Entity, Repository, Service and Resource Classes:
#### 8.1. Entity Class Requirements for Category:
- Create the `Category` Entity Class;
- Annotate the class with `@Entity` and `@Table`(name = "tb_category") to map it to the database table;
- Basic Attributes;
- Associations (Instantiate Collections);
- Annotate `@Id` and `@GeneratedValue` for the primary key, and `@Column` for other fields;
- Constructors;
- Getters & Setters (Collections: only get);
- hashCode & equals;
- Serializable.
#### 8.2. Repository Class Requirement for Category:
- Create an interface that extends `JpaRepository` for the `Category` entity (`extends JpaRepository<Category, Long>`).
#### 8.3. Service Class Requirements:
- Use `@Service` annotation;
- Inject `CategoryRepository` using `@Autowired`;
- Implement methods to retrieve all `Category` (`findAll`);
- Implement method to retrieve `Category` by ID (`findById`);
- Use `@Transactional`(readOnly = true) to ensure the method runs within a read-only transaction.
#### 8.4. Resource Class Requirements for Category:
- Use `@RestController` annotation;
- Map requests (`@RequestMapping`) to the `/categories` endpoint;
- Inject `CategoryService` using `@Autowired`;
- Implement a method to handle `GET` requests and return all `Category` (`@GetMapping`);
- Implement a method to handle `GET` requests and return `Category` find by id (`@GetMapping(value = "/{id}"`).
#### 8.5. Database Seeding with Categories in TestConfig Class and Persist Objects:
```java
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
```
#### 8.6. Retrieving Category Data via Spring Boot RESTful API:
#### 8.6.1. Endpoint:
* GET `/categories`: Retrieves a list of all Categories.
#### 8.6.2. Example GET Request:
```markdown
http://localhost:8080/categories
```
#### 8.6.3. Example Response:
```json
[
  {
    "id": 1,
    "name": "Electronics"
  },
  {
    "id": 2,
    "name": "Books"
  },
  {
    "id": 3,
    "name": "Computers"
  },
  {
    "id": 4,
    "name": "Clothing"
  },
  {
    "id": 5,
    "name": "Home Appliances"
  },
  {
    "id": 6,
    "name": "Beauty & Personal Care"
  },
  {
    "id": 7,
    "name": "Sports & Outdoors"
  },
  {
    "id": 8,
    "name": "Toys & Games"
  },
  {
    "id": 9,
    "name": "Groceries"
  },
  {
    "id": 10,
    "name": "Automotive"
  }
]
```
#### 8.6.4. Endpoint:
* GET `/categories/{id}`: Retrieves a specific Category by its ID.
#### 8.6.5. Example GET Request:
```markdown
http://localhost:8080/categories/7
```
#### 8.6.6. Example Response:
```json
{
  "id": 7,
  "name": "Sports & Outdoors"
}
```
***
### 9. Product Entity, Repository, Service and Resource Classes:
#### 9.1. Entity Class Requirements for Product:
- Create the `Product` Entity Class;
- Annotate the class with `@Entity` and `@Table`(name = "tb_product") to map it to the database table;
- Basic Attributes;
- Associations (Instantiate Collections);
- Annotate `@Id` and `@GeneratedValue` for the primary key, and `@Column` for other fields;
- Constructors;
- Getters & Setters (Collections: only get);
- hashCode & equals;
- Serializable.
#### 9.2. Repository Class Requirement for Product:
- Create an interface that extends `JpaRepository` for the `Product` entity (`extends JpaRepository<Product, Long>`).
#### 9.3. Service Class Requirements for Product:
- Use `@Service` annotation;
- Inject `ProductRepository` using `@Autowired`;
- Implement methods to retrieve all `Product` (`findAll`);
- Implement method to retrieve `Product` by ID (`findById`);
- Use `@Transactional`(readOnly = true) to ensure the method runs within a read-only transaction.
#### 9.4. Resource Class Requirements for Product:
- Use `@RestController` annotation;
- Map requests (`@RequestMapping`) to the `/products` endpoint;
- Inject `ProductService` using `@Autowired`;
- Implement a method to handle `GET` requests and return all `Product` (`@GetMapping`);
- Implement a method to handle `GET` requests and return `Product` find by id (`@GetMapping(value = "/{id}"`).
#### 9.5. Database Seeding with Products in TestConfig Class and Persist Objects:
```java
Product product01 = new Product(null, "The Lord of the Rings", "An epic fantasy novel by J.R.R. Tolkien. Follow the journey of Frodo Baggins as he attempts to destroy the One Ring.", 90.5, "https://github.com/souzafcharles/1.png");
Product product02 = new Product(null, "Smart TV", "Enjoy your favorite shows on this sleek Smart TV with vibrant colors and crisp resolution.", 2190.0, "https://github.com/souzafcharles/2.png");
Product product03 = new Product(null, "Macbook Pro", "Power through your day with this high-performance Macbook Pro, featuring a sleek design and powerful hardware.", 1250.0, "https://github.com/souzafcharles/3.png");
Product product04 = new Product(null, "PC Gamer", "Experience top-notch gaming performance with this powerful gaming PC, designed for the ultimate gaming experience.", 1200.0, "https://github.com/souzafcharles/4.png");
Product product05 = new Product(null, "Rails for Dummies", "A comprehensive guide to Ruby on Rails for beginners. Learn how to build web applications from scratch.", 100.99, "https://github.com/souzafcharles/5.png");
productRepository.saveAll(Arrays.asList(product01, product02, product03, product04, product05));
```
#### 9.6. Retrieving Category Data via Spring Boot RESTful API:
#### 9.6.1. Endpoint:
* GET `/products`: Retrieves a list of all Products without associated Categories.
#### 9.6.2. Example GET Request:
```markdown
http://localhost:8080/products
```
#### 9.6.3. Example Response:
```json
[
  {
    "id": 1,
    "name": "The Lord of the Rings",
    "description": "An epic fantasy novel by J.R.R. Tolkien. Follow the journey of Frodo Baggins as he attempts to destroy the One Ring.",
    "price": 90.5,
    "imgUri": "https://github.com/souzafcharles/1.png",
    "categories": []
  },
  {
    "id": 2,
    "name": "Smart TV",
    "description": "Enjoy your favorite shows on this sleek Smart TV with vibrant colors and crisp resolution.",
    "price": 2190.0,
    "imgUri": "https://github.com/souzafcharles/2.png",
    "categories": []
  },
  {
    "id": 3,
    "name": "Macbook Pro",
    "description": "Power through your day with this high-performance Macbook Pro, featuring a sleek design and powerful hardware.",
    "price": 1250.0,
    "imgUri": "https://github.com/souzafcharles/3.png",
    "categories": []
  },
  {
    "id": 4,
    "name": "PC Gamer",
    "description": "Experience top-notch gaming performance with this powerful gaming PC, designed for the ultimate gaming experience.",
    "price": 1200.0,
    "imgUri": "https://github.com/souzafcharles/4.png",
    "categories": []
  },
  {
    "id": 5,
    "name": "Rails for Dummies",
    "description": "A comprehensive guide to Ruby on Rails for beginners. Learn how to build web applications from scratch.",
    "price": 100.99,
    "imgUri": "https://github.com/souzafcharles/5.png",
    "categories": []
  }
]
```
#### 9.6.4. Endpoint:
* GET `/products/{id}`: Retrieves a specific Product by its ID without associated Categories.
#### 9.6.5. Example GET Request:
```markdown
http://localhost:8080/products/5
```
#### 9.6.6. Example Response:
```json

{
  "id": 5,
  "name": "Rails for Dummies",
  "description": "A comprehensive guide to Ruby on Rails for beginners. Learn how to build web applications from scratch.",
  "price": 100.99,
  "imgUri": "https://github.com/souzafcharles/5.png",
  "categories": []
}
```
***
### 10. Many-to-Many Association with JoinTable:
#### 10.1. Annotation @JoinTable:
```java
@ManyToMany
@JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
private Set<Category> categories = new HashSet<>();
```
#### 10.2. Summary of the Annotations:
- `@JoinTable`(name = "tb_product_category", joinColumns = `@JoinColumn`(name = "product_id"), `inverseJoinColumns` = `@JoinColumn`(name = "category_id")): This annotation specifies the details of the join table used to manage the many-to-many relationship. name = `"tb_product_category"`: The name of the join table;
- `joinColumns` = `@JoinColumn`(name = "product_id"): Specifies the foreign key column in the join table that references the primary key of the Product entity;
- `inverseJoinColumns` = `@JoinColumn`(name = "category_id"): Specifies the foreign key column in the join table that references the primary key of the Category entity.
#### 10.3. Database Seeding with Products in TestConfig Class and Persist Objects:
```java
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
```
#### 10.4. Retrieving Products with Categories Data via Spring Boot RESTful API:
#### 10.4.1. Endpoint:
* GET `/products`: Retrieves a list of all Products with their associated Categories.
#### 10.4.2. Example GET Request:
```markdown
http://localhost:8080/products
```
#### 10.4.3. Example Response:
```json
[
  {
    "id": 1,
    "name": "The Lord of the Rings",
    "description": "An epic fantasy novel by J.R.R. Tolkien. Follow the journey of Frodo Baggins as he attempts to destroy the One Ring.",
    "price": 90.5,
    "imgUri": "https://github.com/souzafcharles/1.png",
    "categories": [
      {
        "id": 2,
        "name": "Books"
      }
    ]
  },
  {
    "id": 2,
    "name": "Smart TV",
    "description": "Enjoy your favorite shows on this sleek Smart TV with vibrant colors and crisp resolution.",
    "price": 2190.0,
    "imgUri": "https://github.com/souzafcharles/2.png",
    "categories": [
      {
        "id": 1,
        "name": "Electronics"
      },
      {
        "id": 3,
        "name": "Computers"
      }
    ]
  },
  {
    "id": 3,
    "name": "Macbook Pro",
    "description": "Power through your day with this high-performance Macbook Pro, featuring a sleek design and powerful hardware.",
    "price": 1250.0,
    "imgUri": "https://github.com/souzafcharles/3.png",
    "categories": [
      {
        "id": 3,
        "name": "Computers"
      }
    ]
  },
  {
    "id": 4,
    "name": "PC Gamer",
    "description": "Experience top-notch gaming performance with this powerful gaming PC, designed for the ultimate gaming experience.",
    "price": 1200.0,
    "imgUri": "https://github.com/souzafcharles/4.png",
    "categories": []
  },
  {
    "id": 5,
    "name": "Rails for Dummies",
    "description": "A comprehensive guide to Ruby on Rails for beginners. Learn how to build web applications from scratch.",
    "price": 100.99,
    "imgUri": "https://github.com/souzafcharles/5.png",
    "categories": [
      {
        "id": 2,
        "name": "Books"
      }
    ]
  }
]
```
#### 10.4.4. Endpoint:
* GET `/products/{id}`: Retrieves a specific Product by its ID along with its associated Categories.
#### 10.4.5. Example GET Request:
```markdown
http://localhost:8080/products/2
```
#### 10.4.6. Example Response:
```json
{
  "id": 2,
  "name": "Smart TV",
  "description": "Enjoy your favorite shows on this sleek Smart TV with vibrant colors and crisp resolution.",
  "price": 2190.0,
  "imgUri": "https://github.com/souzafcharles/2.png",
  "categories": [
    {
      "id": 1,
      "name": "Electronics"
    },
    {
      "id": 3,
      "name": "Computers"
    }
  ]
}
```
***
### 11. OrderItem, Many-to-Many Association with Extra Attributes:
#### 11.1. Entity Class Requirements for OrderItemPK:
- Create the `OrderItemPK` Entity Class;
- Annotate the class with `@Embeddable` to indicate it is an embeddable key class;
- Define Order and Product attributes as `@ManyToOne` associations, annotated with `@JoinColumn` to define foreign key columns:
    - `Order` → mapped to `order_id`;
    - `Product` → mapped to `product_id`;
- Getters & Setters;
- hashCode & equals;
- Serializable.
#### 11.2. OrderItemPK Class:
```java
@Embeddable
public class OrderItemPK implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
```
#### 11.3. Entity Class Requirements for OrderItem:
- Create the `OrderItem` Entity Class;
- Annotate the class with `@Entity` and `@Table`(name = "tb_order_item") to map it to the database table;
- Basic Attributes;
- Associations (Instantiate Collections);
- Annotate `@Id` and `@GeneratedValue` for the primary key, and `@Column` for other fields;
- Constructors;
- Getters & Setters (Collections: only get);
- hashCode & equals;
- Serializable.
#### 11.5. OrderItem Class Relationship:
- The relationship between `OrderItem` and `Order` is established through the `Composite Key` `OrderItemPK`;
- The `@JsonIgnore` annotation was added to the `getOrder()` method in the `OrderItem` class to prevent an `Infinite Cyclic Reference` issue during `JSON` serialization.
```java
@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private Integer quantity;
    private Double price;

    public OrderItem() {
    }

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }
}
```
#### 11.6. Repository Class Requirement for OrderItem:
- Create an interface that extends `JpaRepository` for the `OrderItem` entity (`extends JpaRepository<OrderItem, Long>`).
#### 11.7. Summary of Annotations:
- `@Embeddable`: Marks the class as embeddable in another class as a composite key;
- `@ManyToOne`: Defines a many-to-one relationship between entities;
- `@JoinColumn`: Specifies the column that uses the foreign key in relationships;
- `@EmbeddedId`: Marks a field as an embedded composite primary key.
#### 11.8. Database Seeding with OrderItem in TestConfig Class and Persist Objects:
```java
OrderItem orderItem01 = new OrderItem(order01, product01, 2, product01.getPrice());
OrderItem orderItem02 = new OrderItem(order01, product03, 1, product03.getPrice());
OrderItem orderItem03 = new OrderItem(order02, product03, 2, product03.getPrice());
OrderItem orderItem04 = new OrderItem(order03, product05, 2, product05.getPrice());

orderItemRepository.saveAll(Arrays.asList(orderItem01, orderItem02, orderItem03, orderItem04));
```
***
### 12. Product-OrderItem One-to-Many Association:
#### 12.1. Relationship of the Product Class with Order and OrderItem:
- `@OneToMany` (in `Product`): Relates `Product` with `OrderItem`, allowing a product to have several `OrderItem`;
- The `getOrders()` function in the `Product` class navigates through the `OrderItem` associated with the product to collect the corresponding orders. This demonstrates the `many-to-many` relationship between `Product` and `Order`, mediated by the`OrderItem` entity;
- **Product Class Relationship**:
```java
public class Product {

    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> items = new HashSet<>();

    public Product() {
    }

    @JsonIgnore
    public Set<Order> getOrders() {
        Set<Order> orderSet = new HashSet<>();
        for (OrderItem orderItem : items) {
            orderSet.add(orderItem.getOrder());
        }
        return orderSet;
    }
}
```
#### 12.2. Retrieving Order with Product-OrderItem Data via Spring Boot RESTful API:
#### 12.2.1. Endpoint:
* GET `/orders/{id}`: Retrieves an Order with its Product-OrderItem Data by the given ID.
#### 12.2.2. Example GET Request:
```markdown
http://localhost:8080/orders/1
```
#### 12.2.3. Example Response:
```json
  {
  "id": 1,
  "moment": "2025-01-19T19:53:07Z",
  "orderStatus": "PAID",
  "user": {
    "id": 1,
    "name": "Balthazar de Bigode",
    "email": "balthazar@email.com",
    "phone": "+5599999999999",
    "password": "******"
  },
  "items": [
    {
      "quantity": 2,
      "price": 90.5,
      "product": {
        "id": 1,
        "name": "The Lord of the Rings",
        "description": "An epic fantasy novel by J.R.R. Tolkien. Follow the journey of Frodo Baggins as he attempts to destroy the One Ring.",
        "price": 90.5,
        "imgUri": "https://github.com/souzafcharles/1.png",
        "categories": [
          {
            "id": 2,
            "name": "Books"
          }
        ]
      }
    },
    {
      "quantity": 1,
      "price": 25.99,
      "product": {
        "id": 13,
        "name": "Nike Dri-FIT Cotton T-Shirt",
        "description": "Comfortable athletic T-shirt with moisture-wicking fabric, available in multiple sizes.",
        "price": 25.99,
        "imgUri": "https://github.com/souzafcharles/13.png",
        "categories": [
          {
            "id": 4,
            "name": "Clothing"
          }
        ]
      }
    },
    {
      "quantity": 1,
      "price": 1250.0,
      "product": {
        "id": 3,
        "name": "Macbook Pro",
        "description": "Power through your day with this high-performance Macbook Pro, featuring a sleek design and powerful hardware.",
        "price": 1250.0,
        "imgUri": "https://github.com/souzafcharles/3.png",
        "categories": [
          {
            "id": 3,
            "name": "Computers"
          }
        ]
      }
    }
  ]
}
 ```
***
### 13. Payment, One-to-One Association:
#### 13.1. Entity Class Requirements for Payment:
- Create the `Payment` Entity Class;
- Annotate the class with `@Entity` and `@Table`(name = "tb_payment") to map it to the database table;
- Basic Attributes;
- Associations (Instantiate Collections);
- Annotate `@Id` and `@GeneratedValue` for the primary key, and `@Column` for other fields;
- Constructors;
- Getters & Setters (Collections: only get);
- hashCode & equals;
- Serializable.
#### 13.2. Payment Class One-to-One Association:
```java
public class Payment {

    @JsonIgnore
    @OneToOne
    @MapsId
    private Order order;
}
```
#### 13.3. Order Class One-to-One Association:
```java
public class Order {

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

}
```
#### 13.4. Database Seeding with Payment in TestConfig Class and Persist Objects:
```java
Payment payment01 = new Payment(null, Instant.parse("2025-01-19T20:31:07Z"), order01);
order01.setPayment(payment01);
Payment payment02 = new Payment(null, Instant.parse("2025-01-23T11:57:59Z"), order07);
order07.setPayment(payment02);
Payment payment03 = new Payment(null, Instant.parse("2025-01-26T15:03:34Z"), order10);
order10.setPayment(payment03);

orderRepository.saveAll(Arrays.asList(order01, order07, order10));
```
- In a `One-to-One` relationship, like in the classes `Order` and `Payment`, one object is dependent on the other. There is no necessity to create a separate `Repository` for the dependent object (in this case, `Payment`).

#### 13.5. Key Concepts:
- `One-to-One` Relationship: In the relationship between `Order` and `Payment`, each `Order` may or may not have a `Payment`, while each `Payment` must be associated with an `Order`;
- `@MapsId`: The `@MapsId` annotation is used to indicate that the `Payment` should share the same primary key as the `Order`. This ensures no duplication, and the `Payment` is uniquely identified by the `Order`'s primary key.
#### 13.6. The In-Memory Association and Primary Object Saving Work:
- A new Payment is created and associated with an Order.
#### 13.7. Bidirectional In-Memory Association:
- The association is established in both directions in memory;
- The `Payment` is associated with the `Order` using `order10.setPayment(payment10)`;
- The `Order` is associated with the `Payment` by defining `@MapsId` on the Payment.
#### 13.8. Primary Object Persistence (Order):
- The primary object (`Order`) is saved in the database using the `OrderRepository`;
- With the `@OneToOne`(mappedBy = "order", cascade = `CascadeType.ALL`) annotation, the `Order` automatically saves the dependent object (`Payment`).
#### 13.9. Retrieving Order with Payment Data via Spring Boot RESTful API:
#### 13.9.1. Endpoint:
* GET `/orders/{id}`: Retrieves an Order with its Payment Data by the given ID.
#### 13.9.2. Example GET Request:
```markdown
http://localhost:8080/orders/10
```
#### 13.9.3. Example Response:
```json
{
  "id": 10,
  "moment": "2025-01-26T14:14:14Z",
  "orderStatus": "PAID",
  "user": {
    "id": 8,
    "name": "Florentino Fidalgo",
    "email": "florentino@email.com",
    "phone": "+5577777777777",
    "password": "******"
  },
  "items": [
    {
      "quantity": 2,
      "price": 159.99,
      "product": {
        "id": 10,
        "name": "Michelin Pilot Sport 4 Tires",
        "description": "High-performance tires with excellent grip and stability for sports cars.",
        "price": 159.99,
        "imgUri": "https://github.com/souzafcharles/10.png",
        "categories": [
          {
            "id": 10,
            "name": "Automotive"
          }
        ]
      }
    }
  ],
  "payment": {
    "id": 10,
    "moment": "2025-01-26T15:03:34Z"
  }
}
 ```
### Object Relational:
![Order Object–Relational](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_S19_Project_Web_Services_with_Spring_Boot_and_JPA_Hibernate/webServices/src/main/resources/static/img/order-object–relational.png)
***
### 14. Subtotal & Total Methods:
#### 14.1. SubTotal Method:
#### 14.1.1. Method Definition:
- This method calculates the subtotal for an `OrderItem`:
```java
public double getSubTotal() {
    return price * quantity;
}
```
#### 14.2. Total Method:
#### 14.1.1. Method Definition:
- This method calculates the total cost of all items in an `Order`.
```java
public double getTotal() {
    return items.stream()
            .mapToDouble(OrderItem::getSubTotal)
            .sum();
}
```
#### 14.3. Retrieving Order Data via Spring Boot RESTful API with Subtotal & Total Methods:
#### 14.3.1. Endpoint:
- GET `/orders/{id}`: Retrieves an Order by its ID.
#### 14.3.2. Example GET Request:
```markdown
http://localhost:8080/orders/1
```
#### 14.3.3. Example Response:
```json
{
  "id": 2,
  "moment": "2025-01-19T03:42:10Z",
  "orderStatus": "WAITING_PAYMENT",
  "user": {
    "id": 2,
    "name": "Ophelia Birrenta",
    "email": "ophelia@email.com",
    "phone": "+5511111111111",
    "password": "******"
  },
  "items": [
    {
      "quantity": 2,
      "price": 1250.0,
      "product": {
        "id": 3,
        "name": "Macbook Pro",
        "description": "Power through your day with this high-performance Macbook Pro, featuring a sleek design and powerful hardware.",
        "price": 1250.0,
        "imgUri": "https://github.com/souzafcharles/3.png",
        "categories": [
          {
            "id": 3,
            "name": "Computers"
          }
        ]
      },
      "subTotal": 2500.0
    },
    {
      "quantity": 2,
      "price": 249.99,
      "product": {
        "id": 14,
        "name": "Garmin Forerunner 245 Music",
        "description": "GPS running smartwatch with music storage and heart-rate monitoring.",
        "price": 249.99,
        "imgUri": "https://github.com/souzafcharles/14.png",
        "categories": [
          {
            "id": 1,
            "name": "Electronics"
          },
          {
            "id": 3,
            "name": "Computers"
          }
        ]
      },
      "subTotal": 499.98
    }
  ],
  "payment": null,
  "total": 2999.98
}
```
***
### 15. CRUD Operation User Class `insert` Method on Service and Resource Layers:
#### 15.1. Service Class Requirements for User:
- Use `@Transactional` for the method inserting data to ensure the method runs within a transaction.
#### 15.2. Resource Class Requirements for User:
- Implement a method to handle `POST` requests to `insert` a new `User` (`@PostMapping`):
```java
@PostMapping
public ResponseEntity<User> insert(@RequestBody User user) {
	user = userService.insert(user);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
	return ResponseEntity.created(uri).body(user);
}
```
#### 15.3. Summary of the Annotations and Commands:
- `@PostMapping`: Maps HTTP `POST` requests to the insert method;
- `@RequestBody`: Binds the HTTP request body containing the `User` data to the `User` parameter;
- `URI`: Represents a Uniform Resource Identifier, which is used to identify a resource in the context of web applications;
- `ServletUriComponentsBuilder`: A utility class in Spring MVC that helps in building `URIs` for `Controllers`;
- `fromCurrentRequest()`: A method of `ServletUriComponentsBuilder` that initializes the builder with the current request's `URI`;
- `path("/{id}")`: Appends a `path` segment to the current `URI`. In this case, it adds `/{id}` to the `URI`, where `{id}` is a placeholder for the `User`'s ID;
- `buildAndExpand(user.getId())`: Replaces the placeholder `{id}` in the `URI` with the actual ID of the `User` object;
- `toUri()`:  Converts the `UriComponents` object into a `URI` object, which can be used in the response.
#### 15.4. Setting Up the RESTful API for HTTP Methods (Non-Idempotent):
#### 15.4.1. Endpoint:
- POST `/users`: Creates a new User.
#### 15.4.2. Example POST Request:
```markdown
http://localhost:8080/users
Body -> raw -> JSON
```
```json
{
"name": "Teodorico Calisto",
"email": "teodorico@email.com",
"phone": "+5599777666555",
"password": "******"
}
```
#### 15.4.3. Example Response:
```json
{
    "id": 11,
    "name": "Teodorico Calisto",
    "email": "teodorico@email.com",
    "phone": "+5599777666555",
    "password": "******"
}
```
***
### 16. CRUD Operation User Class `delete` Method on Service and Resource Layers:
#### 16.1. Service Class Requirements for User:
- Use `@Transactional` for the method deleting data to ensure the method runs within a transaction.
#### 16.2. Resource Class Requirements for User:
- Implement a method to handle `DELETE` requests to delete a new `User` (`@DeleteMapping`):
```java
@DeleteMapping(value = "/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id) {
	userService.delete(id);
	return ResponseEntity.noContent().build();
}

```
#### 16.3. Summary of the Annotations and Commands:
- `@DeleteMapping(value = "/{id}")`: Maps HTTP `DELETE` requests to the delete method. The value = `"/{id}"` specifies that the method will handle requests to `delete` a `User` by their ID, where {`id`} is a path variable;
- `.noContent()`: Returns a  `ResponseEntity ` with a status code of  `204 No Content `, indicating that the request was successful but there is no content to return in the response body;
- `.build()`: Constructs the  `ResponseEntity `  with the specified HTTP status but without a response body. This is commonly used when the response does not require content, such as for operations that successfully complete without returning data (e.g., `DELETE` or update actions that do not return the updated resource).

### 16.4. Setting Up the RESTful API for HTTP Methods (Idempotent):
#### 16.4.1. Endpoint:
- DELETE `/users/{id}`: Deletes a User by ID.
#### 16.4.2. Example DELETE Request:
```markdown
http://localhost:8080/users/1
```
#### 16.4.3. Example Response:
- Status Code: `204 No Content`;
- Response Body: `None`
***
### 17. CRUD Operation User Class `update` Method on Service and Resource Layers:
#### 17.1. Service Class Requirements for User:
- Use a method to update an existing `User` object in the database by retrieving it based on its `id`;
- Ensure transactional integrity during the update operation using `@Transactional`;
- Map the updated values to the retrieved `User` entity using a helper method such as `updateData`:
````java
@Transactional
public User update(Long id, User user){
    User entity = userRepository.getReferenceById(id);
    updateData(entity, user);
    return userRepository.save(entity);
}

@Transactional
private void updateData(User entity, User user) {
    entity.setName(user.getName());
    entity.setEmail(user.getEmail());
    entity.setPhone(user.getPhone());
}
````
- After the necessary updates are applied to the entity, the method calls `userRepository.save(entity)` to persist the changes in the database. This method handles both updates and inserts based on the entity state, making it versatile for data operations.
#### 17.2. Resource Class Requirements for User:
- Handle `PUT` requests to update an existing `User` by its `id`:
```java
@PutMapping(value = "/{id}")
public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
    user = userService.update(id, user);
    return ResponseEntity.ok().body(user);
}
```
- Extract the `id` from the URL using `@PathVariable`;
- Bind the request body containing the updated user data to the `User` parameter using `@RequestBody`;
- Call the `update` method in the `UserService` to perform the update operation.
#### 17.3. Summary of the Annotations and Commands:
- `@PutMapping`: Maps HTTP `PUT` requests to the `update` method.
- `userRepository.getReferenceById(id)`: Efficiently retrieves a reference to the existing entity for updating without executing a full query.
- `updateData(entity, user)`: Helper method to map the updated fields to the existing `User` entity.
#### 17.4. Setting Up the RESTful API for HTTP Methods (Idempotent):
#### 17.4.1. Endpoint:
- **PUT** `/users/{id}`: Updates an existing User by its `id`.
#### 17.4.2. Example PUT Request:
```markdown
http://localhost:8080/users/11
Body -> raw -> JSON
```
```json
{
  "name": "Eulalia Carvalhosa",
  "email": "eulalia@email.com",
  "phone": "+5599888777666"
}
```
#### 17.4.3. Example Response:
```json
{
  "id": 11,
  "name": "Eulalia Carvalhosa",
  "email": "eulalia@email.com",
  "phone": "+5599888777666",
  "password": "******"
}
```
***
### 18. Exception Handling:
#### 18.1. Requirements for Entity StandardError Class:
- Create the `StandardError` Entity Class;
- Basic Attributes;
  - `timestamp`: The time when the error occurred, formatted using `@JsonFormat`;
  - `status`: The HTTP status code returned by the server;
  - `error`: A short, descriptive error message;
  - `message`: A detailed message explaining the error;
  - `path`: The URI path where the error occurred;
- Constructors;
- Getters & Setters;
- Serializable.
#### 18.2. Requirements for ResourceExceptionHandler Class:
- **ControllerAdvice annotation**: The class should be annotated with `@ControllerAdvice` to handle exceptions globally in the Spring application;
- **ExceptionHandler annotation**: The class should contain methods annotated with `@ExceptionHandler` to handle specific exceptions, such as `ResourceNotFoundException` and `DatabaseException`;
- **StandardError class**: The `StandardError` class should be implemented to structure the error responses. It should contain fields like timestamp, status code, error message, exception message, and request URI;
- **ResponseEntity**: Methods should return a `ResponseEntity` that contains the error details, including HTTP status code and body content;
- **HttpServletRequest**: The methods should accept an `HttpServletRequest` object to capture the request URI and include it in the error response;
- **Error messages**: Define clear and specific error messages for each exception (e.g., "The requested resource was not found." and "An error occurred while processing your request with the database.");
- **HttpStatus**: Set the appropriate HTTP status codes for each exception (e.g., `NOT_FOUND` for resource not found, `BAD_REQUEST` for database-related errors);
- **Time-stamping**: Use `Instant.now()` to add a timestamp to the error response for each exception.
#### 18.2.1. resourceNotFound(ResourceNotFoundException e, HttpServletRequest request):
- **@ExceptionHandler(ResourceNotFoundException.class)**: This method will handle exceptions of type `ResourceNotFoundException` globally;
- **String error**: Defines a custom error message to return when the requested resource is not found;
- **HttpStatus status**: Sets the HTTP status to `NOT_FOUND` (404) to indicate a missing resource;
- **StandardError err**: Creates a new instance of the `StandardError` class, passing in the current timestamp, status code, error message, exception message, and the request URI;
- **ResponseEntity.status(status).body(err)**: Returns a `ResponseEntity` with the status code and the error details.
#### 18.2.2. database(DatabaseException e, HttpServletRequest request):
- **@ExceptionHandler(DatabaseException.class)**: This method will handle exceptions of type `DatabaseException` globally;
- **String error**: Defines a custom error message to return when an error occurs with database processing;
- **HttpStatus status**: Sets the HTTP status to `BAD_REQUEST` (400) to indicate a database-related error;
- **StandardError err**: Creates a new instance of the `StandardError` class, passing in the current timestamp, status code, error message, exception message, and the request URI;
- **ResponseEntity.status(status).body(err)**: Returns a `ResponseEntity` with the status code and the error details.
### 18.3. Requirements for DatabaseException Class:
- **Extend RuntimeException**: The `DatabaseException` class should extend `RuntimeException` to make it an unchecked exception;
- **SerialVersionUID**: Define a `serialVersionUID` for serialization compatibility. Annotate it with `@Serial` for automatic versioning of the class during serialization;
- **Constructor with Message**: Provide a constructor that accepts a custom error message (`String msg`) to be passed to the superclass `RuntimeException`. This allows for generating specific exception messages;
- **Custom Exception Message**: The message passed to the constructor will be used to provide detailed, customized error messages when the exception is thrown.
### 18.4. Requirements for ResourceNotFoundException Class:
- **Extend RuntimeException**: The `ResourceNotFoundException` class should extend `RuntimeException` to make it an unchecked exception;
- **SerialVersionUID**: Define a `serialVersionUID` for serialization compatibility. Annotate it with `@Serial` for automatic versioning of the class during serialization;
- **Constructor with ID**: Provide a constructor that accepts an `Object id` to represent the unique identifier of the resource that could not be found. This allows for generating specific exception messages based on the resource ID;
- **Custom Exception Message**: The message passed to the constructor will be used to provide a detailed, customized error message when the exception is thrown. The format should be: `"Resource not found. ID <id>"`.
### 18.5. Methods with Exception Handling in UserService:
1. **findById(Long id)**:
  - **Exception Type**: `ResourceNotFoundException`;
  - **Explanation**: If the `User` with the specified `id` is not found in the database (i.e., `Optional<User>` is empty), a `ResourceNotFoundException` is thrown with the `id` passed as part of the exception message. This custom exception helps provide a specific error message for missing resources.
2. **delete(Long id)**:
  - **Exception Type**: `ResourceNotFoundException`, `DatabaseException`;
  - **Explanation**:
    - `ResourceNotFoundException`: If an attempt is made to delete a user that doesn't exist in the database (i.e., `EmptyResultDataAccessException` occurs), a `ResourceNotFoundException` is thrown with the `id` of the non-existent resource;
    - `DatabaseException`: If there is an issue with the database integrity (e.g., a constraint violation occurs), a `DatabaseException` is thrown, with the exception message captured from `DataIntegrityViolationException`. This helps handle database-related errors.
3. **update(Long id, User user)**:
  - **Exception Type**: `ResourceNotFoundException`;
  - **Explanation**: If the `User` with the specified `id` does not exist (i.e., `EntityNotFoundException` is thrown when fetching the user with `getReferenceById()`), a `ResourceNotFoundException` is thrown with the `id` of the non-existent user. This ensures that updates to non-existent users are handled appropriately with a custom exception message.
### Summary:
- The `ResourceNotFoundException` is used for situations where a resource is not found (e.g., user not found by `id` or during deletion);
- The `DatabaseException` is used to handle database-related issues like integrity violations during delete operations.
***
## Project Checklist:
- [X] Create a Java Spring Boot Project;
- [X]  Structure Logical Layers: Resource, Service, Repository;
- [X]  Implement the Domain Model;
- [X]  Configure the Test Database (H2);
- [X]  Populate the Database;
- [X]  CRUD - Create, Read, Update and Delete;
- [X] Exception Handling.
