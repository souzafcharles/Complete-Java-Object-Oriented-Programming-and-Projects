# Graphical User Interface with JavaFX: Part 02

## Instructions:
<p align="justify">
This guide provides a comprehensive and structured approach to developing a JavaFX application. The application encompasses various functionalities, including creating, updating, and managing different entities such as departments and sellers. The guide is meticulously divided into several sections, each focusing on specific components of the application. Initially, the focus is on setting up the main view, including designing the user interface and integrating essential elements like menus and controllers. Following this, the guide covers the creation of additional views, such as the About view and DepartmentList view, each with detailed instructions on design and controller association. Furthermore, the application integrates database access, leveraging MySQL, and implements the Data Access Object (DAO) pattern to ensure robust data management. Advanced functionalities include the implementation of dialog forms for departments, validation mechanisms, and observer design patterns to keep the user interface synchronised with the backend. The application is designed with scalability and maintainability in mind, ensuring that developers can easily extend and adapt the application to meet evolving requirements. The ultimate goal of this guide is to equip developers with the knowledge and tools necessary to build a sophisticated and fully functional JavaFX application.
</p>

***

## Seller Registration Screen:
![sellerRegistrationScreen](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_V22_Graphical_Interface_with_JavaFX-Part-02/GraphicalApp/img/sellerRegistrationScreen.png)

***

## Department Registration Screen:
![departmentRegistrationScreen](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_V22_Graphical_Interface_with_JavaFX-Part-02/GraphicalApp/img/departmentRegistrationScreen.png)

***

## Backend Requirements Specification:

### 1. Database Configuration:

- Add the `MySQLConnector User Library` to the project;
- Establish a database named `store` using `MySQL Workbench`;
- In the project's root folder, create a file named `db.properties` containing the connection data:

#### db.properties File:

```SQL
user=developer
password=******
dburl=jdbc:mysql://localhost:3306/store
useSSL=false
```
***

### 2. Database Setup and Exception Handling:

#### 2.1. Create an SQL script to store data in the `store` database:

#### database.sql Script:

```SQL
-- Create table 'department' if it does not exist
CREATE TABLE IF NOT EXISTS department (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Name varchar(60) DEFAULT NULL,
  PRIMARY KEY (Id)
);

-- Create table 'seller' if it does not exist
CREATE TABLE IF NOT EXISTS seller (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Name varchar(60) NOT NULL,
  Email varchar(100) NOT NULL,
  BirthDate datetime NOT NULL,
  BaseSalary double NOT NULL,
  DepartmentId int(11) NOT NULL,
  PRIMARY KEY (Id),
  FOREIGN KEY (DepartmentId) REFERENCES department (Id)
);

-- Update or insert data into 'department' table
INSERT INTO department (Id, Name) VALUES 
  (1, 'Computers'),
  (2, 'Electronics'),
  (3, 'Fashion'),
  (4, 'Books'),
  (5, 'Beauty'),
  (6, 'Shoes')
ON DUPLICATE KEY UPDATE
  Name = VALUES(Name);

-- Update or insert data into 'seller' table
INSERT INTO seller (Id, Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES 
  (1, 'Balthazar de Bigode','balthazar@mail.com','2020-03-10 00:00:00',1000,1),
  (2, 'Ophelia Birrenta','ophelia@mail.com','2020-11-10 00:00:00',3500,2),
  (3, 'Ludovico Crispim','ludovico@mail.com','1989-10-30 00:00:00',2200,1),
  (4, 'Sebastiana Frederica','sebastiana@mail.com','1993-11-30 00:00:00',3000,4),
  (5, 'Belizario Epaminondas','belizario@mail.com','2000-01-09 00:00:00',4000,3),
  (6, 'Gumercindo Abigail','gumercindo@mail.com','1997-03-04 00:00:00',3000,2),
  (7, 'Zuleica Serafina','zuleica@mail.com','1985-02-10 00:00:00',3000,4),
  (8, 'Vitalino Simplicio','vitalino@mail.com','1995-10-23 00:00:00',4000,3)
ON DUPLICATE KEY UPDATE
  Name = VALUES(Name),
  Email = VALUES(Email),
  BirthDate = VALUES(BirthDate),
  BaseSalary = VALUES(BaseSalary),
  DepartmentId = VALUES(DepartmentId);
```

#### 2.2. Requirements for `DB` Class:

- **Class Declaration:**
  - Create the `DB` class to manage database connections and resource closures;
  - Ensure the class provides static methods to handle these operations:

```java
public class DB {
    private static Connection conn = null;
```

- **Connection Management:**
  - Implement the `getConnection` method to establish and return a database connection;
  - Ensure the connection is established only if it does not already exist;
  - Load database properties from a file and handle SQL exceptions:

```java
public static Connection getConnection() {
    if (conn == null) {
        try {
            Properties properties = loadProperties();
            String url = properties.getProperty("dburl");
            conn = DriverManager.getConnection(url, properties);
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
    return conn;
}
```

- **Close Connection Method:**
  - Implement the `closeConnection` method to close the database connection if it exists;
  - Handle SQL exceptions and ensure the connection is closed properly:

```java
public static void closeConnection() {
    if (conn != null) {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
```

- **Load Properties Method:**
  - Implement the `loadProperties` method to load database configuration from a properties file;
  - Handle I/O exceptions and ensure the properties are loaded correctly:

```java
private static Properties loadProperties() {
    try (FileInputStream fs = new FileInputStream("db.properties")) {
        Properties properties = new Properties();
        properties.load(fs);
        return properties;
    } catch (IOException e) {
        throw new DbException(e.getMessage());
    }
}
```

- **Close Statement Method:**
  - Implement the `closeStatement` method to close a `Statement` object if it exists;
  - Handle SQL exceptions and ensure the statement is closed properly:

```java
public static void closeStatement(Statement statement) {
    if (statement != null) {
        try {
            statement.close();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
```

- **Close Prepared Statement Method:**
  - Implement the `closePreparedStatement` method to close a `PreparedStatement` object if it exists;
  - Handle SQL exceptions and ensure the prepared statement is closed properly:

```java
public static void closePreparedStatement(PreparedStatement preparedStatement) {
    if (preparedStatement != null) {
        try {
            preparedStatement.close();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
```

- **Close Result Set Method:**
  - Implement the `closeResultSet` method to close a `ResultSet` object if it exists;
  - Handle SQL exceptions and ensure the result set is closed properly:

```java
public static void closeResultSet(ResultSet resultSet) {
    if (resultSet != null) {
        try {
            resultSet.close();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
```
#### 2.3. Requirements for `DbException` Class:

- **Class Declaration:**
  - Create the `DbException` class extending `RuntimeException` to handle database-related exceptions;
  - Ensure the class provides a custom exception for database operations:

