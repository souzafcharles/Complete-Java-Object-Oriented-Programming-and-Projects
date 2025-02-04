# Spring Boot Project and MongoDB Database (Web Services + NoSQL)
***
## Instructions:
<p align="justify">
This project outlines the development of a robust <code>RESTful API</code> using the <code>Spring Boot</code> framework in conjunction with <code>MongoDB</code>. The primary objective is to create a fully functional backend system capable of managing user data and their associated posts, incorporating features such as <code>CRUD operations</code>, <code>data transfer objects (DTOs)</code>, and <code>exception handling</code>. The project will emphasise best practices in software design, including the implementation of a service layer for business logic and a repository layer for database interactions. Furthermore, it will explore the use of <code>nested objects</code> and <code>database references</code> to model relationships between users and posts, as well as the implementation of <code>query methods</code> and <code>custom queries</code> for data retrieval. The resulting API will provide a comprehensive set of endpoints for managing users, posts, and comments, demonstrating a practical application of <code>Spring Boot</code> and <code>MongoDB</code> in a real-world scenario.
</p>

### Logical Layers:
![Logical Layers](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_U21_Spring_Boot_Project_and_MongoDB_Database_Web_Services_NoSQL/mongoDBSpringBoot/src/main/resources/static/img/logical-layers.png)
---
### 1. Backend Requirements Specification:
#### 1.1. Dependencies and Tools:
- **Spring Initializr Configuration:**
    - Build Tool: **Maven;**
    - Programming Language: **Java 21;**
    - Packaging Type: **JAR;**
    - Required Dependencies:
        - **Spring Web;**
        - **Spring Data MongoDB.**
---
### 2. Entity and Controller Classes:
#### 2.1. Requirements for User Entity Class:
- **Entity Mapping:**
    - Create the `User` class as an entity to represent a database table in the application;
    - Annotate the class with `@Document` to define it as a MongoDB document (not a traditional JPA entity);
- **Attributes and Annotations:**
    - Define attributes `id`, `name`, and `email` to represent fields in the document;
    - Annotate the `id` field with `@Id` to designate it as the primary key field;
- **Constructors:**
    - Create a no-argument constructor required by the persistence framework;
    - Provide an all-arguments constructor for convenience;
    - Include a constructor that accepts a `User` object to map `User` data easily;
- **Accessors and Mutators:**
    - Implement `getters` and `setters` for all attributes to allow data manipulation;
- **Equals and HashCode:**
    - Override the `equals()` method to compare entities based on the `id` attribute;
    - Override `hashCode()` to provide a consistent hash for `User` objects, using `Objects.hashCode(id)`;
- **Serializable Interface:**
    - Implement the `Serializable` interface to support object serialization for the entity when necessary (e.g., when transferring objects between systems).
#### 2.1. Requirements for UserResource Class:
- Create the `UserResource` class to manage RESTful endpoints for the `User` resource;
- Use `@RestController` annotation to mark it as a REST controller for Spring;
- Map requests using the `@RequestMapping` annotation for the `/users` endpoint;
- Inject `UserService` (or similar) using `@Autowired` for service dependency injection;
- Implement a method to handle `GET` requests:
    - Use `@GetMapping` annotation to map GET requests to `/users`;
    - Return a `ResponseEntity<List<User>>` with an HTTP 200 (OK) status and the list of users;
    - Handle empty lists and return an HTTP 204 (No Content) status if no users are found;
- Use `@CrossOrigin(origins = "*", allowedHeaders = "*")` annotation to allow cross-origin requests from any origin;
- Ensure that the class implements the `Serializable` interface to support object serialization when needed.
---
### 3. Configuration of Environment:
#### 3.1. Configuration of the `application.properties` File:
- This file defines the general configurations of the application:
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/mongoDBSpringBoot
````
### 4. Repository Interface, Service and Resource/Controller Classes:
#### 4.1. Requirements for UserRepository Interface:
- **Repository Creation:**
  - Create the `UserRepository` interface to handle data access operations for the `User` entity;
- **MongoRepository Extension:**
  - Extend `MongoRepository<User, String>` to inherit common CRUD operations and MongoDB-specific functionalities;
