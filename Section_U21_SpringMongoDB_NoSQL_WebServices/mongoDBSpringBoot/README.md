# Spring Boot Project and MongoDB Database (Web Services + NoSQL)
***
## Instructions:
<p align="justify">
This project outlines the development of a robust <code>RESTful API</code> using the <code>Spring Boot</code> framework in conjunction with <code>MongoDB</code>. The primary objective is to create a fully functional backend system capable of managing user data and their associated posts, incorporating features such as <code>CRUD operations</code>, <code>data transfer objects (DTOs)</code>, and <code>exception handling</code>. The project will emphasise best practices in software design, including the implementation of a service layer for business logic and a repository layer for database interactions. Furthermore, it will explore the use of <code>nested objects</code> and <code>database references</code> to model relationships between users and posts, as well as the implementation of <code>query methods</code> and <code>custom queries</code> for data retrieval. The resulting API will provide a comprehensive set of endpoints for managing users, posts, and comments, demonstrating a practical application of <code>Spring Boot</code> and <code>MongoDB</code> in a real-world scenario.
</p>

### Logical Layers:
![Logical Layers](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_U21_SpringMongoDB_NoSQL_WebServices/mongoDBSpringBoot/src/main/resources/static/img/logical-layers.png)
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
---
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
### 6. Success Case: Requesting and Responding User Data via Spring Boot RESTful API (`findAll`):
#### 6.1. Setting Up the RESTful API for HTTP Methods (`Idempotent`):
- **Endpoint:** `GET /users`;
- **Purpose:** Retrieves a list of all Users.
#### 6.2. Example GET Request:
- **Scenario:** Successfully retrieves a list of all users:
````markdown
http://localhost:8080/users
````
#### 6.3. Example Response:
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
### 8. Implement `findById` operation for Users, including Exception Handling for resource not found:
#### 8.1. **NEW METHOD:** `UserServices.findById`:
- Implement a method to retrieve a `User` entity by its `id`:
  - **Purpose:** Fetches a single `User` entity by its identifier and maps it to a `UserResponseDTO`;
  - **Transaction:** Annotate with `@Transactional(readOnly = true)` to ensure that the method runs within a read-only transaction;
  - **Exception Handling:** Throws a custom `ResourceNotFoundException` if the user is not found.
##### 8.1.1. Sample Code:
````java
@Transactional(readOnly = true)
public UserResponseDTO findById(String id) {
    User result = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    return new UserResponseDTO(result);
}
````
#### 8.2. **NEW METHOD**: `UserResource.findById`:
- Implement a method to handle `GET` requests by `id`:
  - **Purpose:** Handle `GET` requests to retrieve a User by its identifier;
  - **Mapping:** Use `@GetMapping(value = "/{id}")` to map the request;
  - **Response:** Returns a `ResponseEntity<UserResponseDTO>` with an HTTP `200 (OK)` status if successful.
#### 8.2.1. Sample Code:
````java
@CrossOrigin(origins = "*", allowedHeaders = "*")
@GetMapping(value = "/{id}")
public ResponseEntity<UserResponseDTO> findById(@PathVariable String id) {
    UserResponseDTO result = userServices.findById(id);
    return ResponseEntity.ok().body(result);
}
````
---
### 9. Success Case: Requesting and Responding User Data via Spring Boot RESTful API (`findById`):
#### 9.1. Setting Up the RESTful API for HTTP Methods (`Idempotent`):
- **Endpoint:** `GET /users/{id}`;
- **Purpose:** Retrieves a specific User item by its ID.
#### 9.2. Example GET Request:
- **Scenario:** Successfully retrieves the requested User by ID:
````markdown
http://localhost:8080/users/67a2409ef1378e0d5af372cc
````        
#### 9.3. Example Response:
````json
{
  "id": "67a2409ef1378e0d5af372cc",
  "name": "Balthazar de Bigode",
  "email": "balthazar@email.com"
}
````
---
### 10. Exception Handling for `findById` Method:
#### 10.1. **NEW CLASS:** `services.exceptions.ResourceNotFoundException` (Custom Exception)`:
- This section introduces the implementation of custom exception handling for the `findById` method in the UserService class, introducing custom exceptions and centralized error handling mechanisms.
- Create a custom exception named `ResourceNotFoundException`, extending `RuntimeException`;
- Constructor takes an `Object id` as a parameter to provide a specific resource ID in the error message;
- Provide a detailed message when an exception occurs: `"Resource Not Found! ID: [id]"`.
#### 10.2. **NEW CLASS:** `controller.exceptions.StandardError` (Entity for Standardized Error Messages):
- Create the `StandardError` class to represent error messages for RESTful APIs:
- Include the following attributes:
  - `Instant timestamp`: formatted with `@JsonFormat` to comply with standard time formats;
  - `Integer status`: the HTTP response status code;
  - `String error`: short description of the error;
  - `String message`: detailed error message;
  - `String path`: the URI that generated the error;