```java
public class DbException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
```

- **Constructor Implementation:**
  - Implement a constructor that accepts a `String` message as an argument;
  - Call the superclass constructor with the provided message to initialise the exception:

```java
public DbException(String message) {
    super(message);
}
```
#### 2.4. Requirements for `DbException` Class:

- **Class Declaration:**
  - Create the `DbException` class extending `RuntimeException` to handle database-related exceptions;
  - Ensure the class provides a custom exception for database operations:

```java
public class DbException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
```

- **Constructor Implementation:**
  - Implement a constructor that accepts a `String` message as an argument;
  - Call the superclass constructor with the provided message to initialise the exception:

```java
public DbException(String message) {
    super(message);
}
```

***

### 3. Entities Classes:

- Create the `Seller` and `Department` classes;

![Seller and Department Entities](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_V22_Graphical_Interface_with_JavaFX-Part-02/GraphicalApp/img/seller-department-entities.png)

#### Entities classes checklist:

- Attributes;
- Constructors;
- Getters/Setters;
- hashCode and equals;
- toString;
- Implements Serializable.

***

### 4. DAO Pattern (Data Access Object):

![DaoFactory](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_V22_Graphical_Interface_with_JavaFX-Part-02/GraphicalApp/img/daoFactory.png)

#### 4.1. Requirements for `DepartmentDao` and `SellerDao` Interfaces:

- **Interface Declaration:**
    - Create the `DepartmentDao` and `SellerDao` interfaces that extend the `DAO` pattern;
    - Ensure these interfaces provide the necessary methods for CRUD operations:

```java
import java.util.List;

public interface DAO<T> {
    void insert(T object);

    void update(T object);

    void deleteById(Integer id);

    T findById(Integer id);

    List<T> findAll();
}
```

- **Additional Method for `SellerDao`:**
    - Implement an additional method in `SellerDao` to find sellers by department:
    - Method Signature:

```java
List<Seller> findByDepartment(Department department);
```

#### 4.2. Requirements for `DaoFactory` Class:

- **Factory Creation:**
    - Create the `DaoFactory` class to instantiate DAO objects;
- **Methods for DAO Creation:**
    - Implement methods to create and return instances of `SellerDao` and `DepartmentDao`;
    - Ensure these methods establish the necessary database connections via `DB.getConnection()`:

```java
package com.souza.charles.model.dao;

import com.souza.charles.model.dao.impl.DepartmentDaoJDBC;
import com.souza.charles.model.dao.impl.SellerDaoJDBC;
import com.souza.charles.model.db.DB;

public class DaoFactory {

    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static DepartmentDao createDepartmentDao() {
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}
```

#### 4.3. Requirements for `SellerDaoJDBC` Class:

- **Class Declaration:**
    - Create the `SellerDaoJDBC` class implementing the `SellerDao` interface;
    - Ensure the class provides JDBC-based implementations for all methods declared in `SellerDao`:

```java
public class SellerDaoJDBC implements SellerDao {
    private Connection connection;

    public SellerDaoJDBC(Connection conn) {
        this.connection = conn;
    }
```

- **Insert Method:**
    - Implement the `insert` method to add a new `Seller` to the database;
    - Prepare and execute the SQL statement to insert seller details;
    - Handle the generation of the seller's ID and handle SQL exceptions:

```java

@Override
public void insert(Seller seller) {
    PreparedStatement preparedStatement = null;
    try {
        preparedStatement = connection.prepareStatement(
                "INSERT INTO seller "
                        + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                        + "VALUES "
                        + "(?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, seller.getName());
        preparedStatement.setString(2, seller.getEmail());
        preparedStatement.setDate(3, Date.valueOf(seller.getBirthDate()));
        preparedStatement.setDouble(4, seller.getBaseSalary());
        preparedStatement.setInt(5, seller.getDepartment().getId());

        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                seller.setId(id);
            }
            DB.closeResultSet(resultSet);
        } else {
            throw new DbException("Unexpected error! No rows affected!");
        }
    } catch (SQLException e) {
        throw new DbException(e.getMessage());
    } finally {
        DB.closePreparedStatement(preparedStatement);
        DB.closeStatement(preparedStatement);
    }
}
```

- **Update Method:**
    - Implement the `update` method to modify an existing `Seller` in the database;
    - Prepare and execute the SQL statement to update seller details;
    - Handle SQL exceptions and ensure the updated data is persisted:

```java

@Override
public void update(Seller seller) {
    PreparedStatement preparedStatement = null;
    try {
        preparedStatement = connection.prepareStatement(
                "UPDATE seller "
                        + "SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? "
                        + "WHERE Id = ?");

        preparedStatement.setString(1, seller.getName());
        preparedStatement.setString(2, seller.getEmail());
        preparedStatement.setDate(3, Date.valueOf(seller.getBirthDate()));
        preparedStatement.setDouble(4, seller.getBaseSalary());
        preparedStatement.setInt(5, seller.getDepartment().getId());
        preparedStatement.setInt(6, seller.getId());

        preparedStatement.executeUpdate();

    } catch (SQLException e) {
        throw new DbException(e.getMessage());
    } finally {
        DB.closePreparedStatement(preparedStatement);
        DB.closeStatement(preparedStatement);
    }
}
```

- **Delete Method:**
    - Implement the `deleteById` method to remove a `Seller` from the database by ID;
    - Prepare and execute the SQL statement to delete a seller;
    - Handle SQL exceptions and ensure the seller is deleted:

```java

@Override
public void deleteById(Integer id) {
    PreparedStatement preparedStatement = null;

    try {
        preparedStatement = connection.prepareStatement(
                "DELETE FROM seller "
                        + "WHERE Id = ?");

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();

    } catch (SQLException e) {
        throw new DbException(e.getMessage());
    } finally {
        DB.closePreparedStatement(preparedStatement);
        DB.closeStatement(preparedStatement);
    }
}
```

- **FindById Method:**
    - Implement the `findById` method to retrieve a `Seller` from the database by ID;
    - Prepare and execute the SQL statement to find a seller;
    - Handle SQL exceptions and map the result set to a `Seller` object:

```java

@Override
public Seller findById(Integer id) {
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
        preparedStatement = connection.prepareStatement(
                "SELECT seller.*,department.Name as DepName "
                        + "FROM seller INNER JOIN department "
                        + "ON seller.DepartmentId = department.Id "
                        + "WHERE seller.Id = ?");

        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            Department department = instantiateDepartment(resultSet);
            Seller seller = instatiateSeller(resultSet, department);
            return seller;
        }
        return null;
    } catch (SQLException e) {
        throw new DbException(e.getMessage());
    } finally {
        DB.closePreparedStatement(preparedStatement);
        DB.closeStatement(preparedStatement);
        DB.closeResultSet(resultSet);
    }
}
```

