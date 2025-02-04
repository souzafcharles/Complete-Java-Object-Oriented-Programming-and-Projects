# Spring Boot Project and MongoDB Database (Web Services + NoSQL)
***
## Instructions:
<p align="justify">
This project outlines the development of a robust <code>RESTful API</code> using the <code>Spring Boot</code> framework in conjunction with <code>MongoDB</code>. The primary objective is to create a fully functional backend system capable of managing user data and their associated posts, incorporating features such as <code>CRUD operations</code>, <code>data transfer objects (DTOs)</code>, and <code>exception handling</code>. The project will emphasise best practices in software design, including the implementation of a service layer for business logic and a repository layer for database interactions. Furthermore, it will explore the use of <code>nested objects</code> and <code>database references</code> to model relationships between users and posts, as well as the implementation of <code>query methods</code> and <code>custom queries</code> for data retrieval. The resulting API will provide a comprehensive set of endpoints for managing users, posts, and comments, demonstrating a practical application of <code>Spring Boot</code> and <code>MongoDB</code> in a real-world scenario.
</p>

### Logical Layers:
![Logical Layers](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_U21_Spring_Boot_Project_and_MongoDB_Database_Web_Services_NoSQL/mongodbspringboot/src/main/resources/static/img/logical-layers.png)
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

***
### 3. Requesting and Responding User Data via Spring Boot RESTful API:
#### 3.1. Setting Up the RESTful API for HTTP Methods (Idempotent):
- **Endpoint**: GET `/users`: Retrieves a list of all Users.
#### 5.2. Example GET Request:
````json
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


## Project Checklist:
:ballot_box_with_check: Set up a Java Spring Boot project with MongoDB dependencies;
:ballot_box_with_check: Implement the User entity and RESTful endpoints;
- Configure MongoDB connection and data instantiation;
- Implement DTOs for User representation;
- Implement CRUD operations for Users, including exception handling for resource not found;
- Develop the Post entity with nested User information;
- Implement DTOs for Post and Author;
- Implement CRUD operations for Posts, including association with Users;
- Implement endpoints for retrieving user posts;
- Add Comment functionality to Posts;
- Implement custom queries for Post retrieval (simple and multi-criteria);
- Implement URL parameter decoding for query methods.
