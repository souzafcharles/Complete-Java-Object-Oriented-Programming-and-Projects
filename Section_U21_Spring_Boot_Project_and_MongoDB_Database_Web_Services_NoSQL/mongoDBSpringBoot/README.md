# Spring Boot Project and MongoDB Database (Web Services + NoSQL)
***
## Instructions:
<p align="justify">
This project outlines the development of a robust <code>RESTful API</code> using the <code>Spring Boot</code> framework in conjunction with <code>MongoDB</code>. The primary objective is to create a fully functional backend system capable of managing user data and their associated posts, incorporating features such as <code>CRUD operations</code>, <code>data transfer objects (DTOs)</code>, and <code>exception handling</code>. The project will emphasise best practices in software design, including the implementation of a service layer for business logic and a repository layer for database interactions. Furthermore, it will explore the use of <code>nested objects</code> and <code>database references</code> to model relationships between users and posts, as well as the implementation of <code>query methods</code> and <code>custom queries</code> for data retrieval. The resulting API will provide a comprehensive set of endpoints for managing users, posts, and comments, demonstrating a practical application of <code>Spring Boot</code> and <code>MongoDB</code> in a real-world scenario.
</p>

### Logical Layers:
![Logical Layers](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_U21_Spring_Boot_Project_and_MongoDB_Database_Web_Services_NoSQL/mongoDBSpringBoot/src/main/resources/static/img/logical-layers.png)
***
### 1. Backend Requirements Specification:
#### 1.1. Dependencies and Tools:
- **Spring Initializr Configuration:**
  - Build Tool: **Maven;**
  - Programming Language: **Java 21;**
  - Packaging Type: **JAR;**
  - Required Dependencies:
    - **Spring Web;**
    - **Spring Data MongoDB.**
***

## Project Checklist:

:ballot_box_with_check: Set up a Java Spring Boot project with MongoDB dependencies;
 - Implement the User entity and RESTful endpoints;
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