- **FindAll Method:**
    - Implement the `findAll` method to retrieve all `Sellers` from the database;
    - Prepare and execute the SQL statement to find all sellers;
    - Handle SQL exceptions and map the result set to a list of `Seller` objects:

```java

@Override
public List<Seller> findAll() {
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
        preparedStatement = connection.prepareStatement(
                "SELECT seller.*, department.Name as DepName "
                        + "FROM seller "
                        + "INNER JOIN department ON seller.DepartmentId = department.Id "
                        + "ORDER BY Name");

        resultSet = preparedStatement.executeQuery();

        List<Seller> sellerList = new ArrayList<>();
        Map<Integer, Department> mapDepartment = new HashMap<>();

        while (resultSet.next()) {
            Department depart = mapDepartment.get(resultSet.getInt("DepartmentId"));
            if (depart == null) {
                depart = instantiateDepartment(resultSet);
                mapDepartment.put(resultSet.getInt("DepartmentId"), depart);
            }
            Seller seller = instatiateSeller(resultSet, depart);
            sellerList.add(seller);
        }
        return sellerList;
    } catch (SQLException e) {
        throw new DbException(e.getMessage());
    } finally {
        DB.closePreparedStatement(preparedStatement);
        DB.closeStatement(preparedStatement);
        DB.closeResultSet(resultSet);
    }
}
```

- **FindByDepartment Method:**
    - Implement the `findByDepartment` method to retrieve all `Sellers` from the database by department;
    - Prepare and execute the SQL statement to find sellers by department;
    - Handle SQL exceptions and map the result set to a list of `Seller` objects:

```java

@Override
public List<Seller> findByDepartment(Department department) {
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
        preparedStatement = connection.prepareStatement(
                "SELECT seller.*, department.Name as DepName "
                        + "FROM seller "
                        + "INNER JOIN department ON seller.DepartmentId = department.Id "
                        + "WHERE DepartmentId = ? "
                        + "ORDER BY Name");

        preparedStatement.setInt(1, department.getId());
        resultSet = preparedStatement.executeQuery();

        List<Seller> sellerList = new ArrayList<>();
        Map<Integer, Department> mapDepartment = new HashMap<>();

        while (resultSet.next()) {
            Department depart = mapDepartment.get(resultSet.getInt("DepartmentId"));
            if (depart == null) {
                depart = instantiateDepartment(resultSet);
                mapDepartment.put(resultSet.getInt("DepartmentId"), depart);
            }
            Seller seller = instatiateSeller(resultSet, depart);
            sellerList.add(seller);
        }
        return sellerList;
    } catch (SQLException e) {
        throw new DbException(e.getMessage());
    } finally {
        DB.closePreparedStatement(preparedStatement);
        DB.closeStatement(preparedStatement);
        DB.closeResultSet(resultSet);
    }
}
```

- **Helper Methods:**
    - Implement helper methods to instantiate `Department` and `Seller` objects from the result set;
    - Ensure proper handling of SQL exceptions and closing of resources:

```java
private Department instantiateDepartment(ResultSet resultSet) throws SQLException {
    Department department = new Department();
    department.setId(resultSet.getInt("DepartmentId"));
    department.setName(resultSet.getString("DepName"));
    return department;
}

private Seller instatiateSeller(ResultSet resultSet, Department department) throws SQLException {
    Seller seller = new Seller();
    seller.setId(resultSet.getInt("Id"));
    seller.setName(resultSet.getString("Name"));
    seller.setEmail(resultSet.getString("Email"));
    seller.setBirthDate(resultSet.getDate("BirthDate").toLocalDate());
    seller.setBaseSalary(resultSet.getDouble("BaseSalary"));
    seller.setDepartment(department);
    return seller;
}
```

#### 4.4. Requirements for `DepartmentDaoJDBC` Class:

- **Class Declaration:**
    - Create the `DepartmentDaoJDBC` class implementing the `DepartmentDao` interface;
    - Ensure the class provides JDBC-based implementations for all methods declared in `DepartmentDao`:

```java
public class DepartmentDaoJDBC implements DepartmentDao {
    private Connection connection;

    public DepartmentDaoJDBC(Connection connection) {
        this.connection = connection;
    }
```

- **Insert Method:**
    - Implement the `insert` method to add a new `Department` to the database;
    - Prepare and execute the SQL statement to insert department details;
    - Handle the generation of the department's ID and handle SQL exceptions:

```java

@Override
public void insert(Department department) {
    PreparedStatement preparedStatement = null;
    try {
        preparedStatement = connection.prepareStatement(
                "INSERT INTO department (Name) "
                        + "VALUES\r\n" + "(?)",
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, department.getName());

        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                department.setId(id);
            }
            DB.closeResultSet(resultSet);
        } else {
            throw new DbException("Unexpected error! No rows affected!");
        }
    } catch (SQLException e) {
        throw new DbException(e.getMessage());
    } finally {
        DB.closePreparedStatement(preparedStatement);
        DB.closeStatement(preparedStatement);
    }
}
```

- **Update Method:**
    - Implement the `update` method to modify an existing `Department` in the database;
    - Prepare and execute the SQL statement to update department details;
    - Handle SQL exceptions and ensure the updated data is persisted:

```java

@Override
public void update(Department department) {
    PreparedStatement preparedStatement = null;
    try {
        preparedStatement = connection.prepareStatement(
                "UPDATE department "
                        + "SET Name = ? "
                        + "WHERE Id = ?");
        preparedStatement.setString(1, department.getName());
        preparedStatement.setInt(2, department.getId());
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        throw new DbException(e.getMessage());
    } finally {
        DB.closePreparedStatement(preparedStatement);
        DB.closeStatement(preparedStatement);
    }
}
```

- **Delete Method:**
    - Implement the `deleteById` method to remove a `Department` from the database by ID;
    - Prepare and execute the SQL statement to delete a department;
    - Handle SQL exceptions and ensure the department is deleted:

```java

@Override
public void deleteById(Integer id) {
    PreparedStatement preparedStatement = null;

    try {
        preparedStatement = connection.prepareStatement(
                "DELETE FROM department "
                        + "WHERE Id = ?");

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();

    } catch (SQLException e) {
        throw new DbException(e.getMessage());
    } finally {
        DB.closePreparedStatement(preparedStatement);
        DB.closeStatement(preparedStatement);
    }
}
```

- **FindById Method:**
    - Implement the `findById` method to retrieve a `Department` from the database by ID;
    - Prepare and execute the SQL statement to find a department;
    - Handle SQL exceptions and map the result set to a `Department` object:

