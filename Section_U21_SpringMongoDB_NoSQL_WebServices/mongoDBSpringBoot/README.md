# Spring Boot Project and MongoDB Database (Web Services + NoSQL)

***

## Instructions:

<p align="justify">
This project outlines the development of a robust <code>RESTful API</code> using the <code>Spring Boot</code> framework in conjunction with <code>MongoDB</code>. The primary objective is to create a fully functional backend system capable of managing user data and their associated posts, incorporating features such as <code>CRUD operations</code>, <code>data transfer objects (DTOs)</code>, and <code>exception handling</code>. The project will emphasise best practices in software design, including the implementation of a service layer for business logic and a repository layer for database interactions. Furthermore, it will explore the use of <code>nested objects</code> and <code>database references</code> to model relationships between Users and Posts, as well as the implementation of <code>query methods</code> and <code>custom queries</code> for data retrieval. The resulting API will provide a comprehensive set of endpoints for managing Users, Posts, and Comments, demonstrating a practical application of <code>Spring Boot</code> and <code>MongoDB</code> in a real-world scenario.
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
    - Override the `equals()` method to compare entities based on the `id` and `email` attributes;
    - Override `hashCode()` to provide a consistent hash for `User` objects, using `Objects.hashCode(id)` and
      `Objects.hashCode(email)`;
- **Serializable Interface:**
    - Implement the `Serializable` interface to support object serialization for the entity when necessary (e.g., when
      transferring objects between systems).

#### 2.2. Requirements for UserController Class:

- Create the `UserController` class to manage RESTful endpoints for the `User` resource;
- Use `@RestController` annotation to mark it as a REST controller for Spring;
- Map requests using the `@RequestMapping` annotation for the `/users` endpoint;
- Inject `UserService` (or similar) using `@Autowired` for service dependency injection;
- Implement a method `findAll`to handle `GET` requests:
    - Use `@GetMapping` annotation to map GET requests to `/users`;
    - Return a `ResponseEntity<List<User>>` with an HTTP 200 (OK) status and the list of `Users`;
    - Handle empty lists and return an HTTP 204 (No Content) status if no `Users` are found;
- Use `@CrossOrigin(origins = "*", allowedHeaders = "*")` annotation to allow cross-origin requests from any origin;
- Ensure that the class implements the `Serializable` interface to support object serialization when needed.

---

### 3. Configuration of Environment:

- The section titled "Configuration of Environment" provides essential setup instructions for configuring the
  `application.properties` file, which defines the general settings for the application.

#### 3.1. Configuration of the `application.properties` File:

- This configuration includes the necessary connection URI for MongoDB, specifying the database location as
  `mongodb://localhost:27017/mongoDBSpringBoot`, and sets the logging level for the services package to `DEBUG`,
  enabling detailed logging information to assist in debugging and development processes.

```properties
# MongoDB Connection
spring.data.mongodb.uri=mongodb://localhost:27017/mongoDBSpringBoot
logging.level.com.souza.charles.mongoDBSpringBoot.services=DEBUG
````

---

### 4. Repository Interface, Service, and Resource/Controller User Classes:

#### 4.1. Requirements for UserRepository Interface:

- **Repository Creation:**
    - Create the `UserRepository` interface to handle data access operations for the `User` entity;
- **MongoRepository Extension:**
    - Extend `MongoRepository<User, String>` to inherit common CRUD operations and MongoDB-specific functionalities;
- **Entity Association:**
    - Specify `User` as the associated entity and `String` as the type for its primary key.

#### 4.2. Requirements for UserService Class:

- Use the `@Service` annotation to define the class as a Spring service component;
- Inject `UserRepository` using the `@Autowired` annotation for dependency injection;
- Implement methods to retrieve all `User` entities:
    - `findAll`: Fetches all entries from the database;
    - Use the `@Transactional(readOnly = true)` annotation to ensure the method runs within a read-only transaction for
      optimised database performance.

#### 4.3. Requirements for UserController Class:

- Create the `UserController` class to manage RESTful endpoints for the `User` resource;
- Use the `@RestController` annotation to mark it as a REST controller for Spring;
- Map requests using the `@RequestMapping` annotation for the `/users` endpoint;
- Inject `UserService` using the `@Autowired` annotation for service dependency injection;
- Implement `findAll` method to handle HTTP requests:
    - **GET Request:**
        - Use the `@GetMapping` annotation to map GET requests to `/users`;
        - Return a `ResponseEntity<List<User>>` with an HTTP 200 (OK) status and the list of `Users`;
- Use the `@CrossOrigin(origins = "*", allowedHeaders = "*")` annotation to allow cross-origin requests from any origin;
- Ensure that the class implements the `Serializable` interface to support object serialisation when needed.

#### 4.4. Idempotent and Non-Idempotent Methods:

- **Idempotent Method**: `GET`, `PUT`, and `DELETE` are idempotent, meaning multiple identical requests should have the
  same effect as a single request;
- **Non-Idempotent Method**: `POST` is non-idempotent, meaning multiple identical requests may have additional effects.

---

### 5. Database Initialization Operation:

#### 5.1 In the `config` Subpackage, Create the `Instantiation` Configuration Class Implementing `CommandLineRunner`:

```java
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
- `userRepository.deleteAll()`: Removes all existing documents from the `User` collection to ensure a clean database
  state for seeding;
- `new User(null, "name", "email")`: Creates a new instance of the `User` entity with specified name and email values;
- `userRepository.saveAll(Arrays.asList(...))`: Saves multiple `User` objects into the database in a single operation,
  improving efficiency;
- `@Override`: Specifies that the method overrides a superclass method.

---

### 6. Success Case: Requesting and Responding User Data via Spring Boot RESTful API (`findAll`):

#### 6.1. Setting Up the RESTful API for HTTP Methods (`Idempotent`):

- **Endpoint:** `GET /users`;
- **Purpose:** Retrieves a list of all `Users`.

#### 6.2. Example GET Request:

- **Scenario:** Successfully retrieves a list of all `Users`:

````markdown
GET http://localhost:8080/users
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
    - Define the attributes `String id`, `String name`, and `String email` directly in the record's header to make them
      immutable and automatically provide accessor methods;
- **Entity-based Constructor:**
    - Implement a custom constructor that accepts a `User` entity object as an argument;
    - Extract and map values from the `User` entity to initialize the `UserResponseDTO` attributes;
- **Purpose:**
    - Use this `record` for transferring user-related data from the backend service layer to the controller response,
      following RESTful API conventions.

#### 7.2. Requirements for UserRequestDTO Record Class:

- **Record Declaration:**
    - Create the `UserRequestDTO` as a `record` class to represent the request payload for creating or updating `User`
      entries;
- **Attribute Definition:**
    - Define the attributes `String id`, `String name`, and `String email` directly in the record's header to enable
      immutability and automatic generation of accessor methods;
- **Purpose:**
    - Use this `record` for receiving and validating `User` input from `author` requests to create/insert or update
      `User`
      entities within the application.

#### 7.3. Requirements for `User` Entity Constructor with `UserRequestDTO`:

- **Constructor Implementation:**
    - Add a constructor to the `User` entity that accepts a `UserRequestDTO` object as an argument;
- **Data Mapping:**
    - Within the constructor, map the values from the `UserRequestDTO` object's attributes (`id`, `name`, `email`) to
      the corresponding attributes of the `User` entity;
- **Purpose:**
    - This constructor facilitates the creation or update of `User` entities from incoming `UserRequestDTO` objects,
      ensuring consistency in data mapping and cleaner code by encapsulating the data conversion logic.

#### 7.4. Service Layer Refactoring Requirements:

- **Service Layer Responsibility:**
    - Ensure that the `UserServices` class contains the business logic for retrieving `Users` from the database;
- **Return Type Update:**
    - Update the `findAll()` method to return a list of `UserResponseDTO` objects instead of `User` objects;
- **Mapping Logic:**
    - Use Java streams to transform the list of `User` entities into a list of `UserResponseDTO` objects;
- **Purpose:**
    - Improve encapsulation and ensure that only essential `User` information is exposed to the REST controller.

##### 7.4.1. Sample Code:

````java

@Transactional(readOnly = true)
public List<UserResponseDTO> findAll() {
    List<User> list = userRepository.findAll();
    return list.stream()
            .map(UserResponseDTO::new)
            .toList();
}
````

#### 7.5. Controller Layer Refactoring Requirements:

- **Controller Layer Responsibility:**
    - Ensure that `UserController` communicates directly with the `UserServices` service to retrieve `User` information;
- **Return Type Update:**
    - Update the `findAll()` method to return a list of `UserResponseDTO` objects wrapped in a `ResponseEntity`;
- **Status Code Handling:**
    - Return a `ResponseEntity<List<UserResponseDTO>>` with an HTTP `200 (OK)` status and the list of `Users`;
    - Handle empty lists and return an HTTP `204 (No Content)` status if no `Users` are found;
- **Purpose:**
    - Ensure clear and accurate communication between client and server using RESTful API conventions.

##### 7.5.1. Sample Code:

````java

@GetMapping
public ResponseEntity<List<UserResponseDTO>> findAll() {
    List<UserResponseDTO> list = userService.findAll();
    return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
}
````

---

### 8. Implement `findById` Operation for Users with GET Method:

#### 8.1. **NEW METHOD:** `UserService.findById`:

- Implement a method to retrieve a `User` entity by its `id`:
    - **Purpose:** Fetches a single `User` entity by its identifier and maps it to a `UserResponseDTO`;
        - **Transaction:** Annotate with `@Transactional(readOnly = true)` to ensure that the method runs within a
          read-only
          transaction;
        - **Exception Handling:** Throws a custom `ResourceNotFoundException` if the `User` is not found.

##### 8.1.1. Sample Code:

````java

@Transactional(readOnly = true)
public UserResponseDTO findById(String id) {
    User entity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    return new UserResponseDTO(entity);
}
````

#### 8.2. **NEW METHOD**: `UserController.findById`:

- Implement a method to handle `GET` requests by `id`:
    - **Purpose:** Handle `GET` requests to retrieve a `User` by its identifier;
        - **Mapping:** Use `@GetMapping(value = "/{id}")` to map the request;
        - **Response:** Returns a `ResponseEntity<UserResponseDTO>` with an HTTP `200 (OK)` status if successful;
        - **Exception Handling:** Automatically handles `ResourceNotFoundException` and returns an appropriate HTTP
          `404 (Not Found)` response if the `User` is not found.

#### 8.2.1. Sample Code:

````java

@GetMapping(value = "/{id}")
public ResponseEntity<UserResponseDTO> findById(@PathVariable String id) {
    UserResponseDTO dto = userService.findById(id);
    return ResponseEntity.ok().body(dto);
}
````

---

### 9. Success Case: Requesting and Responding User Data via Spring Boot RESTful API (`findById`):

#### 9.1. Setting Up the RESTful API for HTTP Methods (`Idempotent`):

