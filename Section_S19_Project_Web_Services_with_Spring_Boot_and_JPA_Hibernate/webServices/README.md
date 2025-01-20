# Project: Web Services with Spring Boot and JPA/Hibernate
***
## Instructions:
<p align="justify">
Develop a Java application using the `Spring Boot` framework to implement an order management system based on the domain model presented in the provided diagram. The application should be able to manage the entities represented in the diagram, implementing the necessary logical layers, such as `REST` resources, services for business logic, and repositories for data access. Configure the `H2` test database and insert initial data to simulate a realistic environment. The system should include `create`, `read`, `update`, and `delete` (`CRUD`) functionalities for all entities, ensuring the correct functioning of associations and the `OrderStatus` enum. Additionally, implement an `exception handling` mechanism to handle errors appropriately and provide clear responses to the user. The created `REST API` should allow for complete management of the system, ensuring data consistency and efficient execution of operations.
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
### 2. User Entity and Resource
![Domain Model Entity](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_S19_Project_Web_Services_with_Spring_Boot_and_JPA_Hibernate/webServices/img/domain-model.png)
#### Entity Requirements: 
- Create the Entities Classes;
- Basic Attributes;
- Associations (Instantiate Collections);
- Constructors;
- Getters & Setters (Collections: only get);
- hashCode & equals;
- Serializable.
***
## Checklist:
:ballot_box_with_check: Create a Java Spring Boot Project;
- Implement the Domain Model;
- Structure Logical Layers: Resource, Service, Repository;
- Configure the Test Database (H2);
- Populate the Database;
- CRUD - Create, Retrieve, Update, Delete;
- Exception Handling.