```java

@Override
public Department findById(Integer id) {
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
        preparedStatement = connection.prepareStatement(
                "SELECT * "
                        + "FROM department "
                        + "WHERE Id = ?");
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            Department department = instantiateDepartment(resultSet);
            return department;
        }
        return null;
    } catch (SQLException e) {
        throw new DbException(e.getMessage());
    } finally {
        DB.closePreparedStatement(preparedStatement);
        DB.closeResultSet(resultSet);
    }
}
```

- **FindAll Method:**
    - Implement the `findAll` method to retrieve all `Departments` from the database;
    - Prepare and execute the SQL statement to find all departments;
    - Handle SQL exceptions and map the result set to a list of `Department` objects:

```java

@Override
public List<Department> findAll() {
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
        preparedStatement = connection.prepareStatement(
                "SELECT * "
                        + "FROM department "
                        + "ORDER BY Name");

        resultSet = preparedStatement.executeQuery();
        List<Department> departmentList = new ArrayList<>();
        while (resultSet.next()) {
            Department department = instantiateDepartment(resultSet);
            departmentList.add(department);
        }
        return departmentList;
    } catch (SQLException e) {
        throw new DbException(e.getMessage());
    } finally {
        DB.closePreparedStatement(preparedStatement);
        DB.closeResultSet(resultSet);
    }
}
```

- **Helper Method:**
    - Implement a helper method to instantiate a `Department` object from the result set;
    - Ensure proper handling of SQL exceptions and closing of resources:

```java
private Department instantiateDepartment(ResultSet resultSet) throws SQLException {
    Department department = new Department();
    department.setId(resultSet.getInt("Id"));
    department.setName(resultSet.getString("Name"));
    return department;
}
```

***

### 5. CRUD Operations Implementation:

#### 5.1. Requirements for `App` Class:

- **Class Declaration:**
  - Create the `App` class to test and demonstrate the CRUD operations for `Seller` and `Department` entities;
  - Use the main method as the entry point for executing the CRUD operations;

```java
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
```

- **Instantiate DAO Objects:**
  - Use the `DaoFactory` class to create instances of `SellerDao` and `DepartmentDao`;

```java
SellerDao sellerDao = DaoFactory.createSellerDao();
DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
```

#### 5.2. **findById -** Implement the search by `ID`:

#### ResultSet Table:

![ResultSet Table](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_V22_Graphical_Interface_with_JavaFX-Part-02/GraphicalApp/img/resultSet-table.png)

#### Associated Objects:

![Seller Associated Objects](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_V22_Graphical_Interface_with_JavaFX-Part-02/GraphicalApp/img/seller-associated-objects.png)

#### App Class:

```java
SellerDao sellerDao = DaoFactory.createSellerDao();
Seller seller = sellerDao.findById(3);
System.out.println(seller);

DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
Department department = departmentDao.findById(1);
System.out.println(department);
```

#### Seller SQL Query:

```SQL
SELECT seller.*, department.Name as DepName
FROM seller
INNER JOIN department ON seller.DepartmentId = department.Id
WHERE seller.Id = ?
```

#### Department SQL Query:

```SQL
SELECT * 
FROM department 
WHERE Id = ?
```

#### 5.3. **findByDepartment -** Implement the search by Department:

#### Associated Objects:

![Department Associated Objects](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_V22_Graphical_Interface_with_JavaFX-Part-02/GraphicalApp/img/department-associated-objects.png)

#### App Class:

```java
Department department = new Department(3, null);
List<Seller> listSeller = sellerDao.findByDepartment(department);
for(Seller s :listSeller){
        System.out.println(s);
}
```

#### Seller SQL Query:

```SQL
SELECT seller.*, department.Name as DepName
FROM seller
INNER JOIN department ON seller.DepartmentId = department.Id
WHERE DepartmentId = ?
ORDER BY Name
```

#### 5.4. **findAll -** Implement the search for `all` records:

#### App Class:

```java
listSeller =sellerDao.findAll();
for(Seller s :listSeller){
        System.out.println(s);
}

List<Department> listDepartment = departmentDao.findAll();
for(Department d :listDepartment){
        System.out.println(d);
}
```

#### Seller SQL Query:

```SQL
SELECT seller.*, department.Name as DepName
FROM seller
INNER JOIN department ON seller.DepartmentId = department.Id
ORDER BY Name
```

#### Department SQL Query:

```SQL
SELECT * 
FROM department 
ORDER BY Name
```

#### 5.5. **insert -** Implement the `insertion` of new records:

#### App Class:

```java
Seller newSeller = new Seller(null, "Bartholomeu Zacarias", "bartholomeu@mail.com", LocalDate.now(), 4000.0, department);
sellerDao.insert(newSeller);
System.out.println("Inserted! New Seller id = " + newSeller.getId());

Department newDepartment = new Department(null, "Toys");
departmentDao.insert(newDepartment);
System.out.println("Inserted! New Department Name = " + newDepartment.getName());
```

#### Seller SQL Query:

```SQL
INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId)
VALUES (?, ?, ?, ?, ?)
```

#### Department SQL Query:

```SQL
INSERT INTO department (Name)
VALUES (?)
```    

#### 5.6. **update -** Implement the `update` of existing records:

#### App Class:

```java
seller = sellerDao.findById(10);
if (seller != null) {
    Department department = new Department(1, null);
    seller.setName("Cassandra Filisbina");
    seller.setEmail("cassandra@mail.com");
    seller.setBirthDate(LocalDate.now());
    seller.setBaseSalary(2200.00);
    seller.setDepartment(department);
    sellerDao.update(seller);
    System.out.println("Update completed!");
} else {
    System.out.println("Seller not found with Id 10.");
}

department = departmentDao.findById(7);
if (department != null) {
    department.setName("Gifts");
    departmentDao.update(department);
    System.out.println("Update completed!");
} else {
    System.out.println("Department not found with Id 7.");
}
```

#### Seller SQL Query:

```SQL
UPDATE seller
SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ?
WHERE Id = ?
```

#### Department SQL Query:

```SQL
UPDATE department
SET Name = ?
WHERE Id = ?
```

#### 5.7. **delete -** Implement the `deletion` of records:

#### App Class:

```java
System.out.print("Enter the Seller Id for deleteById test: ");
int id = scanner.nextInt();
sellerDao.deleteById(id);
System.out.println("Delete completed!");

System.out.print("Enter the Department Id for deleteById test: ");
id = scanner.nextInt();
departmentDao.deleteById(id);
System.out.println("Delete completed!");
```

#### Seller SQL Query:

```SQL
DELETE FROM seller
WHERE Id = ?
```

#### Department SQL Query:

```SQL
DELETE FROM department
WHERE Id = ?
```

***

### 6. Requirements for DepartmentService Class:

- **Service Component:**
  - Define the class as a service component.
  
- **Dependency Injection:**
  - Use dependency injection for `DepartmentDao`.
  