- **Endpoint:** `GET /users/{id}`;
- **Purpose:** Retrieves a specific `User` item by its ID.

#### 9.2. Example GET Request:

- **Scenario:** Successfully retrieves the requested `User` by ID:

````markdown
GET http://localhost:8080/users/67a2409ef1378e0d5af372cc
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

- This section introduces the implementation of custom exception handling for the `findById` method in the `UserService`
  class, introducing custom exceptions and centralized error handling mechanisms.

#### 10.1. **NEW CLASS:** `services.exceptions.ResourceNotFoundException` (Custom Exception)`:

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

#### 10.3. **NEW CLASS:** `controller.exceptions.ResourceExceptionHandler` (Custom Exception):

- The `ResourceExceptionHandler` class is responsible for intercepting exceptions thrown during the execution of RESTful
  requests in the application and converting them into standardized HTTP error responses.

#### 10.3.1. **Key Features:**

- **Global Exception Handling:** The class is annotated with `@ControllerAdvice`, which enables centralized exception
  handling across all `@Controller` components;
- **Error Response Standardization:** Provides a mechanism to customize the error response by creating and returning
  `StandardError` objects with detailed error information.

#### 10.3.2. **NEW METHOD:**` handleResourceNotFoundException`:

- This method is responsible for handling exceptions of type `ResourceNotFoundException` and converting them into
  standardized HTTP error responses:

````java

@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<StandardError> handleResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {
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
    - `@ExceptionHandler`(ResourceNotFoundException.class): Maps the method to handle exceptions of type
      `ResourceNotFoundException`;
    - It takes two parameters:
        - `ResourceNotFoundException` e: The exception object containing the error details;
        - `HttpServletRequest` request: Captures information about the HTTP request, such as the request URI.
    - The method constructs a `StandardError` object, which includes:
        - **Timestamp**: `Instant.now()` ensures the current time is recorded when the exception is handled;
        - **Status Code**: `HttpStatus.NOT_FOUND.value()` returns the HTTP status code 404;
        - **Error Message**: The variable `error` provides a concise description for the error;
        - **Detailed Message**: `e.getMessage()` displays the custom error message from ResourceNotFoundException;
        - **Request Path**: `request.getRequestURI()` specifies the URI that caused the exception.
    - The method returns a `ResponseEntity` containing the `StandardError` object and the appropriate HTTP status code.

---

### 11. Error Case: User Handling Resource Not Found via Spring Boot RESTful API (`findById`):

#### 11.1. Setting Up the RESTful API for HTTP Methods (`Idempotent`):

- **Endpoint:** `GET /users/{id}`;
- **Purpose:** Retrieves a specific `User` item by its ID.

#### 11.2. Example GET Request (`ID Does Not Exist`):

- **Scenario:** The requested ID does not exist, triggering the custom error response with a
  `404 Not Found` status code:

````markdown
GET http://localhost:8080/users/67a2d4c676cb0c201346e8f
````

#### 11.3. Example Error Response:

- **Error Handling**: Upon catching a `ResourceNotFoundException`, the method returns a structured JSON response in the
  following format:

````json
{
  "timestamp": "2025-02-05T04:13:27Z",
  "status": 404,
  "error": "Resource not found with the specified identifier or criteria.",
  "message": "Resource Not Found! ID: 67a2d4c676cb0c201346e8f",
  "path": "/users/67a2d4c676cb0c201346e8f"
}
````

---

### 12. Implement `insert` Operation for Users with POST Method:

#### 12.1. **NEW METHOD:** `UserService.insert`:

- Implement a method to insert a new `User` entity:
    - **Purpose:** Maps data from a `UserRequestDTO`, creates a `User` entity, and inserts it into the `MongoDB`
      collection;
    - **Transaction:** Annotate with `@Transactional` to ensure that the operation is atomic and managed by the
      transaction manager;
    - **Validation:** Checks for null or empty values in `name` and `email` fields, throwing an
      `InvalidDataException`
      if invalid;
    - **Duplicate Email Check:** Uses `userRepository.findByEmail` to verify if the email already exists, throwing a
      `DuplicateEmailException` if a duplicate is found;
    - **Response:** Returns a `UserResponseDTO` containing the created `User` data.

#### 12.1.1. Sample Code:

````java
@Transactional
public UserResponseDTO insert(UserRequestDTO data) {
    if (data.name() == null || data.name().isEmpty() ||
            data.email() == null || data.email().isEmpty()) {
        throw new InvalidDataException();
    }
    if (userRepository.findByEmail(data.email()).isPresent()) {
        throw new DuplicateEmailException(data.email());
    }
    User entity = new User(data);
    User create = userRepository.insert(entity);
    return new UserResponseDTO(create);
}
````

#### 12.2. **NEW METHOD:** `UserController.insert`:

- **Purpose:** Handles `POST` requests to create a new `User` resource;
- **Mapping:** Use `@PostMapping` to map the request;
- **Response:** Returns a `ResponseEntity<UserResponseDTO>` with an HTTP `201 (Created)` status if successful;
- **Exception Handling:** Automatically handles exceptions such as `DuplicateEmailException` and `InvalidDataException`,
  returning appropriate HTTP error responses.

#### 12.2.1. Sample Code:

````java
@PostMapping
public ResponseEntity<UserResponseDTO> insert(@RequestBody UserRequestDTO data) {
    UserResponseDTO dto = userService.insert(data);
    return ResponseEntity.status(HttpStatus.CREATED).body(dto);
}
````

#### 12.3. **UPDATED CLASS:** `User`

- **Purpose:** Modify the `User` class to include a constructor that accepts `UserRequestDTO` to facilitate mapping DTO
  data to the `User` entity during the insertion process.

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
- **Purpose:** Creates a new `User`.

#### 13.2. Example POST Request:

- **Scenario:** Successfully creates a new `User`.

- **Request Data:**

````markdown
POST http://localhost:8080/users
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

### 14. Exception Handling for `insert` Method:

- This section introduces the implementation of custom exception handling for the `insert` method in the `UserService`
  class, focusing on scenarios where a duplicate email is detected during `User` registration.

#### 14.1. **NEW CLASS:** `services.exceptions.InvalidDataException` (Custom Exception):

- Create a custom exception named `InvalidDataException`, extending `RuntimeException`;
- Constructor provides a default error message: `"Mandatory fields must not be null or empty."`;
- This exception is thrown when mandatory fields (e.g., `name` or `email`) are null or empty during `User` registration.

#### 14.2. **NEW METHOD:** `handleBadRequestException` on class `controller.exceptions.ResourceExceptionHandler`:

- This method is responsible for handling exceptions of type `InvalidDataException` and converting them into
  standardized HTTP error responses:

````java
@ExceptionHandler(InvalidDataException.class)
public ResponseEntity<StandardError> handleBadRequestException(InvalidDataException e, HttpServletRequest request) {
    String error = "Invalid data provided. Please check the input and try again.";
    HttpStatus status = HttpStatus.BAD_REQUEST;
    StandardError err = new StandardError(
            Instant.now(),                   // Current timestamp of the error
            status.value(),                  // HTTP Status code (400)
            error,                           // Custom error message
            e.getMessage(),                  // Exception's detailed message
            request.getRequestURI()          // URI path where the error occurred
    );
    return ResponseEntity.status(status).body(err);
}
````

- **Annotations and Parameters:**
    - `@ExceptionHandler(InvalidDataException.class)`: Maps the method to handle exceptions of type
      `InvalidDataException`;
    - It takes two parameters:
        - `InvalidDataException e`: The exception object containing the error details;
        - `HttpServletRequest request`: Captures information about the HTTP request, such as the request URI.
    - The method constructs a `StandardError` object, which includes:
        - **Timestamp**: `Instant.now()` ensures the current time is recorded when the exception is handled;
        - **Status Code**: `HttpStatus.BAD_REQUEST.value()` returns the HTTP status code 400;
        - **Error Message**: The variable `error` provides a concise description for the error;
        - **Detailed Message**: `e.getMessage()` displays the custom error message from `InvalidDataException`;
        - **Request Path**: `request.getRequestURI()` specifies the URI that caused the exception.
    - The method returns a `ResponseEntity` containing the `StandardError` object and the appropriate HTTP status code.

#### 14.3. **NEW CLASS:** `services.exceptions.DuplicateEmailException` (Custom Exception):

- Create a custom exception named `DuplicateEmailException`, extending `RuntimeException`;
- Constructor takes an `Object email` as a parameter to provide the specific email address in the error message;
- Provide a detailed message when an exception occurs:
  `"The email address '[email]' is already associated with an existing account."`;
- This exception is thrown when a duplicate email address is detected during `User` registration, ensuring that each
  email is unique in the system.

#### 14.4. **NEW METHOD:** `handleDuplicateEmailException` on class `controller.exceptions.ResourceExceptionHandler`:

- This method is responsible for handling exceptions of type `DuplicateEmailException` and converting them into
  standardized HTTP error responses:

````java
@ExceptionHandler(DuplicateEmailException.class)
public ResponseEntity<StandardError> handleDuplicateEmailException(DuplicateEmailException e, HttpServletRequest request) {
    String error = "Email address already in use.";
    HttpStatus status = HttpStatus.BAD_REQUEST;
    StandardError err = new StandardError(
            Instant.now(),                   // Current timestamp of the error
            status.value(),                  // HTTP Status code (400)
            error,                           // Custom error message
            e.getMessage(),                  // Exception's detailed message
            request.getRequestURI()          // URI path where the error occurred
    );
    return ResponseEntity.status(status).body(err);
}
````

- **Annotations and Parameters:**
    - `@ExceptionHandler(DuplicateEmailException.class)`: Maps the method to handle exceptions of type
      `DuplicateEmailException`;
    - It takes two parameters:
        - `DuplicateEmailException e`: The exception object containing the error details;
        - `HttpServletRequest request`: Captures information about the HTTP request, such as the request URI.
    - The method constructs a `StandardError` object, which includes:
        - **Timestamp**: `Instant.now()` ensures the current time is recorded when the exception is handled;
        - **Status Code**: `HttpStatus.BAD_REQUEST.value()` returns the HTTP status code 400;
        - **Error Message**: The variable `error` provides a concise description for the error;
        - **Detailed Message**: `e.getMessage()` displays the custom error message from `DuplicateEmailException`;
        - **Request Path**: `request.getRequestURI()` specifies the URI that caused the exception.
    - The method returns a `ResponseEntity` containing the `StandardError` object and the appropriate HTTP status code.

---

### 15. Error Case: Handling Resource Not Found via Spring Boot RESTful API (`insert`):

#### 15.1. Setting Up the RESTful API for HTTP Methods (`Non-Idempotent`):

- **Endpoint**: POST `/users`;
- **Purpose**: Creates a new `User`.

#### 15.2. Example POST Request (`Null or Empty Data`):

- **Scenario**: `User` registration fails with an exception if required fields like `name` or `email` are missing (
  `null` or `empty`).
-
- **Request Data:**

````markdown
POST http://localhost:8080/users
Body -> raw -> JSON
````

````json
{
  "name": "",
  "email": null
}
````

#### 15.3. Example Error Response:

- **Error Handling**: Upon catching a `InvalidDataException`, the method returns a structured JSON response in the
  following format:

````json
{
  "timestamp": "2025-02-08T18:15:41Z",
  "status": 400,
  "error": "Invalid data provided. Please check the input and try again.",
  "message": "Mandatory fields must not be null or empty.",
  "path": "/users"
}
````

#### 15.4. Example POST Request (`Duplicate Email Address`):

- **Scenario**: `User` registration fails with an exception if a `duplicate email` address is provided, enforcing email
  uniqueness.

- **Request Data:**

````markdown
POST http://localhost:8080/users
Body -> raw -> JSON
````

````json
{
  "name": "Ludovico Segundo",
  "email": "ludovico@email.com"
}

````

#### 15.5. Example Error Response:

- **Error Handling**: Upon catching a `DuplicateEmailException`, the method returns a structured JSON response in the
  following format:

````json
{
  "timestamp": "2025-02-08T18:36:13Z",
  "status": 400,
  "error": "Email address already in use.",
  "message": "The email address 'ludovico@email.com' is already associated with an existing account.",
  "path": "/users"
}
````

---

### 16. Implement `delete` operation for Users with DELETE method:

#### 16.1. **NEW METHOD:** `UserServices.delete`:

- Implement a method to delete a `User` entity:
    - **Purpose:** Deletes a `User` entity by its identifier;
    - **Transaction:** Annotate with `@Transactional` to ensure that the operation is atomic and managed by the
      transaction manager;
    - **Validation:** Checks if the `User` exists using `userRepository.findById`, throwing a
      `ResourceNotFoundException`
      if the `User` is not found;
    - **Exception Handling:** Catches `DataIntegrityViolationException` and throws a `DatabaseException` for database
      integrity violations.

#### 16.1.1. Sample Code:

```java
@Transactional
public void delete(String id) {
    try {
        userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        userRepository.deleteById(id);
    } catch (DataIntegrityViolationException e) {
        throw new DatabaseException(e.getMessage());
    }
}
````

#### 16.2. **NEW METHOD:** `UserController.delete`:

- **Purpose:** Implement a method to handle `DELETE` requests for deleting a `User` by `id`;
- **Mapping:** Use `@DeleteMapping(value = "/{id}")` annotation to map DELETE requests for removing a specific `User`;
- **Response:** Return a `ResponseEntity<Void>` with an HTTP `204 (No Content)` status after successful deletion.

#### 16.2.1. Sample Code:

````java
@DeleteMapping(value = "/{id}")
public ResponseEntity<Void> delete(@PathVariable String id) {
    userService.delete(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
}
````

---

### 17. Success Case: Requesting and Responding User Data via Spring Boot RESTful API (`delete`):

#### 17.1. Setting Up the RESTful API for HTTP Methods (`Idempotent`):

- **Endpoint:** `DELETE /users/{id}`;
- **Purpose:** Deletes a specific `User` item by its ID.

#### 17.2. Example DELETE Request:

- **Scenario:** Successfully deletes the requested `User` by ID:

````markdown
DELETE http://localhost:8080/users/67a2409ef1378e0d5af372cc
````        

#### 17.3. Example Response:

````markdown
HTTP Status 204 - No Content
````

---

### 18. Exception Handling for `delete` Method:

- This section introduces the implementation of custom exception handling for the `delete` method in the `UserService`
  class, focusing on scenarios where database-related errors occur during `User` deletion.

#### 18.1. **NEW CLASS:** `services.exceptions.DatabaseException` (Custom Exception):

- Create a custom exception named `DatabaseException`, extending `RuntimeException`;
- Constructor takes a `String message` as a parameter to provide detailed information about the database error;
- Provide a detailed message when an exception occurs:
  `"Database error detected: [message]. Please verify database constraints and configurations."`;
- This exception is thrown when a database integrity violation (e.g., foreign key constraint) is detected during the
  `delete` operation.

#### 18.2. **NEW METHOD:** `handleDatabaseException` on class `controller.exceptions.ResourceExceptionHandler`:

- This method is responsible for handling exceptions of type `DatabaseException` and converting them into standardized
  HTTP error responses:

````java
@ExceptionHandler(DatabaseException.class)
public ResponseEntity<StandardError> handleDatabaseException(DatabaseException e, HttpServletRequest request) {
    String error = "A database error occurred. Please check the provided data and try again.";
    HttpStatus status = HttpStatus.BAD_REQUEST;
    StandardError err = new StandardError(
            Instant.now(),                   // Current timestamp of the error
            status.value(),                  // HTTP Status code (400)
            error,                           // Custom error message
            e.getMessage(),                  // Exception's detailed message
            request.getRequestURI()          // URI path where the error occurred
    );
    return ResponseEntity.status(status).body(err);
}
````

- **Annotations and Parameters:**
    - `@ExceptionHandler(DatabaseException.class)`: Maps the method to handle exceptions of type `DatabaseException`;
    - It takes two parameters:
        - `DatabaseException e`: The exception object containing the error details;
        - `HttpServletRequest request`: Captures information about the HTTP request, such as the request URI;
    - The method constructs a `StandardError` object, which includes:
        - **Timestamp**: `Instant.now()` ensures the current time is recorded when the exception is handled;
        - **Status Code**: `HttpStatus.BAD_REQUEST.value()` returns the HTTP status code 400;
        - **Error Message**: The variable `error` provides a concise description for the error;
        - **Detailed Message**: `e.getMessage()` displays the custom error message from `DatabaseException`;
        - **Request Path**: `request.getRequestURI()` specifies the URI that caused the exception.
    - The method returns a `ResponseEntity` containing the `StandardError` object and the appropriate HTTP status code.

---

### 19. Error Case: Handling Resource Not Found via Spring Boot RESTful API (`delete`):

#### 19.1. Setting Up the RESTful API for HTTP Methods (`Idempotent`):

- **Endpoint**: DELETE `/users/{id}`;
- **Purpose**: Deletes a specific `User` item by its ID.

#### 19.2. Example DELETE Request (``ID Does Not Exist``):

- **Scenario**: The requested ID does not exist, triggering the custom error response with a
  `404 Not Found` status code:

````markdown
DELETE http://localhost:8080/users/67a2d4c676cb0c201346e8f
````

#### 19.3. Example Error Response:

- **Error Handling** - Upon catching a `ResourceNotFoundException`, the method returns a structured JSON response in the
  following format:

````json
{
  "timestamp": "2025-02-05T14:23:17Z",
  "status": 404,
  "error": "Resource not found with the specified identifier or criteria.",
  "message": "Resource Not Found! ID: 67a2d4c676cb0c201346e8f",
  "path": "/users/67a2d4c676cb0c201346e8f"
}
````

#### 19.4. Example DELETE Request (`Data Integrity Violation`):

- **Scenario**: The requested ID exists, but due to relationships with another entity, a `Database Integrity Violation`
  occurs (e.g., foreign key constraint), triggering the custom error response with a `400 Bad Request` status code.

````markdown
DELETE http://localhost:8080/users/67a37227ac590770c04742d6
````

#### 19.5. Example Error Response:

- **Error Handling** - Upon catching a `DatabaseException`, the method returns a structured JSON response in the
  following format:

````json
{
  "timestamp": "2025-02-05T14:33:10Z",
  "status": 400,
  "error": "A database error occurred. Please check the provided data and try again.",
  "message": "Database error detected: Could not delete User due to data integrity violation. Please verify database constraints and configurations.",
  "path": "/users/67a37227ac590770c04742d6"
}
````

---

### 20. Implement `update` Operation for Users with PUT Method:

#### 20.1. **NEW METHOD:** `UserService.update`:

- Implement a method to update an existing `User` entity:
    - **Purpose:** Updates a `User` entity by its identifier, ensuring data consistency and uniqueness;
    - **Transaction:** Annotate with `@Transactional` to ensure that the operation is atomic and managed by the
      transaction manager;
    - **Validation:** Checks for null or empty values in `name` and `email` fields, throwing an `InvalidDataException`
      if invalid;
    - **Duplicate Email Check:** Uses `userRepository.findByEmail` to verify if the email already exists for another
      `User`, throwing a `DuplicateEmailException` if a duplicate is found;
    - **Response:** Returns a `UserResponseDTO` containing the updated `User` data.

#### 20.1.1. Sample Code:

```java
@Transactional
public UserResponseDTO update(String id, UserRequestDTO data) {
    User entity = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(id));
    if (data.email() != null) {
        userRepository.findByEmail(data.email())
                .filter(existingUser -> !existingUser.getId().equals(id))
                .ifPresent(user -> {
                    throw new DuplicateEmailException(data.email());
                });
    }
    updateData(entity, data);
    User updatedUser = userRepository.save(entity);
    return new UserResponseDTO(updatedUser);
}

