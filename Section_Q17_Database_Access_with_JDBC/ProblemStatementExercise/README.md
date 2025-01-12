# Problem Statement Exercise 01

**Instructions**: Develop a Java application that connects to a database using `JDBC` and interfaces following the `DAO pattern`, featuring entity classes for `Seller` and `Department`. The target database is `coursejdbc`.

## Steps to Follow:

### 1. Database Configuration:
- Add the `MySQLConnector User Library` to the project;
- Establish a database named `coursejdbc` using `MySQL Workbench`;
- In the project's root folder, create a file named `db.properties` containing the connection data: 

#### db.properties File:

```sql
user=developer
password=1234567
dburl=jdbc:mysql://localhost:3306/coursejdbc
useSSL=false
```

### 2. Database Table Creation: 
- Create an SQL script to store data in the `coursejdbc` database.

#### database.sql Script:

```sql
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

![Seller Entities](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_Q17_Database_Access_with_JDBC/ProblemStatementExercise/seller-entities.png)

#### Entities classes checklist:
- Attributes;
- Constructors;
- Getters/Setters;
- hashCode and equals;
- toString;
- Implements Serializable.


### 4. DAO Pattern (Data Access Object):
   - Create the `DepartmentDao` and `SellerDao` interfaces following the DAO pattern.
   - Implement the classes `SellerDaoJDBC` and `DepartmentDaoJDBC`.
   - Create the `DaoFactory` to instantiate DAO objects.

### 5. CRUD Operations Implementation:
- **findById:** Implement the search by `ID`:

```sql
SELECT seller.*, department.Name as DepName
FROM seller
INNER JOIN department ON seller.DepartmentId = department.Id
WHERE seller.Id = ?
```
     
- **Reusing Instantiation:** Create methods to instantiate `Seller` and `Department` objects from a `ResultSet`:

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
	dep.setId(resultSet.getInt("DepartmentId"));
	dep.setName(resultSet.getString("DepName"));
	return department;
}
```

- **findByDepartment:** Implement the search by Department:

```sql
SELECT seller.*, department.Name as DepName
FROM seller
INNER JOIN department ON seller.DepartmentId = department.Id
WHERE DepartmentId = ?
ORDER BY Name
```
#### ResultSet Table:
![ResultSet Table](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_Q17_Database_Access_with_JDBC/ProblemStatementExercise/resultSet-table.png)
#### Associated Objects: 
![Department Associated Objects](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_Q17_Database_Access_with_JDBC/ProblemStatementExercise/department-associated-objects.png)

- **findAll:** Implement the search for `all` records:

```sql
SELECT seller.*, department.Name as DepName
FROM seller
INNER JOIN department ON seller.DepartmentId = department.Id
ORDER BY Name
```
     
- **insert:** Implement the `insertion` of new records:

```sql
INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId)
VALUES (?, ?, ?, ?, ?)
```
     
- **update:** Implement the `update` of existing records:

```sql
UPDATE seller
SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ?
WHERE Id = ?
```
     
- **delete:** Implement the `deletion` of records:

```sql
DELETE FROM seller
WHERE Id = ?
```

### 4. Testing the Implementations:
- Ensure all implemented operations are thoroughly tested.

### 5. **DepartmentDao Implementation Checklist:**
- DepartmentDaoJDBC
- DaoFactory