- **Retrieve All Department Entities:**
  - **Method:** `findAll`
  - **Purpose:** Fetches all department entries from the database.
  - **Transaction Management:** Ensure the method runs within a read-only transaction.
  
- **Insert or Update Department Entity:**
  - **Method:** `saveOrUpdate`
  - **Purpose:** Saves or updates a department entity in the database.
  - **Transaction Management:** Ensure the method runs within a transactional context.
  - **Validation:** Checks for null values for `id`. Performs insert operation if `id` is null, otherwise, update operation.
  
- **Delete Department Entity:**
  - **Method:** `remove`
  - **Purpose:** Deletes a department entity by its identifier.
  - **Transaction Management:** Ensure the method runs within a transactional context.

***

### 7. Requirements for SellerService Class:

- **Service Component:**
  - Define the class as a service component.
  
- **Dependency Injection:**
  - Use dependency injection for `SellerDao`.
  
- **Retrieve All Seller Entities:**
  - **Method:** `findAll`
  - **Purpose:** Fetches all seller entries from the database.
  - **Transaction Management:** Ensure the method runs within a read-only transaction.
  
- **Insert or Update Seller Entity:**
  - **Method:** `saveOrUpdate`
  - **Purpose:** Saves or updates a seller entity in the database.
  - **Transaction Management:** Ensure the method runs within a transactional context.
  - **Validation:** Checks for null values for `id`. Performs insert operation if `id` is null, otherwise, update operation.
  
- **Delete Seller Entity:**
  - **Method:** `remove`
  - **Purpose:** Deletes a seller entity by its identifier.
  - **Transaction Management:** Ensure the method runs within a transactional context.

***

### 8. Requirements for ValidationException Class:

- **Error Map Initialisation:**
  - **Purpose:** Initialises an empty map to store field-specific error messages.
  - **Method:** `getErrors`
  - **Returns:** The map containing error messages.
  
- **Add Error Message:**
  - **Method:** `addError`
  - **Purpose:** Adds an error message for a specific field to the error map.
  - **Parameters:** `fieldName` (name of the field), `errorMessage` (error message associated with the field).

  ***
  
### 9. Requirements for DepartmentListController Class:

- **Controller Component:**
  - Define the class as a controller component.
  
- **Dependency Injection:**
  - Use dependency injection for `DepartmentService`.
  
- **FXML Annotations:**
  - Use `@FXML` annotations for all FXML components and methods.
  
- **Initialise Nodes:**
  - **Method:** `initializeNodes`
  - **Purpose:** Initialises the table columns and binds the height property of `tableViewDepartment` to the stage height.
  - **Components:**
    - `tableColumnId`: Binds to the `id` property of `Department`.
    - `tableColumnName`: Binds to the `name` property of `Department`.
  
- **Retrieve All Department Entities:**
  - **Method:** `updateTableView`
  - **Purpose:** Fetches all department entries from the database and populates `tableViewDepartment`.
  - **Exception Handling:** Throws `IllegalStateException` if `service` is null.
  
- **Create New Department Entity:**
  - **Method:** `onBtNewAction`
  - **Purpose:** Opens a dialog form to create a new department entity.
  - **Parameters:** `ActionEvent event`
  - **Helper Method:** `createDialogForm`
    - **Parameters:** `Department obj`, `String absoluteName`, `Stage parentStage`
    - **Purpose:** Loads the FXML file for the dialog form, sets the controller, and shows the dialog.
    - **Exception Handling:** Catches `IOException` and displays an alert.
  
- **Edit Existing Department Entity:**
  - **Method:** `initEditButtons`
  - **Purpose:** Adds edit buttons to the table for each department entity.
  - **Components:**
    - `tableColumnEDIT`: Contains the edit buttons.
  
- **Remove Department Entity:**
  - **Method:** `initRemoveButtons`
  - **Purpose:** Adds remove buttons to the table for each department entity.
  - **Components:**
    - `tableColumnREMOVE`: Contains the remove buttons.
  - **Helper Method:** `removeEntity`
    - **Parameters:** `Department obj`
    - **Purpose:** Deletes a department entity by its identifier.
    - **Exception Handling:** Catches `DbIntegrityException` and displays an alert.
  
- **Data Change Listener:**
  - **Method:** `onDataChanged`
  - **Purpose:** Updates the table view when data changes.
  - **Interface:** Implements `DataChangeListener`.

***

### 10. Requirements for DepartmentFormController Class:

- **Controller Component Annotation:**
    - Use the `@FXMLController` annotation to define the class as a JavaFX controller component.

- **Dependency Injection:**
    - Inject `DepartmentService` for service operations.

- **FXML Components:**
    - Annotate `txtId`, `txtName`, `labelErrorName`, `btSave`, `btCancel` with `@FXML`.

- **Initialise Nodes:**
    - **Method:** `initializeNodes`
    - **Purpose:** Initialises text field constraints and other components.

- **Set Department Entity:**
    - **Method:** `setDepartment`
    - **Parameters:** `Department entity`
    - **Purpose:** Sets the current department entity.

- **Set DepartmentService:**
    - **Method:** `setDepartmentService`
    - **Parameters:** `DepartmentService service`
    - **Purpose:** Sets the department service for the controller.

- **Subscribe Data Change Listener:**
    - **Method:** `subscribeDataChangeListener`
    - **Parameters:** `DataChangeListener listener`
    - **Purpose:** Subscribes a listener to data change events.

- **Save Department Entity:**
    - **Method:** `onBtSaveAction`
    - **Parameters:** `ActionEvent event`
    - **Purpose:** Saves or updates the department entity, and notifies data change listeners.
    - **Exception Handling:** Throws `ValidationException` and `DbException` with appropriate error messages.

- **Cancel Action:**
    - **Method:** `onBtCancelAction`
    - **Parameters:** `ActionEvent event`
    - **Purpose:** Closes the current stage without saving.

- **Get Form Data:**
    - **Method:** `getFormData`
    - **Purpose:** Retrieves and validates form data, and creates a `Department` object.
    - **Exception Handling:** Throws `ValidationException` if validation errors are found.

- **Update Form Data:**
    - **Method:** `updateFormData`
    - **Purpose:** Updates the form fields with data from the current department entity.

- **Set Error Messages:**
    - **Method:** `setErrorMessages`
    - **Parameters:** `Map<String, String> errors`
    - **Purpose:** Sets error messages on the form labels for invalid fields.
  
- **Notify Data Change Listeners:**
    - **Method:** `notifyDataChangeListeners`
    - **Purpose:** Notifies all subscribed listeners of data changes.
  
***


### 11. Requirements for SellerListController Class:

- **Controller Component Annotation:**
    - Use the `@FXMLController` annotation to define the class as a JavaFX controller component.