- **Entity Association:**
  - Specify `User` as the associated entity and `String` as the type for its primary key.
#### 4.2. Requirements for UserServices Class:
- Use `@Service` annotation to define the class as a Spring service component;
- Inject `UserRepository` using `@Autowired` for dependency injection;
- Implement methods to retrieve all `User` entities:
  - `findAll`: Fetches all entries from the database;
  - Use `@Transactional(readOnly = true)` to ensure the method runs within a read-only transaction for optimized database performance.
#### 4.3. Requirements for UserResource Class:
- Create the `UserResource` class to manage RESTful endpoints for the `User` resource;
- Use `@RestController` annotation to mark it as a REST controller for Spring;
- Map requests using the `@RequestMapping` annotation for the `/users` endpoint;
- Inject `UserServices` using `@Autowired` for service dependency injection;
- Implement a method to handle `GET` requests:
  - Use `@GetMapping` annotation to map GET requests to `/users`;
  - Return a `ResponseEntity<List<User>>` with an HTTP 200 (OK) status and the list of users;
  - Handle empty lists and return an HTTP 204 (No Content) status if no users are found;
- Use `@CrossOrigin(origins = "*", allowedHeaders = "*")` annotation to allow cross-origin requests from any origin;
- Ensure that the class implements the `Serializable` interface to support object serialization when needed.
---

