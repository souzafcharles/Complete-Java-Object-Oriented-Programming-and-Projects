# Project: Web Services with Spring Boot and JPA/Hibernate
***
## Instructions:
<p align="justify">
Develop a Java application using the <code>Spring Boot</code> framework to implement an order management system based on the domain model presented in the provided diagram. The application should be able to manage the entities represented in the diagram, implementing the necessary logical layers, such as <code>REST</code> resources, services for business logic, and repositories for data access. Configure the <code>H2</code> test database and insert initial data to simulate a realistic environment. The system should include <code>create</code>, <code>read</code>, <code>update</code>, and <code>delete</code> (<code>CRUD</code>) functionalities for all entities, ensuring the correct functioning of associations and the <code>OrderStatus</code> enum. Additionally, implement an <code>exception handling</code> mechanism to handle errors appropriately and provide clear responses to the user. The created <code>REST API</code> should allow for complete management of the system, ensuring data consistency and efficient execution of operations.
</p>

### Logical Layers:

![Logical Layers](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_S19_Project_Web_Services_with_Spring_Boot_and_JPA_Hibernate/webServices/img/logical-layers.png)
***
## Steps to Follow:
### 1. Project Created
#### Requirements Specification:
- Spring Initializr:
  - Maven;
  - Java 21;
  - Packing JAR;
  - Dependencies: Spring Web.
***
### 2. User Entity and Resource Class:
![Domain Model Entity](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_S19_Project_Web_Services_with_Spring_Boot_and_JPA_Hibernate/webServices/img/domain-model.png)
#### Entity Requirements: 
- Create the User Entity Class;
- Basic Attributes;
- Associations (Instantiate Collections);
- Constructors;
- Getters & Setters (Collections: only get);
- hashCode & equals;
- Serializable.

#### UserResource Class:
```java
@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @GetMapping
    public ResponseEntity<User> findAll(){
        User user = new User(1L, "Balthazar de Bigode", "balthazar@rmail.com", "+5516999999999", "******");
        return ResponseEntity.ok().body(user);
    }
}
```
#### Summary of the Annotations:
- `@RestController`: Defines the class as a RESTful controller;
- `@RequestMapping(value = "/users")`: Maps the class to the /users endpoint;
- `@GetMapping`: Maps HTTP GET requests to the findAll method;
- `ResponseEntity<User> findAll()`: Returns an HTTP response containing a User object.
***

## Checklist:
:ballot_box_with_check: Create a Java Spring Boot Project;
- Implement the Domain Model;
- Structure Logical Layers: Resource, Service, Repository;
- Configure the Test Database (H2);
- Populate the Database;
- CRUD - Create, Retrieve, Update, Delete;
- Exception Handling.