- Provide constructors, getters, and setters to support object manipulation;
- Implement `Serializable` for object serialization when needed.
#### 10.3. **NEW CLASS:** `controller.exceptions.ResourceExceptionHandler`:
- The `ResourceExceptionHandler` class is responsible for intercepting exceptions thrown during the execution of RESTful requests in the application and converting them into standardized HTTP error responses.
#### 10.4. **Key Features:**
- **Global Exception Handling:** The class is annotated with `@ControllerAdvice`, which enables centralized exception handling across all `@Controller` components;
- **Error Response Standardization:** Provides a mechanism to customize the error response by creating and returning `StandardError` objects with detailed error information.
#### 10.5. **Detailed Breakdown of the ` handleResourceNotFoundException` Method:**
````java
@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<StandardError>  handleResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {
    String error = "Resource not found with the specified identifier or criteria.";
    HttpStatus status = HttpStatus.NOT_FOUND;
    StandardError err = new StandardError(
            Instant.now(),                   // Current timestamp of the error
            status.value(),                  // HTTP Status code (404)
            error,                           // Custom error message
            e.getMessage(),                  // Exception's detailed message
            request.getRequestURI()          // URI path where the error occurred
    );
    return ResponseEntity.status(status).body(err);
}
````
- **Annotations and Parameters**:
  - `@ExceptionHandler`(ResourceNotFoundException.class): Maps the method to handle exceptions of type `ResourceNotFoundException`;
  - `ResourceNotFoundException` e: The exception object containing the error details;
  - `HttpServletRequest` request: Captures information about the HTTP request, such as the request URI.
#### 10.6. Response Construction:
- **Timestamp**: `Instant.now()` ensures the current time is recorded when the exception is handled;
- **Status Code**: `HttpStatus.NOT_FOUND.value()` returns the HTTP status code 404;
- **Error Message**: The variable `error` provides a concise description for the error;
- **Detailed Message**: `e.getMessage()` displays the custom error message from ResourceNotFoundException;
- **Request Path**: `request.getRequestURI()` specifies the URI that caused the exception.
---
### 11. Error Case: Handling Resource Not Found via Spring Boot RESTful API (`findById`):
#### 11.1. Setting Up the RESTful API for HTTP Methods (`Idempotent`):
- **Endpoint:** `GET /users/{id}`;
- **Purpose:** Retrieves a specific User item by its ID.
#### 11.2. Example GET Request:
- **Scenario:** The requested ID `67a2d4c676cb0c201346e8f` does not exist, triggering the custom error response with a `404 Not Found` status code:
````markdown
http://localhost:8080/users/67a2d4c676cb0c201346e8f
````
#### 11.3. Example Error Response:
- **Error Handling**: Upon catching a `ResourceNotFoundException`, the method returns a structured JSON response in the following format:
````json
{
  "timestamp": "2025-02-05T04:13:27Z",
  "status": 404,
  "error": "Resource not found with the specified identifier or criteria.",
  "message": "Resource Not Found! ID: 67a2d4c676cb0c201346e8f",
  "path": "/users/67a2d4c676cb0c201346e8f"
}
````
- **Key Attributes Explained**:
    - `timestamp`: Indicates when the error occurred;
    - `status`: The HTTP status code (404 Not Found);
    - `error`: Short description of the issue;
    - `message`: Detailed information, including the resource identifier;
    - `path`: The URI path of the failed request.
---
### 12. Implement `insert` operation for Users with POST method:
#### 12.1. **NEW METHOD:** `UserServices.insert`:
- Implement a method to insert a new `User` entity:
  - **Purpose:** Maps data from a `UserRequestDTO`, creates a `User` entity, and inserts it into the MongoDB collection;
  - **Transaction:** Annotate with `@Transactional` to ensure that the operation is atomic and managed by the transaction manager;
  - **Response:** Returns a `UserResponseDTO` containing the created `User` data.
