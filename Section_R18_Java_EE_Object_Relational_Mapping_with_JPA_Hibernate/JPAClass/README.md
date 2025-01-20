# Problem Statement Example JPA/Hibernate
***
## Instructions:
Develop a Java application that connects to a database using `JPA/Hibernate` and `Maven` for build and dependency management. The application should include an entity class for `Person`. The target database is `jpaclass`, which can be accessed through `phpMyAdmin`.
## Steps to Follow:

### 1. Database Configuration:
- Open `Xampp`;
- Start the `Apache` and `MySQL` services;
- Access `phpMyAdmin`;
- Create a new empty database MySQL named `jpaclass`;
***
### 2. Creating and Configurating a new Maven Project:
- Enter the following details:
- `Group Id`: com.souza.charles
- `Artifact Id`: JPAClass
- Update the project's Maven to the current `LTS Java version`:
  - Edit the `pom.xml` file.
  - Include the following content:
  ```xml
  <properties>
    <maven.compiler.source>21</maven.compiler.source>
    <maven.compiler.target>21</maven.compiler.target>
  </properties>
    ```
- Incorporate the required Maven dependencies:
```xml
<dependencies>
    <!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>6.6.5.Final</version>
        <type>pom</type>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-entitymanager -->
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-entitymanager</artifactId>
        <version>5.6.15.Final</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.33</version>
    </dependency>
</dependencies>
```
***
### 3. Configure JPA in the Project Using the persistence.xml File:
- Create a `"META-INF"` folder inside the `"resources"` folder.
- Inside the META-INF folder, create a file named `"persistence.xml"`.
- Content of the persistence.xml file:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd" version="2.1">
    <persistence-unit name="example-jpa" transaction-type="RESOURCE_LOCAL">
        <properties>
            <property name="javax.persistence.jdbc.url"
                      value="jdbc:mysql://localhost:3306/jpaclass?useSSL=FALSE&amp;serverTimezone=UTC"/>
            <property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver"/>
            <property name="javax.persistence.jdbc.user" value="root"/>
            <property name="javax.persistence.jdbc.password" value=""/>
            <property name="hibernate.hbm2ddl.auto" value="update"/>
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect"/>
        </properties>
    </persistence-unit>
</persistence>
```
***
### 4. Entity Class:
- Create the `Person`class:

![Person Entity](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_R18_Java_EE_Object_Relational_Mapping_with_JPA_Hibernate/JPAClass/img/person-entity.png)
- Attributes;
- Constructors;
- Getters/Setters;
- toString;
- Implements Serializable.
***
### 5. Include the MAPPINGS in the entity class:
```java
@Entity
public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;

    public Person() {
    }
...}
```
***
### 6. Database Transaction Operations Implementation:
***
### 6.1 `insert`- Implement the `insertion` of new records:
#### Main Class:
```java
EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-jpa");
EntityManager entityManager = entityManagerFactory.createEntityManager();

entityManager.getTransaction().begin();
Person personToInsert01 = new Person(null, "Balthazar de Bigode", "balthazar@email.com");
Person personToInsert02 = new Person(null, "Ophelia Cassandra Birrenta", "ophelia@email.com");
Person personToInsert03 = new Person(null, "Ludovico Crispim", "ludovico@email.com");
entityManager.persist(personToInsert01);
entityManager.persist(personToInsert02);
entityManager.persist(personToInsert03);
entityManager.getTransaction().commit();
System.out.println("Transaction committed!");
```
***
#### Database Result:
![Database Result](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_R18_Java_EE_Object_Relational_Mapping_with_JPA_Hibernate/JPAClass/img/database.png)
***
### 6.2 `findById` - Implement the search by `ID`:
#### Main Class:
```java
entityManager.getTransaction().begin();
Person personToFind = entityManager.find(Person.class, 2);
System.out.print(personToFind);
entityManager.getTransaction().commit();
System.out.println("Transaction committed!");
```
***
### 6.3 `update` - Implement the update of records:
#### Main Class:
```java
entityManager.getTransaction().begin();
Person personToUpdate = entityManager.find(Person.class, 10);
personToUpdate.setName("Balthazar Vitalino de Bigode");
entityManager.merge(personToUpdate);
entityManager.getTransaction().commit();
System.out.println("Transaction committed!");
```
***
### 6.4 `delete` - Implement the `deletion` of records:
#### Main Class:
```java
entityManager.getTransaction().begin();
Person personToDelete = entityManager.find(Person.class, 2);
entityManager.remove(personToDelete);
entityManager.getTransaction().commit();
System.out.println("Transaction committed!");
``` 

