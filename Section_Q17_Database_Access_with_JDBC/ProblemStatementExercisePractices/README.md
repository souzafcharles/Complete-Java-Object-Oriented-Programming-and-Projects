# Problem Statement Exercise - DAO Pattern (Data Access Object)

**Instructions**: Develop a Java application that connects to a database using `JDBC` and interfaces following the
`DAO pattern`, featuring entity classes for `Seller` and `Department`. The target database is `store`.

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

### 2. Database Table Creation:

- Create an SQL script to store data in the `store` database.

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

### 4. DAO Pattern (Data Access Object):

- Create the `DepartmentDao` and `SellerDao` interfaces extends the `DAO` pattern:
````java
import java.util.List;

public interface DAO<T> {
    void insert(T object);
    void update(T object);
    void deleteById(Integer id);
    T findById(Integer id);
    List<T> findAll();
}
````
- Implement the classes `SellerDaoJDBC` and `DepartmentDaoJDBC`;
- Create the `DaoFactory` to instantiate DAO objects.

![DaoFactory](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_Q17_Database_Access_with_JDBC/ProblemStatementExercisePractices/img/daoFactory.png)

### 5. CRUD Operations Implementation:

#### 5.1 **findById -** Implement the search by `ID`:

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

#### ResultSet Table:

![ResultSet Table](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_Q17_Database_Access_with_JDBC/ProblemStatementExercisePractices/img/resultSet-table.png)

#### Associated Objects:

![Seller Associated Objects](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_Q17_Database_Access_with_JDBC/ProblemStatementExercisePractices/img/seller-associated-objects.png)

#### 5.1.1 **Reusing Instantiation -** Create methods to instantiate `Seller` and `Department` objects from a
`ResultSet`:

##### SellerDaoJDBC Class:

```java
private Seller instantiateSeller(ResultSet resultSet, Department department) throws SQLException {
    Seller seller = new Seller();
    seller.setId(resultSet.getInt("Id"));
    seller.setName(resultSet.getString("Name"));
    seller.setEmail(resultSet.getString("Email"));
    seller.setBaseSalary(resultSet.getDouble("BaseSalary"));
    seller.setBirthDate(resultSet.getDate("BirthDate"));
    seller.setDepartment(department);
    return seller;
}

private Department instantiateDepartment(ResultSet resultSet) throws SQLException {
    Department department = new Department();
    department.setId(resultSet.getInt("DepartmentId"));
    depepartment.setName(resultSet.getString("DepName"));
    return department;
}
```

##### DepartmentDaoJDBC Class:

```java
private Department instantiateDepartment(ResultSet resultSet) throws SQLException {
    department = new Department();
    department.setId(resultSet.getInt("Id"));
    department.setName(resultSet.getString("Name"));
    return department;
}
```

#### 5.2 **findByDepartment -** Implement the search by Department:

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

#### Associated Objects:

![Department Associated Objects](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_Q17_Database_Access_with_JDBC/ProblemStatementExercisePractices/img/department-associated-objects.png)

#### 5.3 **findAll -** Implement the search for `all` records:

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

#### 5.4 **insert -** Implement the `insertion` of new records:

#### App Class:

```java
Seller newSeller = new Seller(null, "Bartholomeu Zacarias", "bartholomeu@mai.com", new Date(), 4000.0, department);
sellerDao.insert(newSeller);
System.out.println("Inserted! New id = " + newSeller.getId());

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

#### 5.5 **update -** Implement the `update` of existing records:

#### App Class:

```java
seller = sellerDao.findById(10);

department = new Department(1, null);
seller.setName("Cassandra Filisbina");
seller.setEmail("cassandra@mail.com");
seller.setBirthDate(new Date());
        seller.setBaseSalary(2200.00);
seller.setDepartment(department);
sellerDao.update(seller);
System.out.println("Update completed!");

department = departmentDao.findById(7);
department.setName("Gifts");
departmentDao.update(department);
System.out.println("Update completed!");
```

#### Seller SQL Query:

```SQL
UPDATE seller
SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ?
WHERE Id = ?
```

#### Department SQL Query

```SQL
UPDATE department
SET Name = ?
WHERE Id = ?
WHERE Id = ?
````

#### 5.6 **delete -** Implement the `deletion` of records:

#### App Class:

```java
System.out.println("Enter the Seller's Id for deleteById test: ");

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