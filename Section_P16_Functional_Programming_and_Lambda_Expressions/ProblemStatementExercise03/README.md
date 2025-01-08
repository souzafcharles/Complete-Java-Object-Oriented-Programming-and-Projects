# Problem Statement Exercise 03

**Instructions**: Write a program to read the data (name, email, and salary) of employees from a `.csv` file. Then,
display in alphabetical order the email of employees whose salary is greater than a given value provided by the user.
Also, display the sum of the salaries of employees whose name starts with the letter `'B'`.

### Employee Class
````java
package com.souza.charles.model.entities;
````
![Employee Entities](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_P16_Functional_Programming_and_Lambda_Expressions/ProblemStatementExercise03/employee-entities.png)

### EmployeeFile Class
````java
package com.souza.charles.model.utils;
````
![EmployeeFile Utils](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_P16_Functional_Programming_and_Lambda_Expressions/ProblemStatementExercise03/employeeFile-utils.png)

### EmployeeService Class
````java
package com.souza.charles.model.services;
````
![EmployeeFile Services](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_P16_Functional_Programming_and_Lambda_Expressions/ProblemStatementExercise03/employeeService-services.png)

### Example Inputs and Outputs:

| **Input**                                   | **Output**                                                     |
|---------------------------------------------|----------------------------------------------------------------|
| `Balthazar,balthazar@mail.com,3200.00`      | Email of people whose salary is more than $2000.00:            |
| `Ophelia,ophelia@gmail.com,1900.00`         | `abigail@gmail.com`                                            |
| `Bartholomew,bartholomew@gmail.com,1700.00` | `balthazar@mail.com`                                           |
| `Margaret,margaret@gmail.com,3500.00`       | `margaret@gmail.com`                                           |
| `Abigail,abigail@gmail.com,2800.00`         | Sum of salary of people whose name starts with 'B': `$4900.00` |
| `Enter full file path: C:\tmp\in.txt`       |                                                                |
| `Enter salary: 2000.00`                     |                                                                |