private void updateData(User entity, UserRequestDTO data) {
    if (data.name() == null || data.name().isEmpty() ||
            data.email() == null || data.email().isEmpty()) {
        throw new InvalidDataException();
    }
    entity.setName(data.name());
    entity.setEmail(data.email());
}
````

#### 20.2. **NEW METHOD:** `UserController.update`:

- **Purpose:** Handles `PUT` requests to update an existing `User` resource;
- **Mapping:** Use `@PutMapping` to map the request to the specified URI (`/users/{id}`);
- **Parameters:**
    - `@PathVariable String id`: Captures the `id` of the `User` to be updated from the URI;
    - `@RequestBody UserRequestDTO data`: Captures the updated `User` data from the request body;
- **Response:** Returns a `ResponseEntity<UserResponseDTO>` with an HTTP `200 (OK)` status if successful;
- **Exception Handling:** Automatically handles exceptions such as `DuplicateEmailException`, `InvalidDataException`,
  and `ResourceNotFoundException`, returning appropriate HTTP error responses.

#### 20.2.1. Sample Code:

```java
@PutMapping(value = "/{id}")
public ResponseEntity<UserResponseDTO> update(@PathVariable String id, @RequestBody UserRequestDTO data) {
    UserResponseDTO dto = userService.update(id, data);
    return ResponseEntity.ok().body(dto);
}
````

---

### 21. Success Case: Requesting and Responding User Data via Spring Boot RESTful API (`update`):

#### 21.1. Setting Up the RESTful API for HTTP Methods (`Idempotent`):

- **Endpoint:** PUT `/users/{id}`;
- **Purpose:** Updates a specific `User` item by its ID.

#### 21.2. Example PUT Request:

- **Scenario:** Successfully updates the requested `User` by ID.

- **Data for Update:**

````json
{
  "id": "67a7c0854a1d6a1c482ad502",
  "name": "Ophelia Birrenta",
  "email": "ophelia@email.com"
}
````

- **Request Data:**

````markdown
http://localhost:8080/users/67a7c0854a1d6a1c482ad502
Body -> raw -> JSON
````

```json
{
  "name": "Ophelia Cassandra Birrenta",
  "email": "ophelia@email.com"
}
```

#### 21.3. Example Response:

```json
{
  "id": "67a7c0854a1d6a1c482ad502",
  "name": "Ophelia Cassandra Birrenta",
  "email": "ophelia@email.com"
}
```

---

### 22. Exception Handling for `update` Method:

- This section introduces the implementation of custom exception handling for the `update` method in the `UserService`
  class, focusing on scenarios where invalid data, duplicate emails, or missing resources are detected during `User`
  updates.

#### 22.1. **Exception Scenarios:**

1. **ResourceNotFoundException:**
    - **Triggered When:** The provided `id` does not match any existing `User` in the database;
    - **Action:** Throws a `ResourceNotFoundException` with a detailed message: `"Resource Not Found! ID: [id]"`.

2. **DuplicateEmailException:**
    - **Triggered When:** The provided `email` already exists in the database for another `User`;
    - **Action:** Throws a `DuplicateEmailException` with a detailed message:
      `"The email address '[email]' is already registered in the system."`.

3. **InvalidDataException:**
    - **Triggered When:** The provided `name` or `email` fields are null or empty;
    - **Action:** Throws an `InvalidDataException` with a detailed message:
      `"Mandatory fields must not be null or empty."`.

#### 22.2. **Exception Handling Flow:**

- The `update` method first checks if the `User` exists using `userRepository.findById`. If not found, it throws a
  `ResourceNotFoundException`;
- If the `email` field is provided, it checks for duplicates using `userRepository.findByEmail`. If a duplicate is
  found, it throws a `DuplicateEmailException`;
- The `updateData` method validates the `name` and `email` fields. If they are null or empty, it throws an
  `InvalidDataException`;
- If all validations pass, the `User` data is updated and saved to the database.

---

### 23. Error Case: Handling Resource Not Found via Spring Boot RESTful API (`update`):

#### 23.1. Setting Up the RESTful API for HTTP Methods (`Idempotent`):

- **Endpoint**: PUT `/users/{id}`;
- **Purpose**: Updates a specific `User` item by its ID.

#### 23.2. Example PUT Request (`ID Does Not Exist`):

- **Scenario**: The requested ID does not exist, triggering the custom error response with a `404 Not Found` status
  code.

- **Data for Update:**

````json
{
  "id": "67a7c0854a1d6a1c482ad502",
  "name": "Ophelia Cassandra Birrenta",
  "email": "ophelia@email.com"
}
````

````markdown
PUT http://localhost:8080/users/AAAAAAAAAA
Body -> raw -> JSON
````

#### 23.3. Example Error Response:

````json
{
  "timestamp": "2025-02-08T21:12:20Z",
  "status": 404,
  "error": "Resource not found with the specified identifier or criteria.",
  "message": "Resource Not Found! ID: AAAAAAAAAA",
  "path": "/users/AAAAAAAAAA"
}
````

#### 23.4. Example PUT Request (`Duplicate Email Address`):

- **Scenario**: `User` updates fails with an exception if a `duplicate email` address is provided, enforcing email
  uniqueness.

- **Data for Update:**

````json
{
  "id": "67a7c0854a1d6a1c482ad502",
  "name": "Ophelia Cassandra Birrenta",
  "email": "ophelia@email.com"
}
````

- **Request Data:**

````markdown
PUT http://localhost:8080/users/67a7c0854a1d6a1c482ad502
Body -> raw -> JSON
````

````json
{
  "name": "Ophelia Cassandra Birrenta",
  "email": "ludovico@email.com"
}

````

#### 23.5. Example Error Response:

- **Error Handling** - Upon catching a `DuplicateEmailException`, the method returns a structured JSON response in the
  following format:

````json
{
  "timestamp": "2025-02-08T21:22:35Z",
  "status": 400,
  "error": "Email address already in use.",
  "message": "The email address 'ludovico@email.com' is already associated with an existing account.",
  "path": "/users/67a7c0854a1d6a1c482ad502"
}
````

#### 23.6. Example PUT Request (`Null or Empty Data`):

- **Scenario**: `User` updates fails with an exception if required fields like `name` or `email` are missing (
  `null` or `empty`).
- **Data for Update:**

````json
{
  "id": "67a7c0854a1d6a1c482ad502",
  "name": "Ophelia Cassandra Birrenta",
  "email": "ophelia@email.com"
}
````

- **Request Data:**

````markdown
PUT http://localhost:8080/users/67a7c0854a1d6a1c482ad502
Body -> raw -> JSON
````

````json
{
  "name": null,
  "email": ""
}
````

#### 23.7. Example Error Response:

- **Error Handling** - Upon catching a `InvalidDataException`, the method returns a structured JSON response in the
  following format:

````json
{
  "timestamp": "2025-02-08T21:32:11Z",
  "status": 400,
  "error": "Invalid data provided. Please check the input and try again.",
  "message": "Mandatory fields must not be null or empty.",
  "path": "/users/67a7c0854a1d6a1c482ad502"
}
````

---

### 24. Exception Handling for `findAll` Method:

- This section covers the implementation of exception handling for the `findAll` operation in the `UserService` class,
  introducing custom exception and centralized error handling mechanisms.

#### 24.1. **NEW CLASS:** `services.exceptions.EmptyTableException` (Custom Exception):

- Create a custom exception named `EmptyTableException`, extending `RuntimeException`;
- Constructor provides a default error message: `"The requested table is empty or does not exist."`;
- This exception is thrown when the `findAll` method is called on an empty table or a table that does not exist,
  ensuring proper error handling for such scenarios.

#### 24.2. **NEW METHOD:** `handleEmptyTableException` on class `controller.exceptions.ResourceExceptionHandler`:

- This method is responsible for handling exceptions of type `EmptyTableException` and converting them into standardized
  HTTP error responses:

```java
@ExceptionHandler(EmptyTableException.class)
public ResponseEntity<StandardError> handleEmptyTableException(EmptyTableException e, HttpServletRequest request) {
    String error = "No data found in the requested table. Please verify the table name or check if it contains records.";
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

- **Annotations and Parameters:**
    - `@ExceptionHandler(EmptyTableException.class)`: Maps the method to handle exceptions of type
      `EmptyTableException`;
    - It takes two parameters:
        - `EmptyTableException e`: The exception object containing the error details;
        - `HttpServletRequest request`: Captures information about the HTTP request, such as the request URI;
    - The method constructs a `StandardError` object, which includes:
        - **Timestamp**: `Instant.now()` ensures the current time is recorded when the exception is handled;
        - **Status Code**: `HttpStatus.NOT_FOUND.value()` returns the HTTP status code 404;
        - **Error Message**: The variable `error` provides a concise description for the error;
        - **Detailed Message**: `e.getMessage()` displays the custom error message from `EmptyTableException`;
        - **Request Path**: `request.getRequestURI()` specifies the URI that caused the exception.
    - The method returns a `ResponseEntity` containing the `StandardError` object and the appropriate HTTP status code.

---

### 25. Error Case: Handling Resource Not Found via Spring Boot RESTful API (`findAll`):

#### 25.1. Setting Up the RESTful API for HTTP Methods (`Idempotent`):

- **Endpoint** GET `/users`;
- **Purpose**: Retrieves all `User` items from the database.

#### 25.2. Example GET Request (`Empty Table`):

- **Scenario**: The database table is empty, triggering the custom error response with a `404 Not Found` status code:

````markdown
GET http://localhost:8080/users
````

#### 25.3. Example Error Response:

````json
{
  "timestamp": "2025-02-08T22:21:56Z",
  "status": 404,
  "error": "No data found in the requested table. Please verify the table name or check if it contains records.",
  "message": "The requested table is empty or does not exist.",
  "path": "/users"
}
````

---

### 26. Implement `findByEmail` Operation for Users with GET Method:

#### 26.1. **UPDATE INTERFACE:** `FoodRepository`:

- Use `Optional<User> findByEmail(String email);` only if the email attribute is expected to be unique. This method
  returns an `Optional` that contains the `User` if found, or is empty if not. Handling the result through `Optional`
  encourages explicit checks for absence, thereby reducing `NullPointerExceptions`;
- If the email attribute is not guaranteed to be unique, consider implementing a method that returns a list of `Users`,
  such as `List<User> findAllByEmail(String email);`. This approach ensures that multiple `Users` with the same email
  address can be retrieved effectively, avoiding potential conflicts.

#### 26.2. **NEW METHOD:** `UserService.findByEmail`:

- **Purpose:** Fetch a single `User` entity by its email address and map it to a `UserResponseDTO`;
- **Transaction:** Annotate with `@Transactional(readOnly = true)` to ensure that the method runs within a read-only
  transaction;
- **Exception Handling:** Throws a custom `EmailNotFoundException` if the `email` is not found.

##### 26.2.1. **Sample Code**:

```java

@Transactional(readOnly = true)
public UserResponseDTO findByEmail(String email) {
    User entity = userRepository.findByEmail(email).orElseThrow(() -> new EmailNotFoundException(email));
    return new UserResponseDTO(entity);
}
```

#### 26.3. **NEW METHOD:** `UserController.findByEmail`:

- **Purpose:** Handle `GET` requests to retrieve a `User` by its email address;
- **Mapping:** Use `@GetMapping(value = "/email/{email}")` to map the request;
- **Response:** Returns a `ResponseEntity<UserResponseDTO>` with an HTTP `200 (OK)` status if successful;
- **Exception Handling:** Automatically handles `EmailNotFoundException` and returns an appropriate HTTP
  `404 (Not Found)` response if the `User` is not found.

##### 26.3.1. **Sample Code**:

```java
@GetMapping(value = "/email/{email}")
public ResponseEntity<UserResponseDTO> findByEmail(@PathVariable String email) {
    UserResponseDTO dto = userService.findByEmail(email);
    return ResponseEntity.ok().body(dto);
}
```

---

### 27. Success Case: Requesting and Responding User Data via Spring Boot RESTful API (`findByEmail`):

#### 27.1. Setting Up the RESTful API for HTTP Methods (`Idempotent`):

- **Endpoint:** `GET /users/email/{email}`;
- **Purpose:** Retrieves a specific `User` item by its email address.

#### 27.2. Example GET Request:

- **Scenario:** Successfully retrieves the requested `User` by email address:

````markdown
GET http://localhost:8080/users/email/ophelia@email.com
````        

#### 27.3. Example Response:

````json
{
  "id": "67a9344d0684c222bb260f24",
  "name": "Ophelia Birrenta",
  "email": "ophelia@email.com"
}
````

---

### 28. Exception Handling for `findByEmail` Method:

- This section introduces the implementation of custom exception handling for the `findByEmail` method in the
  `UserService`
  class, introducing custom exceptions and centralized error handling mechanisms.

#### 28.1. **NEW CLASS:** `services.exceptions.EmailNotFoundException` (Custom Exception)`:

- Create a custom exception named `EmailNotFoundException`, extending `RuntimeException`;
- Constructor takes an `Object email` as a parameter to provide a specific resource email address in the error message;
- Provide a detailed message when an exception occurs: `"Resource Not Found! Email: [email]"`.

#### 28.2. **UPDATE METHOD:** `handleResourceNotFoundException`:

- This method is responsible for handling exceptions to types `ResourceNotFoundException` and `EmailNotFoundException`,
  converting them into standardised HTTP error responses:

````java
@ExceptionHandler({ResourceNotFoundException.class, EmailNotFoundException.class})
public ResponseEntity<StandardError> handleResourceNotFoundException(RuntimeException e, HttpServletRequest request) {
    String error = "Resource not found with the specified identifier or criteria.";
    HttpStatus status = HttpStatus.NOT_FOUND;
    StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(status).body(err);
}
````

- **Annotations and Parameters:**
    - `@ExceptionHandler`({ResourceNotFoundException.class, EmailNotFoundException.class}): Maps the method to handle
      exceptions to types `ResourceNotFoundException` and `EmailNotFoundException` simultaneously.
    - Parameters:
        - `RuntimeException` e: Captures the exception object, allowing the method to handle both exceptions
          generically, as they inherit from `RuntimeException`;
        - `HttpServletRequest` request: Provides details about the incoming HTTP request, such as the request URI.
    - The method constructs a `StandardError` object, which includes:
        - **Timestamp**: `Instant.now()` ensures the current time is recorded when the exception is handled;
        - **Status Code**: `HttpStatus.NOT_FOUND.value()` returns the HTTP status code 404;
        - **Error Message**: The variable `error` provides a concise description of the error;
        - **Detailed Message**: `e.getMessage()` displays the custom error message from the respective exception class (
          `ResourceNotFoundException` or `EmailNotFoundException`);
        - **Request Path**: `request.getRequestURI()` specifies the URI that caused the exception;
    - The method returns a `ResponseEntity` containing the `StandardError` object and the appropriate HTTP status code.

---

### 29. Error Case: Handling Resource Not Found via Spring Boot RESTful API (`findByEmail`):

#### 29.1. Setting Up the RESTful API for HTTP Methods (`Idempotent`):

- **Endpoint:** `GET /users/email/{email}`;
- **Purpose:** Retrieves a specific `User` item by its email address.

#### 29.2. Example GET Request (`Email Address Does Not Exist`):

- **Scenario:** The requested email address does not exist, triggering the custom error response with a
  `404 Not Found` status code:

````markdown
GET http://localhost:8080/users/joaquina@email.com
````

#### 29.3. Example Error Response:

- **Error Handling**: Upon catching a `EmailNotFoundException`, the method returns a structured JSON response in the
  following format:

````json
{
  "timestamp": "2025-02-10T00:44:17Z",
  "status": 404,
  "error": "Resource not found with the specified identifier or criteria.",
  "message": "Resource Not Found! Email: joaquinha@email.com",
  "path": "/users/email/joaquina@email.com"
}
````

---

### 30. Requirements for Domain Models with References and Aggregate Alignment:

* Design Considerations for Domain Models: Choosing Between References and Aggregate Alignment (`User`, `Post`,
  `Comment` Entities).

#### 30.1. Domain Model with References:

![Domain Model with References](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_U21_SpringMongoDB_NoSQL_WebServices/mongoDBSpringBoot/src/main/resources/static/img/domain-model-references.png)

````json
[
  {
    "id": "1001",
    "name": "Ophelia Birrenta",
    "email": "ophelia@email.com",
    "posts": [
      {
        "date": "2025-02-10",
        "title": "Trip departure",
        "body": "I'm going to travel to São Paulo. Cheers!",
        "comments": [
          {
            "text": "Have a nice trip, dude!",
            "date": "2025-02-10",
            "author": {
              "id": "1013",
              "name": "Balthazar de Bigode"
            }
          },
          {
            "text": "Enjoy!",
            "date": "2025-02-11",
            "author": {
              "id": "1027",
              "name": "Vitalina Simplicio"
            }
          }
        ]
      },
      {
        "date": "2025-02-12",
        "title": "Good morning",
        "body": "I woke up happy today!",
        "comments": [
          {
            "text": "Have a great day!",
            "date": "2025-02-12",
            "author": {
              "id": "1013",
              "name": "Balthazar de Bigode"
            }
          }
        ]
      }
    ]
  }
]
````

* **Observation:** Domain Model with References demonstrates the domain model with references. This is evident in how
  the relationships
  between entities are established.
* **Requirements:**
    * Related objects (Post and Comment) have a significant amount of data and/or independent relevance within the
      domain;
    * The need to access all data of related objects simultaneously is less frequent;
    * Prioritizes performance optimization and reduced load in scenarios where complete data of related objects is not
      always needed.

* **Details (Domain Model with References):**
    * **User:** Has a list of Post IDs (`posts: [5001, 5010]`), indicating the user has associated posts, but not the
      posts themselves;
    * **Post:** Similarly, has a list of Comment IDs (`comments: [...]`), showing the post has comments, but not the
      Comment objects themselves;
    * **Comment:** Likewise, only has the ID of the authoring user (`author: { id: "1013", ... }`), not the complete
      User object.

* **Example (User):**
    * `id` (String): Unique identifier of the user;
    * `name` (String): Name of the user;
    * `email` (String): Email address of the user;
    * `posts` (List<String>): List of IDs of posts associated with the user.

* **Example (Post):**
    * `id` (String): Unique identifier of the post;
    * `date` (Date): Date of creation of the post;
    * `title` (String): Title of the post;
    * `body` (String): Content of the post;
    * `author` (String): ID of the user who authored the post;
    * `comments` (List<String>): List of IDs of comments associated with the post.

* **Example (Comment):**
    * `id` (String): Unique identifier of the comment;
    * `text` (String): Text of the comment;
    * `date` (Date): Date of creation of the comment;
    * `author` (String): ID of the user who authored the comment.

#### 30.2. Domain Model with Aggregate Alignment:

![Domain Model with Aggregate Alignment](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_U21_SpringMongoDB_NoSQL_WebServices/mongoDBSpringBoot/src/main/resources/static/img/domain-model-aggregate-alignment.png)

````json
[
  {
    "id": "1001",
    "name": "Ophelia Birrenta",
    "email": "ophelia@email.com",
    "posts": [
      "5001",
      "5010"
    ]
  }
  {
    "id": "5001",
    "date": "2025-02-10",
    "title": "Trip departure",
    "body": "I'm going to travel to São Paulo. Cheers!",
    "author": {
      "id": "1001",
      "name": "Ophelia Birrenta"
    },
    "comments": [
      {
        "text": "Have a nice trip, dude!",
        "date": "2025-02-10",
        "author": {
          "id": "1013",
          "name": "Balthazar de Bigode"
        }
      },
      {
        "text": "Enjoy!",
        "date": "2025-02-11",
        "author": {
          "id": "1027",
          "name": "Vitalina Simplicio"
        }
      }
    ]
  }
  {
    "id": "5010",
    "date": "2025-02-12",
    "title": "Good morning",
    "body": "I woke up happy today!",
    "author": {
      "id": "1001",
      "name": "Ophelia Birrenta"
    },
    "comments": [
      {
        "text": "Have a great day!",
        "date": "2025-02-12",
        "author": {
          "id": "1013",
          "name": "Balthazar de Bigode"
        }
      }
    ]
  }
]
````

* **Observation:** Domain Model with Aggregate Alignment represents the domain model with aggregate alignment.
* **Requirements:**
    * Related objects (Post and Comment) are relatively simple and/or the need to access all data of related objects
      simultaneously is very frequent;
    * Prioritizes convenience and ease of data access over performance in specific scenarios.

* **Details (Domain Model with Aggregate Alignment):**
    * **User:** Has a list of complete Post objects (`posts: [...]`), meaning the post data is directly embedded within
      the User object;
    * **Post:** Similarly, has a list of complete Comment objects (`comments: [...]`), with all comment details within
      the Post object;
    * **Comment:** The Comment object also contains the complete User object of the author (`author: { ... }`).

* **Example (User):**
    * `id` (String): Unique identifier of the user;
    * `name` (String): Name of the user;
    * `email` (String): Email address of the user;
    * `posts` (List<Post>): List of Post objects associated with the user.

* **Example (Post):**
    * `id` (String): Unique identifier of the post;
    * `date` (Date): Date of creation of the post;
    * `title` (String): Title of the post;
    * `body` (String): Content of the post;
    * `author` (User): User object of the post's author;
    * `comments` (List<Comment>): List of Comment objects associated with the post.

* **Example (Comment):**
    * `id` (String): Unique identifier of the comment;
    * `text` (String): Text of the comment;
    * `date` (Date): Date of creation of the comment;
    * `author` (User): User object of the comment's author.

#### Notes:

* The choice between domain models with references and aggregate alignment depends on the specific business requirements
  and data access needs;
* In complex scenarios, it may be advantageous to combine the two models, using references for related objects with
  large data volumes and aggregate alignment for simpler, frequently accessed objects.

---

### 31. Creating Post Entity with Nested User:

#### 31.1. **NEW CLASS:** Requirements for Post Entity Class:

- **Entity Mapping:**
    - Create the `Post` class as an entity to represent a database collection in the application;
    - Annotate the class with `@Document` to define it as a MongoDB document.
- **Attributes and Annotations:**
    - Define attributes `id`, `date`, `title`, `body`, and `author` to represent fields in the document;
    - Annotate the `id` field with `@Id` to designate it as the primary key field;
    - Annotate the `date` field with
      `@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")` to specify
      the date format for JSON serialization and deserialization;
    - The `author` field should be of type `AuthorResponseDTO`, establishing a relationship with the DTO.
- **Constructors:**
    - Create a no-argument constructor required by the persistence framework;
    - Provide an all-arguments constructor for convenience.
- **Accessors and Mutators:**
    - Implement getters and setters for all attributes to allow data manipulation.
- **Equals and HashCode:**
    - Override the `equals()` method to compare entities based on the `id` attribute;
    - Override `hashCode()` to provide a consistent hash for `Post` objects, using `Objects.hashCode(id)`.
- **Serializable Interface:**
    - Implement the `Serializable` interface to support object serialization for the entity when necessary.

---

### 32. **NEW DTO PATTERN** for Customizing User and Post Representation:

#### 32.1. Requirements for AuthorResponseDTO Record Class:

- **Record Declaration:**
    - Create the `AuthorResponseDTO` as a `record` class to represent a simplified data structure for the `author` field
      in `Post` responses;
- **Attribute Definition:**
    - Define the attributes `String id` and `String name` directly in the record's header to make them immutable and
      automatically provide accessor methods;
- **Entity-based Constructor:**
    - Implement a custom constructor that accepts a `User` entity object as an argument;
    - Extract and map values from the `User` entity to initialise the `AuthorResponseDTO` attributes;
- **Purpose:**
    - Use this `record` for representing the `author` data within the `Post` object, offering a controlled and
      potentially more efficient way to transfer author-related data. This avoids exposing the entire `User` entity in
      the `Post` response.

#### 32.2. Requirements for PostResponseDTO Record Class:

- **Record Declaration:**
    - Create the `PostResponseDTO` as a `record` class to represent a simplified data structure for `Post` responses;
- **Attribute Definition:**
    - Define the attributes `String id`, `Instant date`, `String title`, and `String body` directly in the record's
      header to make them immutable and automatically provide accessor methods;
- **Entity-based Constructor:**
    - Implement a custom constructor that accepts a `Post` entity object as an argument;
    - Extract and map values from the `Post` entity to initialise the `PostResponseDTO` attributes;
- **Purpose:**
    - Use this `record` for representing `Post` data in responses, offering a controlled and potentially more efficient
      way to transfer post-related data. This avoids exposing the entire `Post` entity in the response.

---

### 33. Repository Interface, Service, and Resource/Controller Post Classes:

#### 33.1. Requirements for PostRepository Interface:

- **Repository Creation:**
    - Create the `PostRepository` interface to handle data access operations for the `Post` entity;
- **MongoRepository Extension:**
    - Extend `MongoRepository<Post, String>` to inherit common CRUD operations and MongoDB-specific functionalities;
- **Entity Association:**
    - Specify `Post` as the associated entity and `String` as the type for its primary key.

#### 33.2. Requirements for PostService Class:

- **Service Annotation:**
    - Use the `@Service` annotation to define the class as a Spring service component;
- **Dependency Injection:**
    - Inject `PostRepository` using the `@Autowired` annotation for dependency injection;
- **`findById` Method Implementation:**
    - Implement the `findById(String id)` method to retrieve a `Post` entity by its ID;
- **Transaction Management:**
    - Use the `@Transactional(readOnly = true)` annotation to ensure the method runs within a read-only transaction for
      optimised database performance.
- **Exception Handling:**
    - Implement proper exception handling, such as throwing a `ResourceNotFoundException` if a `Post` with the given ID
      is not found.
- **DTO Conversion:**
    - Convert the retrieved `Post` entity to a `PostResponseDTO` before returning it.

#### 33.3. Requirements for PostController Class:

- **Controller Annotation:**
    - Create the `PostController` class to manage RESTful endpoints for the `Post` resource;
    - Use the `@RestController` annotation to mark it as a REST controller for Spring;
- **Request Mapping:**
    - Map requests using the `@RequestMapping` annotation for the `/posts` endpoint;
- **Dependency Injection:**
    - Inject `PostService` using the `@Autowired` annotation for service dependency injection;
- **`findById` Endpoint Implementation:**
    - Implement the `findById` method to handle HTTP requests:
        - **GET Request:**
            - Use the `@GetMapping(value="/{id}")` annotation to map GET requests to `/posts/{id}`;
            - Call the `postService.findById(id)` method to retrieve the `PostResponseDTO`;
            - Return a `ResponseEntity<PostResponseDTO>` with an HTTP 200 (OK) status and the `PostResponseDTO` in the
              response body.
- **Exception Handling:**
    - Ensure that the controller handles exceptions appropriately, such as returning a 404 Not Found response if a
      `ResourceNotFoundException` is thrown by the service.

#### 33.4. Idempotent and Non-Idempotent Methods:

- **Idempotent Methods:** `GET`, `PUT`, and `DELETE` are idempotent, meaning multiple identical requests should have the
  same effect as a single request;
- **Non-Idempotent Method:** `POST` is non-idempotent, meaning multiple identical requests may have additional effects.

---

### 34. Success Case: Requesting and Responding Post Data via Spring Boot RESTful API (`findById`):

#### 34.1. Setting Up the RESTful API for HTTP Methods (`Idempotent`):

- **Endpoint:** `GET /posts/{id}`;
- **Purpose:** Retrieves a specific `Post` item by its ID.

#### 34.2. Example GET Request:

- **Scenario:** Successfully retrieves the requested `Post` by ID:

````markdown
GET http://localhost:8080/posts/67ab5f0400e0ba322ea51db0
````        

#### 34.3. Example Response:

````json
{
  "id": "67ab5f0400e0ba322ea51db0",
  "date": "2025-02-12T00:00:00Z",
  "title": "Good morning",
  "body": "I woke up happy today!"
}
````

---

### 35. Error Case: Post Handling Resource Not Found via Spring Boot RESTful API (`findById`):

#### 35.1. Setting Up the RESTful API for HTTP Methods (`Idempotent`):

- **Endpoint:** `GET /posts/{id}`;
- **Purpose:** Retrieves a specific `POST` item by its ID.

#### 35.2. Example GET Request (`ID Does Not Exist`):

- **Scenario:** The requested ID does not exist, triggering the custom error response with a
  `404 Not Found` status code:

````markdown
GET http://localhost:8080/posts/XXXXXXXXXX
````

#### 35.3. Example Error Response:

- **Error Handling**: Upon catching a `ResourceNotFoundException`, the method returns a structured JSON response in the
  following format:

````json
{
  "timestamp": "2025-02-11T14:44:29Z",
  "status": 404,
  "error": "Resource not found with the specified identifier or criteria.",
  "message": "Resource Not Found! ID: XXXXXXXXXX",
  "path": "/posts/XXXXXXXXXX"
}
````

---

### 36. **UPDATE CLASS:** `User` Entity Class:

#### 36.1. New Requirements for User Entity Class:

- **Attributes and Annotations:**
    - The `posts` field should be a `List<Post>` and annotated with `@DBRef(lazy = true)` to establish a relationship
      with the `Post` entity and enable lazy loading. .
- **Accessors and Mutators:**
    - Implement getters for posts attribute to allow data manipulation.

---

### 37. Implement endpoint `findPostsByUserId` for retrieving User Posts;

#### 37.1. **NEW GET METHOD:** `UserService.findPostsByUserId`:

- **Method Signature:**
    - Define a method named `findPostsByUserId` that accepts a `String id` (representing the user's ID) as a parameter;
- **Data Retrieval:**
    - Use the `userRepository` to find the `User` entity by the provided `id`;
- **Exception Handling:**
    - If the `User` is not found, throw a `ResourceNotFoundException` with the provided `id`;
- **Data Transformation:**
    - Retrieve the list of `Post` entities associated with the found `User` (e.g., using `user.getPosts()`);
    - Use Java streams to map each `Post` entity to a `PostResponseDTO` object;
- **Return Value:**
    - Return a `List<PostResponseDTO>` containing the transformed post data;
- **Transaction Management:**
    - Annotate the method with `@Transactional(readOnly = true)` to indicate that it's a read-only transaction.
- **Purpose:**
    - This method encapsulates the business logic for retrieving a user's posts and transforming them into DTOs,
      providing a clean and consistent interface for the controller.

#### 37.2. **NEW GET METHOD:** `UserController.findPostsByUserId`:

- **Request Mapping:**
    - Map a `GET` request to the endpoint `/users/{id}/posts`, where `{id}` is a path variable representing the user's
      ID;
- **Path Variable:**
    - Use the `@PathVariable` annotation to extract the `id` from the URL;
- **Service Call:**
    - Call the `userService.findPostsByUserId(id)` method to retrieve the list of `PostResponseDTO` objects;
- **Response Handling:**
    - If the returned list is empty, return a `ResponseEntity` with HTTP status `204 (No Content)`;
    - If the list is not empty, return a `ResponseEntity` with HTTP status `200 (OK)` and the list of `PostResponseDTO`
      objects in the response body;
- **Cross-Origin Resource Sharing (CORS):**
    - Apply the `@CrossOrigin` annotation to allow requests from specific origins (e.g., `*` for all origins, or a
      specific domain). Consider the security implications of allowing all origins.
- **Purpose:**
    - This method handles incoming `GET` requests for user posts, delegates the data retrieval and transformation to the
      service layer, and returns an appropriate HTTP response to the client. It manages the API endpoint and ensures
      proper communication with the service.****

---

### 38. Success Case: Requesting and Responding User Posts via Spring Boot RESTful API (`findPostsByUserId`)

#### 38.1. Setting Up the RESTful API for HTTP Methods (`Idempotent`)

- **Endpoint:** `GET /users/{id}/posts`;
- **Purpose:** Retrieves all `Post` items associated with a specific `User` by their ID.

#### 38.2. Example GET Request

- **Scenario:** Successfully retrieves all posts linked to the requested `User` by ID:

````markdown
GET http://localhost:8080/users/67ab40625e5a68033a6cb9b1/posts
````

#### 38.3. Example Response:

````json
[
  {
    "id": "67ab40625e5a68033a6cb9b6",
    "date": "2025-02-10T00:00:00Z",
    "title": "Trip departure",
    "body": "I'm going to travel to São Paulo. Cheers!"
  },
  {
    "id": "67ab40625e5a68033a6cb9b7",
    "date": "2025-02-12T00:00:00Z",
    "title": "Good morning",
    "body": "I woke up happy today!"
  }
]

````

---

### 39. Error Case: Handling Resource Not Found via Spring Boot RESTful API (`findPostsByUserId`):

#### 39.1. Setting Up the RESTful API for HTTP Methods (`Idempotent`):

- **Endpoint:** `GET /users/{id}/posts`;
- **Purpose:** Retrieves all `Post` items associated with a specific `User` by their ID.

#### 39.2. Example GET Request (`ID Does Not Exist`):

- **Scenario:** The requested ID does not exist, triggering the custom error response with a
  `404 Not Found` status code:

````markdown
GET http://localhost:8080/users/XXXXXXXXXXXXXX/posts
````

#### 39.3. Example Error Response:

- **Error Handling**: Upon catching a `ResourceNotFoundException`, the method returns a structured JSON response in the
  following format:

````json
{
  "timestamp": "2025-02-11T13:43:06Z",
  "status": 404,
  "error": "Resource not found with the specified identifier or criteria.",
  "message": "Resource Not Found! ID: XXXXXXXXXXXXXX",
  "path": "/users/XXXXXXXXXXXXXX/posts"
}
````

---

### 40. Creating Comment Entity Class:

#### 40.1. **NEW CLASS:** Requirements for Comment Entity Class:

- **Entity Mapping:**
    - Create the `Comment` class as an entity to represent embedded data within a `Post` document;
    - The `Comment` class should *not* be annotated with `@Document` as it's not a top-level collection.

- **Attributes and Annotations:**
    - Define attributes `text`, `date`, and `author` to represent fields in the embedded document;
    - Annotate the `date` field with
      `@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")` to specify
      the date format for JSON serialization and deserialization;
    - The `author` field should be of type `AuthorResponseDTO`, establishing a relationship with the DTO.

- **Constructors:**
    - Create a no-argument constructor required by the persistence framework;
    - Provide an all-arguments constructor for convenience.

- **Accessors and Mutators:**
    - Implement getters and setters for all attributes to allow data manipulation.

- **Serializable Interface:**
    - Implement the `Serializable` interface to support object serialization for the entity when necessary.

---

### 41. DTO Pattern for Comment Representation:

#### 41.1. Requirements for CommentResponseDTO Record Class:

- **Record Declaration:**
    - Create the `CommentResponseDTO` as a `record` class to represent a simplified data structure for responses.

- **Attribute Definition:**
    - Define the attributes `String text`, `Instant date`, and `AuthorResponseDTO author` directly in the record's
      header, making them immutable and automatically providing accessor methods.

- **Entity-based Constructor:**
    - Implement a custom constructor that accepts a `Comment` entity object as an argument;
    - Extract and map values from the `Comment` entity to initialize the `CommentResponseDTO` attributes.

- **Purpose:**
    - Use this `record` for transferring comment-related data from the backend service layer to the controller response,
      following RESTful API conventions.

---

### 42. **UPDATE CLASS:** `Instantiation` Class:

#### 42.1. Requirements for Updating User with Posts and Comments in Instantiation Class:

- **Post-User Relationship Management:**
    - After saving the `Post` objects, update the `User` object (`user02` in this case) to reflect the relationship with
      the newly created posts.

- **Updating the User's Post List:**
    - Retrieve the list of posts associated with `user02` using `user02.getPosts()`. It is important to understand that
      if the `posts` list is initialized when the `User` is created, then this retrieval will return that list. If the
      `posts` list is not initialized, then the retrieval will return null. If it returns null, then you must initialize
      the `posts` list before proceeding. This can be done with `user02.setPosts(new ArrayList<>());` for example;
    - Add the newly created `Post` objects (`post01` and `post02`) to the user's list of posts using
      `addAll(Arrays.asList(post01, post02))`. This establishes the connection between the user and their posts.

- **Saving the Updated User:**
    - Persist the changes to the `user02` object in the database using `userRepository.save(user02)`. This ensures that
      the updated list of posts is stored along with the user's information. It is important to understand that the
      `posts` list is annotated with `@DBRef`. This annotation means that only references to the `Post` objects are
      stored in the `User` document. The actual `Post` objects are stored in a separate collection. This is a key
      concept in MongoDB and NoSQL databases in general.

- **Comment Integration within Posts:**
    - After creating the `Post` objects (`post01` and `post02`), associate `Comment` objects with them;
    - Create instances of `CommentResponseDTO` (e.g., `comment01`, `comment02`, `comment03`) representing comments on
      the posts. These should contain the comment text, date, and author (represented by `AuthorResponseDTO`);
    - Retrieve the `comments` list from each `Post` object (similar to how you handled the `posts` list in the `User`
      object). Ensure the list is initialized if it is null;
    - Add the created `CommentResponseDTO` objects to the respective `Post`'s `comments` list using `addAll()` or
      `add()`. This establishes the relationship between the post and its comments;
    - Save the updated `Post` objects using `postRepository.saveAll(Arrays.asList(post01, post02))`. This persists the
      comments along with the posts. Because `Comment` is embedded within `Post`, saving the `Post` will also save the
      associated `Comment` objects. There's no separate collection for comments.

- **Explanation of Key Operations:**
    - `user02.getPosts()`: This retrieves the posts list associated with the `user02` object. Remember that `user02`
      represents a user, and `posts` is a list of `Post` objects they have authored;
    - `.addAll(Arrays.asList(post01, post02))`: This adds the `post01` and `post02` objects to the `posts` list
      retrieved in the previous step. The `addAll()` method is used to add all elements from the specified collection (
      in this case, a list created from the `post01` and `post02` objects) to the end of the current list;
    - `userRepository.save(user02)`: This saves the updated `user02` object back to the database. Because of the
      `@DBRef` annotation on the `posts` list, only the references (IDs) of the `post01` and `post02` objects are stored
      in the `user02` document. This is how MongoDB handles relationships efficiently. The actual `Post` documents are
      stored separately;
    - `post01.getComments().addAll(...)`:  This retrieves the list of comments for `post01` and adds the new comments to
      it. Again, if the list is null, it needs to be initialized first. Because `Comment` is embedded, the comments are
      stored directly within the `Post` document.
    - `postRepository.saveAll(...)`: This saves the `Post` objects, including the embedded `Comment` objects.

````java
@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User user01 = new User(null, "Balthazar de Bigode", "balthazar@email.com");
        User user02 = new User(null, "Ophelia Birrenta", "ophelia@email.com");
        User user03 = new User(null, "Gonçalo Munhoz", "goncalo@email.com");
        User user04 = new User(null, "Vitalina Simplicio", "vitalina@email.com");
        User user05 = new User(null, "Ludovico Crispim", "ludovico@email.com");
        User user06 = new User(null, "Filisbina Junqueira", "filisbina@email.com");

        userRepository.saveAll(Arrays.asList(user01, user02, user03, user04, user05, user06));

        Post post01 = new Post(null, Instant.parse("2025-02-10T00:00:00Z"), "Trip departure", "I'm going to travel to São Paulo. Cheers!", new AuthorResponseDTO(user02));
        Post post02 = new Post(null, Instant.parse("2025-02-12T00:00:00Z"), "Good morning", "I woke up happy today!", new AuthorResponseDTO(user02));

        CommentResponseDTO comment01 = new CommentResponseDTO("Have a nice trip, dude!", Instant.parse("2025-02-10T00:00:00Z"), new AuthorResponseDTO(user01));
        CommentResponseDTO comment02 = new CommentResponseDTO("Enjoy!", Instant.parse("2025-02-11T00:00:00Z"), new AuthorResponseDTO(user04));
        CommentResponseDTO comment03 = new CommentResponseDTO("Have a great day!", Instant.parse("2025-02-12T00:00:00Z"), new AuthorResponseDTO(user01));
        post01.getComments().addAll(Arrays.asList(comment01, comment02));
        post02.getComments().add(comment03);

        postRepository.saveAll(Arrays.asList(post01, post02));

        user02.getPosts().addAll(Arrays.asList(post01, post02));
        userRepository.save(user02);
    }
}
````

