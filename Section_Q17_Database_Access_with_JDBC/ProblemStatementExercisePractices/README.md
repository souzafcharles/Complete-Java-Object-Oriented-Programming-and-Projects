# Problem Statement Exercise - DAO Pattern (Data Access Object)

**Instructions**: Develop a Java application that connects to a database using `JDBC` and interfaces following the `DAO pattern`. The application should include entity classes for `Seller` and `Department`, and the target database should be named `store`.

***

## Steps to Follow:

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

![Seller and Department Entities](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_Q17_Database_Access_with_JDBC/ProblemStatementExercisePractices/img/seller-department-entities.png)

#### Entities classes checklist:

- Attributes;
- Constructors;
- Getters/Setters;
- hashCode and equals;
- toString;
- Implements Serializable.

***

### 4. DAO Pattern (Data Access Object):

![DaoFactory](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_Q17_Database_Access_with_JDBC/ProblemStatementExercisePractices/img/daoFactory.png)

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

![ResultSet Table](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_Q17_Database_Access_with_JDBC/ProblemStatementExercisePractices/img/resultSet-table.png)

#### Associated Objects:

![Seller Associated Objects](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_Q17_Database_Access_with_JDBC/ProblemStatementExercisePractices/img/seller-associated-objects.png)

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

![Department Associated Objects](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_Q17_Database_Access_with_JDBC/ProblemStatementExercisePractices/img/department-associated-objects.png)

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