- **Dependency Injection:**
    - Inject `SellerService` for service operations.

- **FXML Components:**
    - Annotate `tableViewSeller`, `tableColumnId`, `tableColumnName`, `tableColumnEmail`, `tableColumnBirthDate`, `tableColumnBaseSalary`, `tableColumnEDIT`, `tableColumnREMOVE`, `btNew` with `@FXML`.

- **Initialise Nodes:**
    - **Method:** `initializeNodes`
    - **Purpose:** Initialises table columns and binds the height property of `tableViewSeller` to the stage height.
    - **Components:**
        - `tableColumnId`: Binds to the `id` property of `Seller`.
        - `tableColumnName`: Binds to the `name` property of `Seller`.
        - `tableColumnEmail`: Binds to the `email` property of `Seller`.
        - `tableColumnBirthDate`: Binds to the `birthDate` property of `Seller`.
        - `tableColumnBaseSalary`: Binds to the `baseSalary` property of `Seller`.

- **Retrieve All Seller Entities:**
    - **Method:** `updateTableView`
    - **Purpose:** Fetches all seller entries from the database and populates `tableViewSeller`.
    - **Exception Handling:** Throws `IllegalStateException` if `service` is null.

- **Create New Seller Entity:**
    - **Method:** `onBtNewAction`
    - **Purpose:** Opens a dialog form to create a new seller entity.
    - **Parameters:** `ActionEvent event`
    - **Helper Method:** `createDialogForm`
        - **Parameters:** `Seller obj`, `String absoluteName`, `Stage parentStage`
        - **Purpose:** Loads the FXML file for the dialog form, sets the controller, and shows the dialog.
        - **Exception Handling:** Catches `IOException` and displays an alert.

- **Edit Existing Seller Entity:**
    - **Method:** `initEditButtons`
    - **Purpose:** Adds edit buttons to the table for each seller entity.
    - **Components:**
        - `tableColumnEDIT`: Contains the edit buttons.

- **Remove Seller Entity:**
    - **Method:** `initRemoveButtons`
    - **Purpose:** Adds remove buttons to the table for each seller entity.
    - **Components:**
        - `tableColumnREMOVE`: Contains the remove buttons.
    - **Helper Method:** `removeEntity`
        - **Parameters:** `Seller obj`
        - **Purpose:** Deletes a seller entity by its identifier.
        - **Exception Handling:** Catches `DbIntegrityException` and displays an alert.

- **Data Change Listener:**
    - **Method:** `onDataChanged`
    - **Purpose:** Updates the table view when data changes.
    - **Interface:** Implements `DataChangeListener`.

***


### 12. Requirements for SellerFormController Class:

- **Controller Component Annotation:**
    - Use the `@FXMLController` annotation to define the class as a JavaFX controller component.

- **Dependency Injection:**
    - Inject `SellerService` and `DepartmentService` for service operations.

- **FXML Components:**
    - Annotate `txtId`, `txtName`, `txtEmail`, `dpBirthDate`, `txtBaseSalary`, `comboBoxDepartment`, `labelErrorName`, `labelErrorEmail`, `labelErrorBirthDate`, `labelErrorBaseSalary`, `btSave`, `btCancel` with `@FXML`.

- **Initialise Nodes:**
    - **Method:** `initializeNodes`
    - **Purpose:** Initialises text field constraints, date picker format, and combo box.

- **Set Seller Entity:**
    - **Method:** `setSeller`
    - **Parameters:** `Seller entity`
    - **Purpose:** Sets the current seller entity.

- **Set Services:**
    - **Method:** `setServices`
    - **Parameters:** `SellerService service`, `DepartmentService departmentService`
    - **Purpose:** Sets the seller and department services for the controller.

- **Subscribe Data Change Listener:**
    - **Method:** `subscribeDataChangeListener`
    - **Parameters:** `DataChangeListener listener`
    - **Purpose:** Subscribes a listener to data change events.

- **Save Seller Entity:**
    - **Method:** `onBtSaveAction`
    - **Parameters:** `ActionEvent event`
    - **Purpose:** Saves or updates the seller entity, and notifies data change listeners.
    - **Exception Handling:** Throws `ValidationException` and `DbException` with appropriate error messages.

- **Cancel Action:**
    - **Method:** `onBtCancelAction`
    - **Parameters:** `ActionEvent event`
    - **Purpose:** Closes the current stage without saving.

- **Get Form Data:**
    - **Method:** `getFormData`
    - **Purpose:** Retrieves and validates form data, and creates a `Seller` object.
    - **Exception Handling:** Throws `ValidationException` if validation errors are found.

- **Update Form Data:**
    - **Method:** `updateFormData`
    - **Purpose:** Updates the form fields with data from the current seller entity.

- **Load Associated Objects:**
    - **Method:** `loadAssociatedObjects`
    - **Purpose:** Loads associated departments into the combo box.
    - **Exception Handling:** Throws `IllegalStateException` if `departmentService` is null.

- **Set Error Messages:**
    - **Method:** `setErrorMessages`
    - **Parameters:** `Map<String, String> errors`
    - **Purpose:** Sets error messages on the form labels for invalid fields.

- **Notify Data Change Listeners:**
    - **Method:** `notifyDataChangeListeners`
    - **Purpose:** Notifies all subscribed listeners of data changes.

- **Initialise ComboBox Department:**
    - **Method:** `initializeComboBoxDepartment`
    - **Purpose:** Initialises the combo box with departments and sets the cell factory for displaying department names.

***

### 13. Requirements for MainViewController Class:

- **Controller Component Annotation:**
    - Use the `@FXMLController` annotation to define the class as a JavaFX controller component.

- **FXML Components:**
    - Annotate `menuItemSeller`, `menuItemDepartment`, `menuItemAbout` with `@FXML`.

- **Initialise Method:**
    - **Method:** `initialize`
    - **Purpose:** Initialises the controller. Implements the `Initializable` interface.
    - **Parameters:** `URL uri`, `ResourceBundle rb`

- **Menu Item Seller Action:**
    - **Method:** `onMenuItemSellerAction`
    - **Purpose:** Loads the seller list view and initialises the `SellerListController`.
    - **Helper Method:** `loadView`
        - **Parameters:** `String absoluteName`, `Consumer<T> initializingAction`
        - **Purpose:** Loads the FXML file, sets the controller, and shows the view.
        - **Exception Handling:** Catches `IOException` and displays an alert.

- **Menu Item Department Action:**
    - **Method:** `onMenuItemDepartmentAction`
    - **Purpose:** Loads the department list view and initialises the `DepartmentListController`.
    - **Helper Method:** `loadView`
        - **Parameters:** `String absoluteName`, `Consumer<T> initializingAction`
        - **Purpose:** Loads the FXML file, sets the controller, and shows the view.
        - **Exception Handling:** Catches `IOException` and displays an alert.

