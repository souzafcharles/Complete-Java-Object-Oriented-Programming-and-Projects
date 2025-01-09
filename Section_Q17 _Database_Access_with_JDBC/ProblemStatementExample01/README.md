# Problem Statement Example 01

**Instructions**: 

- Using MySQL Workbench, create a database named "coursejdbc";
- Download the MySQL Java Connector;
- If it doesn't exist yet, create a User Library containing the MySQL driver .jar file:
	- Window -> Preferences -> Java -> Build path -> User Libraries;
	- Name the User Library MySQLConnector;
	- Add external JARs -> (locate the .jar file).
- Create a new Java Project;
- Add the MySQLConnector User Library to the project;
- In the project's root folder, create a file named "db.properties" containing the connection data: 

### "db.properties" 

```sql
user=developer
password=1234567
dburl=jdbc:mysql://localhost:3306/coursejdbc
useSSL=false
```

- In the "db" package, create a custom exception called DbException;
- In the "db" package, create a DB class with auxiliary static methods:
	- Get and close a connection to the database.