#### 12.1.1. Sample Code:
````java
@Transactional
public UserResponseDTO insert(UserRequestDTO data) {
  User user = new User(data);
  User create = userRepository.insert(user);
  return new UserResponseDTO(create);
}
````
#### 12.2. **NEW METHOD:** `UserResource.insert`:
- **Purpose:** Handles `POST` requests to create a new User resource;
- **Mapping:** Use `@PostMapping` to map the request;
- **Cross-Origin:** Annotate with `@CrossOrigin(origins = "*", allowedHeaders = "*")` to enable CORS;
- **Response:** Returns a `ResponseEntity<UserResponseDTO>` with an HTTP `201 (Created)` status if successful.
#### 12.2.1. Sample Code:
````java
@CrossOrigin(origins = "*", allowedHeaders = "*")
@PostMapping
public ResponseEntity<UserResponseDTO> insert(@RequestBody UserRequestDTO data) {
    UserResponseDTO create = userServices.insert(data);
    return ResponseEntity.status(HttpStatus.CREATED).body(create);
}
````
#### 12.3. **UPDATED CLASS:** `User`
- **Purpose:** Modify the `User` class to include a constructor that accepts `UserRequestDTO` to facilitate mapping DTO data to the `User` entity during the insertion process.
#### 12.3.1. Sample Code:
````java
public User(UserRequestDTO data) {
    this.id = data.id();
    this.name = data.name();
    this.email = data.email();
}
````
---
### 13. Success Case: Requesting and Responding User Data via Spring Boot RESTful API (`insert`):
#### 13.1. Setting Up the RESTful API for HTTP Methods (`Non-Idempotent`):
- **Endpoint:** `POST /users`;
- **Purpose:** Creates a new User.
#### 13.2. Example POST Request:
- **Scenario:** Successfully creates a new User:
````markdown
http://localhost:8080/users
Body -> raw -> JSON
````
````json
{
  "name": "Epaminondas Gumercindo",
  "email": "epaminondas@email.com"
}
````
#### 13.3. Example Response:
````json
{
    "id": "67a37227ac590770c04742d6",
    "name": "Epaminondas Gumercindo",
    "email": "epaminondas@email.com"
}
````
---
### 14. Implement `delete` operation for Users with DELETE method:
#### 14.1. **NEW METHOD:** `UserServices.delete`:
- Implement a method to delete a `User` entity:
  - **Purpose:** Deletes a `User` entity by its identifier;
  - **Transaction:** Annotate with `@Transactional` to ensure that the operation is atomic and managed by the transaction manager.