### 43. Sample Post Document with Comments as Viewed in MongoDB Compass:

#### 43.1. Example Response `post01`:

````json
{
  "_id": {
    "$oid": "67ab7fdfd9ee726c0a71ce24"
  },
  "date": {
    "$date": "2025-02-10T00:00:00.000Z"
  },
  "title": "Trip departure",
  "body": "I'm going to travel to São Paulo. Cheers!",
  "author": {
    "_id": {
      "$oid": "67ab7fdfd9ee726c0a71ce1f"
    },
    "name": "Ophelia Birrenta"
  },
  "comments": [
    {
      "text": "Have a nice trip, dude!",
      "date": {
        "$date": "2025-02-10T00:00:00.000Z"
      },
      "author": {
        "_id": {
          "$oid": "67ab7fdfd9ee726c0a71ce1e"
        },
        "name": "Balthazar de Bigode"
      }
    },
    {
      "text": "Enjoy!",
      "date": {
        "$date": "2025-02-11T00:00:00.000Z"
      },
      "author": {
        "_id": {
          "$oid": "67ab7fdfd9ee726c0a71ce21"
        },
        "name": "Vitalina Simplicio"
      }
    }
  ],
  "_class": "com.souza.charles.mongoDBSpringBoot.domain.Post"
}
````

