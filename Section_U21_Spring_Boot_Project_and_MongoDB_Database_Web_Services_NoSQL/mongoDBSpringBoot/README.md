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
### 3. Requesting and Responding User Data via Spring Boot RESTful API:
#### 3.1. Setting Up the RESTful API for HTTP Methods (Idempotent):
- **Endpoint**: GET `/users`: Retrieves a list of all Users.
#### 5.2. Example GET Request:
````markdown
http://localhost:8080/users
````
#### 3.3. Example GET Request:
````json
[
  {
    "id": 1001,
    "name": "Balthazar de Bigode",
    "email": "balthazar@email.com"
  },
  {
    "id": 1002,
    "name": "Ophelia Birrenta",
    "email": "ophelia@email.com"
  }
]
````
---
### 4. Configuration of Environment:
#### 4.1. Configuration of the `application.properties` File:
- This file defines the general configurations of the application:
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/mongoDBSpringBoot
````
### 5. Repository Interface, Service and Resource/Controller Classes:
#### 5.1. Requirements for UserRepository Interface:
- **Repository Creation:**
  - Create the `UserRepository` interface to handle data access operations for the `User` entity;
- **MongoRepository Extension:**
  - Extend `MongoRepository<User, String>` to inherit common CRUD operations and MongoDB-specific functionalities;
- **Entity Association:**
  - Specify `User` as the associated entity and `String` as the type for its primary key.
#### 5.2. Requirements for UserServices Class:
- Use `@Service` annotation to define the class as a Spring service component;
- Inject `UserRepository` using `@Autowired` for dependency injection;
- Implement methods to retrieve all `User` entities:
  - `findAll`: Fetches all entries from the database;
  - Use `@Transactional(readOnly = true)` to ensure the method runs within a read-only transaction for optimized database performance.
#### 5.3. Requirements for UserResource Class:
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
### 6. Database Seeding with User Data in MongoDB:
````json
{
  "_id": {
    "$oid": "67a2409ef1378e0d5af372cc"
  },
  "name": "Balthazar de Bigode",
  "email": "balthazar@email.com"
}

{
  "_id": {
    "$oid": "67a2413ff1378e0d5af372cd"
  },
  "name": "Ophelia Birrenta",
  "email": "ophelia@email.com"
}

{
  "_id": {
    "$oid": "67a241c0f1378e0d5af372ce"
  },
  "name": "Gonçalo Munhoz",
  "email": "goncalo@email.com"
}

{
  "_id": {
    "$oid": "67a24469f1378e0d5af372cf"
  },
  "name": "Vitalina Simplicio",
  "email": "vitalina@email.com"
}

{
  "_id": {
    "$oid": "67a244b0f1378e0d5af372d0"
  },
  "name": "Ludovico Crispim",
  "email": "ludovico@email.com"
}

{
  "_id": {
    "$oid": "67a244e1f1378e0d5af372d1"
  },
  "name": "Filisbina Junqueira",
  "email": "filisbina@email.com"
}
````
---
### 7. Requesting and Responding User Data via Spring Boot RESTful API:
#### 7.1. Setting Up the RESTful API for HTTP Methods (Idempotent):
- **Endpoint**: GET `/users`: Retrieves a list of all Users.
#### 7.2. Example GET Request:
````markdown
http://localhost:8080/users
````
#### 7.3. Example GET Request:
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
### 8. Database Initialization Operation:
#### 8.1 In the `config` Subpackage, Create the `Instantiation` Configuration Class Implementing `CommandLineRunner`:
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
#### 8.2 Summary of the Annotations and Commands:
- `@Configuration`: Indicates that the class can be used by the Spring IoC container as a source of bean definitions;
- `@Autowired`: Allows Spring to resolve and automatically inject the marked dependency;
- `CommandLineRunner`: Interface used to execute specific code when the Spring Boot application starts;
- `userRepository.deleteAll()`: Removes all existing documents from the `user` collection to ensure a clean database state for seeding;
- `new User(null, "name", "email")`: Creates a new instance of the `User` entity with specified name and email values;
- `userRepository.saveAll(Arrays.asList(...))`: Saves multiple `User` objects into the database in a single operation, improving efficiency;
- `@Override`: Specifies that the method overrides a superclass method.
#### 8.3 Requirements for Instantiation Class:
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
---
## Project Checklist:
:ballot_box_with_check: Set up a Java Spring Boot project with MongoDB dependencies;</br>
:ballot_box_with_check: Implement the User entity and RESTful endpoints;</br>
:ballot_box_with_check: Configure MongoDB connection and data instantiation;</br>
:ballot_box_with_check: Database initialization operation;
- Implement DTOs for User Representation;
- Implement CRUD Operations for Users, including Exception Handling for resource not found;
- Develop the Post entity with nested User information;
- Implement DTOs for Post and Author;
- Implement CRUD operations for Posts, including association with Users;
- Implement endpoints for retrieving user posts;
- Add Comment functionality to Posts;
- Implement custom queries for Post retrieval (simple and multi-criteria);
- Implement URL parameter decoding for query methods.