#### 14.1.1. Sample Code:
````java
@Transactional
public void delete(String id) {
  try {
    userRepository.deleteById(id);
  } catch (EmptyResultDataAccessException e) {
    throw new ResourceNotFoundException(id);
  } catch (DataIntegrityViolationException e) {
    throw new DatabaseException(e.getMessage());
  }
}
````
#### 14.2. **NEW METHOD:** `UserResource.delete`:
- **Purpose:** Implement a method to handle `DELETE` requests for deleting a `User` by `id`;
- **Mapping:** Use `@DeleteMapping(value = "/{id}")` annotation to map DELETE requests for removing a specific `User`;
- **Cross-Origin:** Annotate with `@CrossOrigin(origins = "*", allowedHeaders = "*")` to enable CORS;
- **Response:** Return a `ResponseEntity<Void>` with an HTTP `204 (No Content)` status after successful deletion.
#### 14.2.1. Sample Code:
````java
@CrossOrigin(origins = "*", allowedHeaders = "*")
@DeleteMapping(value = "/{id}")
public ResponseEntity<Void> delete (@PathVariable String id){
  userServices.delete(id);
  return ResponseEntity.noContent().build();
}
````
---
### 15. Success Case: Requesting and Responding User Data via Spring Boot RESTful API (`delete`):
#### 15.1. Setting Up the RESTful API for HTTP Methods (`Idempotent`):
- **Endpoint:** `DELETE /users/{id}`;
- **Purpose:** Deletes a specific User item by its ID.
#### 15.2. Example DELETE Request:
- **Scenario:** Successfully deletes the requested User by ID:
````markdown
http://localhost:8080/users/67a2409ef1378e0d5af372cc
````        
#### 15.3. Example Response:
````markdown
HTTP Status 204 - No Content
````
---
### 16. Exception Handling for `findById` Method:
#### 16.1. **NEW CLASS:** `services.exceptions.DatabaseException`:
- Custom exception created to handle database-related errors such as data integrity violations;
- **Constructor:**
```java
public class DatabaseException extends RuntimeException {
  public DatabaseException(String message) {
    super(message);
  }
}
````
#### 16.2. **UPDATE CLASS:** `controller.exceptions.ResourceExceptionHandler`:
Key Features:
- New Method: `handleDatabaseException`(DatabaseException e, HttpServletRequest request) handles database-related exceptions.
- Exception Handling Method:
````java
@ExceptionHandler(DatabaseException.class)
public ResponseEntity<StandardError> handleDatabaseException(DatabaseException e, HttpServletRequest request) {
    String error = "A database error occurred. Please check the provided data and try again.";
    HttpStatus status = HttpStatus.BAD_REQUEST;
    StandardError err = new StandardError(
            Instant.now(),                   // Current timestamp
            status.value(),                  // HTTP Status code (400)
            error,                           // Custom error message
            e.getMessage(),                  // Exception's detailed message
            request.getRequestURI()          // URI path where the error occurred
    );
    return ResponseEntity.status(status).body(err);
}
````
---
### 17. Error Case: Handling Resource Not Found via Spring Boot RESTful API (`delete`):
#### 17.1. Setting Up the RESTful API for HTTP Methods (`Idempotent`):
- **Endpoint**: DELETE `/users/{id}`;
- **Purpose**: Deletes a specific User item by its ID.
#### 17.2. Example DELETE Request (Resource Not Found):
- **Scenario**: The requested ID `67a2d4c676cb0c201346e8f` does not exist, triggering the custom error response with a `404 Not Found` status code:
````markdown
DELETE http://localhost:8080/users/67a2d4c676cb0c201346e8f
````
#### 17.3. Example Error Response:
````json
{
  "timestamp": "2025-02-05T14:23:17Z",
  "status": 404,
  "error": "Resource not found with the specified identifier or criteria.",
  "message": "Resource Not Found! ID: 67a2d4c676cb0c201346e8f",
  "path": "/users/67a2d4c676cb0c201346e8f"
}
````
#### 17.4. Example DELETE Request (`Data Integrity Violation`):
- **Scenario**: The requested ID `67a37227ac590770c04742d6` exists, but due to relationships with another entity, a `Database Constraint Violation` occurs, triggering the custom error response with a `400 Bad Request` status code:
````markdown
DELETE http://localhost:8080/users/67a37227ac590770c04742d6
````
#### 7.4.1. Example Error Response:
````json
{
    "timestamp": "2025-01-31T18:35:02Z",
    "status": 400,
    "error": "A database error occurred. Please check the provided data and try again.",
    "message": "Could not delete User due to data integrity violation.",
    "path": "/users/67a37227ac590770c04742d6"
}
````
#### Key Attributes Explained:
- `timestamp`: Indicates when the error occurred;
- `status`: The HTTP status code (either `404` for `Not Found` or `400` for `Bad Request` database errors );
- `error`: Short description of the issue;
- `message`: Detailed information, including the resource identifier;
- `path`: The URI path of the failed request.
***
---
### 19. Success Case: Requesting and Responding User Data via Spring Boot RESTful API (`update`):
#### 19.1. Setting Up the RESTful API for HTTP Methods (`Idempotent`):
- **Endpoint:** PUT `/users/{id}`;
- **Purpose:** Updates a specific User item by its ID.
#### 19.2. Example PUT Request:
- **Scenario:** Successfully updates the requested User by ID:
````markdown
http://localhost:8080/users/16
Body -> raw -> JSON
````
---
## Project Checklist:
- [X] Set up a Java Spring Boot project with MongoDB dependencies;
- [X] Implement the User entity and RESTful endpoints;
- [X] Configure MongoDB connection and data instantiation;
- [X] Database initialization operation;
- [X] Implement DTOs Pattern for User Representation; 
- [] Implement CRUD operation for Users, including Exception Handling for resource not found;
- [] Develop the Post entity with nested User information;
- [] Implement DTOs for Post and Author;
- [] Implement CRUD operations for Posts, including association with Users;
- [] Implement endpoints for retrieving user posts;
- [] Add Comment functionality to Posts;
- [] Implement custom queries for Post retrieval (simple and multi-criteria);
- [] Implement URL parameter decoding for query methods.