- **Menu Item About Action:**
    - **Method:** `onMenuItemAboutAction`
    - **Purpose:** Loads the about view.
    - **Helper Method:** `loadView`
        - **Parameters:** `String absoluteName`, `Consumer<T> initializingAction`
        - **Purpose:** Loads the FXML file and shows the view.
        - **Exception Handling:** Catches `IOException` and displays an alert.

- **Load View:**
    - **Method:** `loadView`
    - **Purpose:** Loads a specified FXML view, replaces the content of the main VBox, and executes an initialising action.
    - **Parameters:** `String absoluteName`, `Consumer<T> initializingAction`
    - **Exception Handling:** Catches `IOException` and displays an alert.

***

## Frontend Requirements Specification:


### 1. Requirements for Main Class:

- **JavaFX Application:**
    - Extend `javafx.application.Application` to create a JavaFX application.

- **FXML Loading:**
    - **Method:** `start`
    - **Purpose:** Loads the main FXML file, sets up the primary stage, and displays the main scene.
    - **Exception Handling:** Catches `IOException` and prints the stack trace if the FXML file cannot be loaded.

- **Main Scene:**
    - **Field:** `private static Scene mainScene`
    - **Purpose:** Stores the main scene of the application.

- **Get Main Scene:**
    - **Method:** `getMainScene`
    - **Returns:** The main scene.
  
- **Launch Application:**
    - **Method:** `main`
    - **Purpose:** Launches the JavaFX application.

### 1.1. Requirements for Main.fxml:

- **XML Version Declaration:**
    - Declare the XML version and encoding at the beginning of the file.

- **Import Statements:**
    - Import necessary JavaFX classes (`Menu`, `MenuBar`, `MenuItem`, `ScrollPane`, `VBox`).

- **FXML Root Element:**
    - **Element:** `<ScrollPane>`
    - **Attributes:**
        - `maxHeight`, `maxWidth`, `minHeight`, `minWidth`, `prefHeight`, `prefWidth`
        - `xmlns`: XML namespace declaration.
        - `xmlns:fx`: FXML namespace declaration.
        - `fx:controller`: Specify the controller class (`com.souza.charles.graphicalapp.controller.MainViewController`).

- **VBox Layout:**
    - **Element:** `<VBox>`
    - **Attributes:** `prefHeight`, `prefWidth`
    - **Child Element:** `<MenuBar>`
        - **Child Element:** `<Menu>`
            - **Attributes:** `mnemonicParsing`, `text`
            - **Child Elements:** `<MenuItem>`
                - **Attributes:** `fx:id`, `mnemonicParsing`, `onAction`, `text`
        - **Menu:** Registration
            - **MenuItem:** Seller
            - **MenuItem:** Department
        - **Menu:** Help
            - **MenuItem:** About

***

### 2. Requirements for Alerts Class:

- **Show Alert Message:**
    - **Method:** `showAlert`
    - **Parameters:** `String title`, `String header`, `String content`, `Alert.AlertType type`
    - **Purpose:** Displays an alert message with the given title, header, content, and alert type.

- **Show Confirmation Dialog:**
    - **Method:** `showConfirmation`
    - **Parameters:** `String title`, `String content`
    - **Purpose:** Displays a confirmation dialog with the given title and content, and returns the user's response as an `Optional<ButtonType>`.

***

### 3. Requirements for Constraints Class:

- **Set TextField to Accept Only Integer Values:**
    - **Method:** `setTextFieldInteger`
    - **Parameters:** `TextField txt`
    - **Purpose:** Restricts the input of the given text field to accept only integer values.

- **Set Maximum Length for TextField:**
    - **Method:** `setTextFieldMaxLength`
    - **Parameters:** `TextField txt`, `int max`
    - **Purpose:** Sets a maximum length for the input of the given text field.

- **Set TextField to Accept Only Double Values:**
    - **Method:** `setTextFieldDouble`
    - **Parameters:** `TextField txt`
    - **Purpose:** Restricts the input of the given text field to accept only double values.

***


### 4. Requirements for Utils Class:

- **Package Declaration:**
    - Include the `package com.souza.charles.graphicalapp.view.utils` declaration at the beginning.

- **Class Documentation:**
    - Provide a class-level Javadoc comment including course title, instructor name, project author, and date.

- **Import Statements:**
    - Import the necessary JavaFX and utility classes such as `javafx.event.ActionEvent`, `javafx.scene.Node`, `javafx.scene.control.DatePicker`, `javafx.scene.control.TableCell`, `javafx.scene.control.TableColumn`, `javafx.stage.Stage`, `javafx.util.StringConverter`, and `javafx.util.converter.LocalDateStringConverter`.
    - Import Java utility classes like `java.text.SimpleDateFormat`, `java.time.LocalDate`, `java.time.format.DateTimeFormatter`, `java.util.Date`, and `java.util.Locale`.

- **Method: currentStage**
    - **Purpose:** Retrieves the current stage from an `ActionEvent`.
    - **Parameter:** `ActionEvent event`
    - **Return Type:** `Stage`
    - **Implementation:** Cast the event's source to a `Node` and obtain its scene's window as a `Stage`.

- **Method: tryParseToInt**
    - **Purpose:** Attempts to parse a `String` to an `Integer`.
    - **Parameter:** `String str`
    - **Return Type:** `Integer`
    - **Implementation:** Use `Integer.parseInt` within a try-catch block to handle `NumberFormatException`.

- **Method: tryParseToDouble**
    - **Purpose:** Attempts to parse a `String` to a `Double`.
    - **Parameter:** `String str`
    - **Return Type:** `Double`
    - **Implementation:** Use `Double.parseDouble` within a try-catch block to handle `NumberFormatException`.

- **Method: formatTableColumnDate**
    - **Purpose:** Formats a `TableColumn` containing `Date` values with a specified date format.
    - **Parameter:** `TableColumn<T, Date> tableColumn`, `String format`
    - **Generics:** `<T>`
    - **Implementation:** Use `SimpleDateFormat` to format `Date` objects in a `TableCell`.

- **Method: formatTableColumnDouble**
    - **Purpose:** Formats a `TableColumn` containing `Double` values with a specified number of decimal places.
    - **Parameter:** `TableColumn<T, Double> tableColumn`, `int decimalPlaces`
    - **Generics:** `<T>`
    - **Implementation:** Use `String.format` to format `Double` values in a `TableCell` with the specified decimal places.

- **Method: formatTableColumnLocalDate**
    - **Purpose:** Formats a `TableColumn` containing `LocalDate` values with a specified date format.
    - **Parameter:** `TableColumn<T, LocalDate> tableColumn`, `String format`
    - **Generics:** `<T>`
    - **Implementation:** Use `LocalDateStringConverter` to format `LocalDate` objects in a `TableCell`.