### 44. Sample Post Document with Comments as Viewed in MongoDB Compass:

#### 44.1. Example Response `post02`:

````json
{
  "_id": {
    "$oid": "67ab7fdfd9ee726c0a71ce25"
  },
  "date": {
    "$date": "2025-02-12T00:00:00.000Z"
  },
  "title": "Good morning",
  "body": "I woke up happy today!",
  "author": {
    "_id": {
      "$oid": "67ab7fdfd9ee726c0a71ce1f"
    },
    "name": "Ophelia Birrenta"
  },
  "comments": [
    {
      "text": "Have a great day!",
      "date": {
        "$date": "2025-02-12T00:00:00.000Z"
      },
      "author": {
        "_id": {
          "$oid": "67ab7fdfd9ee726c0a71ce1e"
        },
        "name": "Balthazar de Bigode"
      }
    }
  ],
  "_class": "com.souza.charles.mongoDBSpringBoot.domain.Post"
}
````

---

### 45. **UPDATE CLASS** Requirements for PostRepository Interface:

- **Title Search Query:**
    - Implement the `searchTitle(String text)` method;
    - Annotate it with `@Query("{ 'title': { $regex: ?0, $options: 'i' } }")` to perform case-insensitive searches in
      the `title` field using a regular expression;
    - Ensure the method returns a `List<PostResponseDTO>`.