### 5. Database Initialization Operation:
#### 5.1 In the `config` Subpackage, Create the `Instantiation` Configuration Class Implementing `CommandLineRunner`:
```java
import com.souza.charles.mongoDBSpringBoot.domain.User;
import com.souza.charles.mongoDBSpringBoot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User user01 = new User(null, "Balthazar de Bigode", "balthazar@email.com");
        User user02 = new User(null, "Ophelia Birrenta", "ophelia@email.com");
        User user03 = new User(null, "Gonçalo Munhoz", "goncalo@email.com");
        User user04 = new User(null, "Vitalina Simplicio", "vitalina@email.com");
        User user05 = new User(null, "Ludovico Crispim", "ludovico@email.com");
        User user06 = new User(null, "Filisbina Junqueira", "filisbina@email.com");

        userRepository.saveAll(Arrays.asList(user01, user02, user03, user04, user05, user06));
    }
}
````
#### 5.2. Requirements for Instantiation Class:
- **Package Structure:**
  - Place the `Instantiation` class under the `config` subpackage;
- **Class Definition:**
  - Implement the `CommandLineRunner` interface to execute code during application startup;
- **Annotations and Configuration:**
  - Annotate the class with `@Configuration` to mark it as a configuration class for Spring;
  - Use `@Autowired` to inject the `UserRepository` dependency;
- **Database Seeding:**
  - Implement the `run` method to perform the following operations:
    - Delete all existing `User` documents from the database using `userRepository.deleteAll()`;
    - Create new `User` objects with sample data;
    - Save all newly created `User` objects using `userRepository.saveAll(Arrays.asList(...))`;
- **Error Handling:**
  - Ensure that any exceptions are handled or propagated as necessary.
#### 5.3. Summary of the Annotations and Commands:
- `@Configuration`: Indicates that the class can be used by the Spring IoC container as a source of bean definitions;
- `@Autowired`: Allows Spring to resolve and automatically inject the marked dependency;
- `CommandLineRunner`: Interface used to execute specific code when the Spring Boot application starts;
- `userRepository.deleteAll()`: Removes all existing documents from the `user` collection to ensure a clean database state for seeding;
- `new User(null, "name", "email")`: Creates a new instance of the `User` entity with specified name and email values;
- `userRepository.saveAll(Arrays.asList(...))`: Saves multiple `User` objects into the database in a single operation, improving efficiency;
- `@Override`: Specifies that the method overrides a superclass method.
---
### 6. Requesting and Responding User Data via Spring Boot RESTful API:
#### 6.1. Setting Up the RESTful API for HTTP Methods (Idempotent):
- **Endpoint**: GET `/users`: Retrieves a list of all Users.
#### 6.2. Example GET Request:
````markdown
http://localhost:8080/users
````
#### 6.3. Example GET Request:
````json
[
  {
    "id": "67a2409ef1378e0d5af372cc",
    "name": "Balthazar de Bigode",
    "email": "balthazar@email.com"
  },
  {
    "id": "67a2413ff1378e0d5af372cd",
    "name": "Ophelia Birrenta",
    "email": "ophelia@email.com"
  },
  {
    "id": "67a241c0f1378e0d5af372ce",
    "name": "Gonçalo Munhoz",
    "email": "goncalo@email.com"
  },
  {
    "id": "67a24469f1378e0d5af372cf",
    "name": "Vitalina Simplicio",
    "email": "vitalina@email.com"
  },
  {
    "id": "67a244b0f1378e0d5af372d0",
    "name": "Ludovico Crispim",
    "email": "ludovico@email.com"
  },
  {
    "id": "67a244e1f1378e0d5af372d1",
    "name": "Filisbina Junqueira",
    "email": "filisbina@email.com"
  }
]
````
### 7. DTOs Pattern for User Representation:
#### 7.1. Requirements for UserResponseDTO Record Class:
- **Record Declaration:**
  - Create the `UserResponseDTO` as a `record` class to represent a simplified data structure for responses;
- **Attribute Definition:**
  - Define the attributes `String id`, `String name`, and `String email` directly in the record's header to make them immutable and automatically provide accessor methods;
- **Entity-based Constructor:**
  - Implement a custom constructor that accepts a `User` entity object as an argument;
  - Extract and map values from the `User` entity to initialize the `UserResponseDTO` attributes;
- **Purpose:**
  - Use this `record` for transferring user-related data from the backend service layer to the controller response, following RESTful API conventions.
#### 7.2. Requirements for UserRequestDTO Record Class:
- **Record Declaration:**
  - Create the `UserRequestDTO` as a `record` class to represent the request payload for creating or updating user entries;
- **Attribute Definition:**
  - Define the attributes `String id`, `String name`, and `String email` directly in the record's header to enable immutability and automatic generation of accessor methods;
- **Purpose:**
  - Use this `record` for receiving and validating user input from client requests to create/insert or update `User` entities within the application.
#### 7.3. Service Layer Refactoring Requirements:
- **Service Layer Responsibility:**
  - Ensure that the `UserServices` class contains the business logic for retrieving users from the database;
- **Return Type Update:**
  - Update the `findAll()` method to return a list of `UserResponseDTO` objects instead of `User` objects;
- **Mapping Logic:**
  - Use Java streams to transform the list of `User` entities into a list of `UserResponseDTO` objects;
- **Purpose:**
  - Improve encapsulation and ensure that only essential user information is exposed to the REST controller.
#### 7.4. Controller Layer Refactoring Requirements:
- **Controller Layer Responsibility:**
  - Ensure that `UserResource` communicates directly with the `UserServices` service to retrieve user information;
- **Return Type Update:**
  - Update the `findAll()` method to return a list of `UserResponseDTO` objects wrapped in a `ResponseEntity`;
- **Status Code Handling:**
  - Return `204 No Content` when the list is empty;
  - Return `200 OK` along with the list when user data is available;
- **Cross-Origin Resource Sharing (CORS):**
  - Ensure the use of `@CrossOrigin` annotation to handle cross-origin requests;
- **Purpose:**
  - Ensure clear and accurate communication between client and server using RESTful API conventions.
---
## Project Checklist:
:ballot_box_with_check: Set up a Java Spring Boot project with MongoDB dependencies;</br>
:ballot_box_with_check: Implement the User entity and RESTful endpoints;</br>
:ballot_box_with_check: Configure MongoDB connection and data instantiation;</br>
:ballot_box_with_check: Database initialization operation;</br>
:ballot_box_with_check: Implement DTOs Pattern for User Representation;
- Implement CRUD Operations for Users, including Exception Handling for resource not found;
- Develop the Post entity with nested User information;
- Implement DTOs for Post and Author;
- Implement CRUD operations for Posts, including association with Users;
- Implement endpoints for retrieving user posts;
- Add Comment functionality to Posts;
- Implement custom queries for Post retrieval (simple and multi-criteria);
- Implement URL parameter decoding for query methods.