- **Method: formatDatePicker**
    - **Purpose:** Sets a `StringConverter` to format and parse dates in a `DatePicker`.
    - **Parameter:** `DatePicker datePicker`, `String format`
    - **Implementation:** Use `DateTimeFormatter` to format and parse `LocalDate` values within the `DatePicker`.


***

### 5. Requirements for About.fxml:

- **FXML Markup:**
    - Use FXML to structure the UI in a hierarchical manner, leveraging XML's readability.
    - Define `VBox` as the root container with defined `prefHeight` and `prefWidth`.

- **Label Component:**
    - Create a `Label` with text "About".
    - Apply `System Bold` font with size `18.0`.
    - Set padding for the label with `Insets` of `10.0` at the top and bottom, and `20.0` on the left.

- **Second Label Component:**
    - Create a second `Label` to describe JavaFX.
    - Apply padding with `Insets` of `20.0` on the left side.

***

### 6. Requirements for DepartmentForm.fxml:

- **FXML Markup:**
    - Use FXML to define the structure, employing `AnchorPane` as the root container with specified `prefHeight` and `prefWidth`.
    - Structure the inner layout using `GridPane` with specified layout constraints.

- **TextFields:**
    - Create a non-editable `TextField` for `Id` with `fx:id="txtId"`.
    - Create a `TextField` for `Name` with `fx:id="txtName"`.
    - Use the `fx:id="labelErrorName"` for the error label with red text fill.

- **Buttons:**
    - Add `Save` and `Cancel` buttons within an `HBox` container.
    - Configure actions with `onAction` attributes linked to methods `onBtSaveAction` and `onBtCancelAction`.

***

### 7. Requirements for DepartmentList.fxml:

- **FXML Markup:**
    - Use FXML to structure the UI with `VBox` as the root container, specifying `prefHeight` and `prefWidth`.

- **Label Component:**
    - Create a `Label` with text "Department Registration".
    - Apply `System Bold` font with size `14.0`.
    - Set padding with `Insets` of `5.0` at the top and left.

- **Toolbar and Button:**
    - Add a `ToolBar` component with a `Button` labelled "New" and `fx:id="btNew"`.
    - Link the button action to `onBtNewAction`.

- **TableView:**
    - Create a `TableView` with `fx:id="tableViewDepartment"` containing `TableColumn`s for `Id`, `Name`, `EDIT`, and `REMOVE`.
    - Specify `prefWidth` for each column.

***


### 8. Requirements for SellerForm.fxml:

- **FXML Markup:**
    - Use FXML to structure the user interface with `AnchorPane` as the root container, specifying `prefHeight` and `prefWidth`.

- **GridPane Layout:**
    - Structure the inner layout using `GridPane` with defined `columnConstraints` and `rowConstraints`.

- **Label Components:**
    - Create `Label`s for "Id", "Name", "Email", "Birth Date", "Base Salary", and "Department".
    - Place labels at respective `GridPane.rowIndex` to align with input fields.

- **TextFields:**
    - Create a non-editable `TextField` for `Id` with `fx:id="txtId"`.
    - Create `TextField`s for `Name`, `Email`, and `Base Salary` with respective `fx:id`s.

- **DatePicker:**
    - Add a `DatePicker` for `Birth Date` with `fx:id="dpBirthDate"`.

- **ComboBox:**
    - Add a `ComboBox` for `Department` with `fx:id="comboBoxDepartment"` and `prefWidth="150.0"`.

- **Error Labels:**
    - Create error `Label`s with red text fill for validation messages, identified by respective `fx:id`s.

- **Buttons:**
    - Add `Save` and `Cancel` buttons within an `HBox` container.
    - Configure button actions with `onAction` attributes linked to methods `onBtSaveAction` and `onBtCancelAction`.

***

### 9. Requirements for SellerList.fxml:

- **FXML Markup:**
    - Use FXML to structure the user interface with `VBox` as the root container, specifying `prefHeight` and `prefWidth`.

- **Label Component:**
    - Create a `Label` with text "Seller Registration".
    - Apply `System Bold` font with size `14.0`.
    - Set padding for the label with `Insets` of `5.0` at the top and left.

- **ToolBar and Button:**
    - Add a `ToolBar` component with a `Button` labelled "New" and `fx:id="btNew"`.
    - Link the button action to `onBtNewAction`.

- **TableView:**
    - Create a `TableView` with `fx:id="tableViewSeller"` containing `TableColumn`s for `Id`, `Name`, `Email`, `Birth Date`, `Base Salary`, `EDIT`, and `REMOVE`.
    - Specify `prefWidth` for each column.

***

### 10. Requirements for module-info.java:

- **Module Declaration:**
    - Declare the module with the name `com.souza.charles.graphicalapp`.

- **Required Modules:**
    - **JavaFX Controls:** Use `requires javafx.controls;`.
    - **JavaFX FXML:** Use `requires javafx.fxml;`.
    - **Java SQL:** Use `requires java.sql;`.

- **Opened Packages:**
    - **Controller Package:** Open `com.souza.charles.graphicalapp.controller` to `javafx.fxml` using `opens com.souza.charles.graphicalapp.controller to javafx.fxml;`.
    - **Model Entities Package:** Open `com.souza.charles.graphicalapp.model.entities` to `javafx.fxml` using `opens com.souza.charles.graphicalapp.model.entities to javafx.fxml;`.
    - **View Package:** Open `com.souza.charles.graphicalapp.view` to `javafx.fxml` using `opens com.souza.charles.graphicalapp.view to javafx.fxml;`.

- **Exported Packages:**
    - **Controller Package:** Export `com.souza.charles.graphicalapp.controller` using `exports com.souza.charles.graphicalapp.controller;`.
    - **Model DAO Package:** Export `com.souza.charles.graphicalapp.model.dao` using `exports com.souza.charles.graphicalapp.model.dao;`.
    - **Model DB Package:** Export `com.souza.charles.graphicalapp.model.db` using `exports com.souza.charles.graphicalapp.model.db;`.
    - **Model Entities Package:** Export `com.souza.charles.graphicalapp.model.entities` using `exports com.souza.charles.graphicalapp.model.entities;`.
    - **Model Exceptions Package:** Export `com.souza.charles.graphicalapp.model.exceptions` using `exports com.souza.charles.graphicalapp.model.exceptions;`.
    - **Model Services Package:** Export `com.souza.charles.graphicalapp.model.services` using `exports com.souza.charles.graphicalapp.model.services;`.
    - **View Package:** Export `com.souza.charles.graphicalapp.view` using `exports com.souza.charles.graphicalapp.view;`.