- **Full Search Query:**
    - Implement the `fullSearch(String text, Instant minDate, Instant maxDate)` method;
    - Annotate it with:
      ```java
      @Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
      ```
    - Ensure the method:
        - Filters posts with `date` between `minDate` and `maxDate`;
        - Searches for the provided `text` in `title`, `body`, or `comments.text`, using case-insensitive regular
          expressions;
        - Returns a `List<PostResponseDTO>`.

---

### 46. **NEW CLASS:** Requirements for URL Utility Class:

- **Class Definition:**
    - Create a utility class named `URL` for handling URL-related operations;
    - Ensure the class contains only static methods and cannot be instantiated.

- **Parameter Decoding:**
    - Implement `decodeParam(String text)`;
    - Use `URLDecoder.decode(text, StandardCharsets.UTF_8)` to decode URL-encoded strings;
    - Return the decoded string.

- **Date Conversion:**
    - Implement `convertDate(String textDate, Instant defaultValue)`;
    - Use `DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.of("GMT"))` to parse dates in `yyyy-MM-dd` format;
    - Convert parsed `LocalDate` values to `Instant` using `atStartOfDay(ZoneId.of("GMT")).toInstant()`;
    - Handle exceptions by returning the provided `defaultValue`.

---

### 47. **UPDATED CLASS:** Requirements for PostService Class:

- **Logger:**
    - Declare a `Logger` instance using `LoggerFactory.getLogger(PostService.class)`.

- **Find Posts by Title:**
    - Implement `findByTitle(String text)`;
    - Delegate the search operation to `postRepository.searchTitle(text)`;
    - Throw a `SearchResultNotFoundException` if the search returns an empty list;
    - Return a `List<PostResponseDTO>`.

- **Full Search with Date Filtering:**
    - Implement `fullSearch(String text, Instant minDate, Instant maxDate)`;
    - Validate that `minDate` and `maxDate` are not null and that `minDate` is not after `maxDate` or the current date;
    - Extend `maxDate` by one day using `maxDate = maxDate.plusSeconds(24 * 60 * 60)`;
    - Delegate the search operation to `postRepository.fullSearch(text, minDate, maxDate)`;
    - Throw a `SearchResultNotFoundException` if the search returns an empty list;
    - Throw a `DateRangeInvalidException` if the date range is invalid.

---

### 48. **UPDATED CLASS:** Requirements for PostController Class:

- **Logger:**
    - Declare a `Logger` instance using `LoggerFactory.getLogger(PostController.class)`.

- **Find Posts by Title Endpoint:**
    - Implement `findByTitle(@RequestParam(value = "text", defaultValue = "") String text)`;
    - Map it to `@GetMapping(value = "/titles")`;
    - Decode the `text` parameter using `URL.decodeParam(text)`;
    - Call `postService.findByTitle(text)`;
    - Return a `ResponseEntity<List<PostResponseDTO>>` with HTTP status `200 OK`.

- **Full Search Endpoint:**
    - Implement
      `fullSearch(@RequestParam(value = "text", defaultValue = "") String text, @RequestParam(value = "minDate", defaultValue = "") String minDate, @RequestParam(value = "maxDate", defaultValue = "") String maxDate)`;
    - Map it to `@GetMapping(value = "/search")`;
    - Decode the `text` parameter using `URL.decodeParam(text)`;
    - Convert `minDate` and `maxDate` using `URL.convertDate(minDate, Instant.EPOCH)` and
      `URL.convertDate(maxDate, Instant.now())`;
    - Call `postService.fullSearch(text, min, max)`;
    - Return a `ResponseEntity<List<PostResponseDTO>>` with HTTP status `200 OK`.

---

### 49. Success Case: Post Requesting and Responding User Data via Spring Boot RESTful API (`findByTitle`):

#### 49.1. Setting Up the RESTful API for HTTP Methods (`Idempotent`):

- **Endpoint:** `GET /posts/titles`;
- **Purpose:** Searches for `Posts` based on a `title`.

#### 49.2. Example GET Request:

- **Scenario:** Successfully retrieves the requested `Posts` by `title`:

````markdown
GET http://localhost:8080/posts/titles?text=Trip
````        

#### 49.3. Example Response:

````json
[
  {
    "id": "67abfc47cca46676bf2a53e9",
    "date": "2025-02-10T00:00:00Z",
    "title": "Trip departure",
    "body": "I'm going to travel to São Paulo. Cheers!"
  }
]
````

### 50. Exception Handling for `findByTitle` Method:

- This section introduces the implementation of custom exception handling for the `findByTitle` method in the
  `UserService` class, introducing custom exceptions and centralized error handling mechanisms.

#### 50.1. **NEW CLASS:** `services.exceptions.SearchResultNotFoundException` (Custom Exception)`:

- Create a custom exception named `SearchResultNotFoundException`, extending `RuntimeException`;
- Constructor takes an `Object text` as a parameter to provide a specific resource Post title in the error message;
- Provide a detailed message when an exception occurs: `"No results found for the search: " [text] `.

---

#### 50.2. **UPDATE METHOD:** `handleResourceNotFoundException`:

- This method is responsible for handling exceptions to types `ResourceNotFoundException`, `EmailNotFoundException`, and
  `SearchResultNotFoundException`,
  converting them into standardised HTTP error responses:

````java
@ExceptionHandler({ResourceNotFoundException.class, EmailNotFoundException.class, SearchResultNotFoundException.class})
public ResponseEntity<StandardError> handleResourceNotFoundException(RuntimeException e, HttpServletRequest request) {
    String error = "Resource not found with the specified identifier or criteria.";
    HttpStatus status = HttpStatus.NOT_FOUND;
    StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(status).body(err);
}
````

- **Annotations and Parameters:**
    - `@ExceptionHandler`({ResourceNotFoundException.class, EmailNotFoundException.class,
      SearchResultNotFoundException.class})): Maps the method to handle
      exceptions to types `ResourceNotFoundException`, `EmailNotFoundException`, and `SearchResultNotFoundException`
      simultaneously.
    - Parameters:
        - `RuntimeException` e: Captures the exception object, allowing the method to handle both exceptions
          generically, as they inherit from `RuntimeException`;
        - `HttpServletRequest` request: Provides details about the incoming HTTP request, such as the request URI.
    - The method constructs a `StandardError` object, which includes:
        - **Timestamp**: `Instant.now()` ensures the current time is recorded when the exception is handled;
        - **Status Code**: `HttpStatus.NOT_FOUND.value()` returns the HTTP status code 404;
        - **Error Message**: The variable `error` provides a concise description of the error;
        - **Detailed Message**: `e.getMessage()` displays the custom error message from the respective exception class (
          `ResourceNotFoundException` or `EmailNotFoundException` or SearchResultNotFoundException);
        - **Request Path**: `request.getRequestURI()` specifies the URI that caused the exception;
    - The method returns a `ResponseEntity` containing the `StandardError` object and the appropriate HTTP status code.

---

### 51. Error Case: Post Handling Resource Not Found via Spring Boot RESTful API (`findByTitle`):

#### 51.1. Setting Up the RESTful API for HTTP Methods (`Idempotent`):

- **Endpoint:** `GET /posts/titles`;
- **Purpose:** Searches for `Posts` based on a `title`.

#### 51.2. Example GET Request (`Title Does Not Found`):

- **Scenario:** The requested title does not exist, triggering the custom error response with a
  `404 Not Found` status code:

````markdown
GET http://localhost:8080/posts/titles?text=XXXXX
````

#### 51.3. Example Error Response:

- **Error Handling**: Upon catching a `SearchResultNotFoundException`, the method returns a structured JSON response in
  the
  following format:

````json
{
  "timestamp": "2025-02-12T01:41:48Z",
  "status": 404,
  "error": "Resource not found with the specified identifier or criteria.",
  "message": "No results found for the search: XXXXX",
  "path": "/posts/titles"
}
````

---

### 52. Success Case: Post Requesting and Responding User Data via Spring Boot RESTful API (`fullSearch`):

#### 52.1. Setting Up the RESTful API for HTTP Methods (`Idempotent`):

- **Endpoint:** `GET /posts/search`
- **Purpose:** Searches for `Posts` based on the provided `search text` and `date` range filters.

#### 52.2. Example GET Request:

- **Scenario:** Successfully retrieves the requested `Posts` by `text` within the specified `date` range:

````markdown
GET http://localhost:8080/posts/search?text=enjoy&minDate=2025-02-10&maxDate=2025-02-14
````        

#### 52.3. Example Response:

````json
[
  {
    "id": "67ac14cd65188373d733457d",
    "date": "2025-02-10T00:00:00Z",
    "title": "Trip departure",
    "body": "I'm going to travel to São Paulo. Cheers!"
  }
]
````

### 53. Exception Handling for `fullSearch` Method:

- This section introduces the implementation of custom exception handling for the `fullSearch` method in the
  `UserService` class, introducing custom exceptions and centralized error handling mechanisms.

#### 53.1. **NEW CLASS:** `services.exceptions.DateRangeInvalidException` (Custom Exception):

- Create a custom exception named `DateRangeInvalidException`, extending `RuntimeException`;
- Constructor does not take any parameters;
- Provide a detailed message when an exception occurs: "Invalid date range provided. Please ensure the minimum date is
  no later than the maximum and current dates."

#### 53.2. **NEW METHOD:** `handleDateRangeInvalidException` on class `controller.exceptions.ResourceExceptionHandler`:

- This method is responsible for handling exceptions of type `DateRangeInvalidException` and converting them into
  standardized
  HTTP error responses:

```java
@ExceptionHandler(DateRangeInvalidException.class)
public ResponseEntity<StandardError> handleDateRangeInvalidException(DateRangeInvalidException e, HttpServletRequest request) {
    String error = "Invalid Date Range";
    HttpStatus status = HttpStatus.BAD_REQUEST;
    StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(status).body(err);
}
````

- **Annotations and Parameters:**
    - `@ExceptionHandler(DateRangeInvalidException.class)`: Maps the method to handle exceptions of type
      `DateRangeInvalidException`;
    - It takes two parameters:
        - `DateRangeInvalidException e`: The exception object containing the error details;
        - `HttpServletRequest request`: Captures information about the HTTP request, such as the request URI;
    - The method constructs a `StandardError` object, which includes:
        - **Timestamp**: `Instant.now()` ensures the current time is recorded when the exception is handled;
        - **Status Code**: `HttpStatus.NOT_FOUND.value()` returns the HTTP status code 404;
        - **Error Message**: The variable `error` provides a concise description for the error;
        - **Detailed Message**: `e.getMessage()` displays the custom error message from `DateRangeInvalidException`;
        - **Request Path**: `request.getRequestURI()` specifies the URI that caused the exception.
    - The method returns a `ResponseEntity` containing the `StandardError` object and the appropriate HTTP status code.

---

### 54. Error Case: Post Handling Resource Not Found via Spring Boot RESTful API (`fullSearch`):

#### 54.1. Setting Up the RESTful API for HTTP Methods (`Idempotent`):

- **Endpoint:** `GET /posts/search`
- **Purpose:** Searches for `Posts` based on the provided `search text` and `date` range filters.

#### 54.2. Example GET Request (`Search Text and Date Range Does Not Found`):

- **Scenario:** The requested `Posts` based on the provided `search text` and `date range` filters, triggering the
  custom error response with a `404 Not Found` status code.

````markdown
GET http://localhost:8080/posts/search?text=enjoy&minDate=2025-02-15&maxDate=2025-02-14

````

#### 54.3. Example Error Response:

- **Error Handling**: Upon catching a `DateRangeInvalidException`, the method returns a structured JSON response in
  the
  following format:

````json
{
  "timestamp": "2025-02-12T04:33:41Z",
  "status": 400,
  "error": "Dates are invalids",
  "message": "Minimum and maximum dates are required, with the minimum date no later than the maximum and current.",
  "path": "/posts/search"
}
````

---

## Project Checklist:

- [x] Set up a Java Spring Boot project with MongoDB dependencies;
- [x] Implement the User entity and RESTful endpoints;
- [x] Configure MongoDB connection and data instantiation;
- [x] Database initialisation operation;
- [x] Implement DTO Pattern for User Representation;
- [x] Implement CRUD operations for User, including Exception Handling;
- [x] CRUD User Test Cases validating Success and Error Scenarios;
- [x] Define Domain Model Requirements for Object Reference and Aggregate Object Models;
- [x] Develop the Post entity with nested User information;
- [x] Implement DTO Pattern for Post and Author;
- [x] Implement an endpoint for retrieving a specific Post, including Exception Handling;
- [x] Update User entity to include Post references;
- [x] Implement an endpoint for retrieving User Posts, including Exception Handling;
- [x] Develop the Comment entity with nested User and Post information;
- [x] Implement DTO Pattern for Comment;
- [x] Add Comment functionality to Posts;
- [x] Implement custom queries for Post retrieval (simple and multi-criteria);
- [X] Implement URL parameter decoding for query methods.