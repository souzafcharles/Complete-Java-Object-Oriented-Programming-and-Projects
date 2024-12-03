# Exercise 13
**Instructions**:

Write a program to read an integer N and then the data (id, name, and salary) of N employees. There should be no duplicate ids.

Then, increase the salary of a specific employee by X percent.

To do this, the program should read an id and the value X. If the informed id does not exist, display a message and abort the operation. Finally, display the updated list of employees, as shown in the examples.

Remember to apply the encapsulation technique to prevent the salary from being changed freely. A salary can only be increased based on a given percentage increase operation.

### Example Inputs and Outputs

#### Example 01:

| **Input**                                                   | **Output**                |
|-------------------------------------------------------------|---------------------------|
| `How many employees will be registered?` 3                  | `List of employees`:      |
| `Employee #1`:                                              | 333, Maria Brown, 4000.00 |
| `Id`:333                                                    | 536, Alex Grey, 3300.00   |
| `Name`: Maria Brown                                         | 772, Bob Green, 5000.00   |
| `Salary`: 4000.00                                           |                           |
| `Employee #2`:                                              |                           |
| `Id`:536                                                    |                           |
| `Name`: Alex Grey                                           |                           |
| `Salary`: 3000.00                                           |                           |
| `Employee #3`:                                              |                           |
| `Id`:772                                                    |                           |
| `Name`: Bob Green                                           |                           |
| `Salary`: 5000.00                                           |                           |
| `Enter the employee id that will have salary increase`: 536 |                           |
| `Enter the percentage`: 10.0                                |                           |


#### Example 02:

| **Input**                                                   | **Output**                |
|-------------------------------------------------------------|---------------------------|
| `How many employees will be registered?` 2                  | This id does not exist!   |
| `Employee #1`:                                              | `List of employees`:      |
| `Id`:333                                                    | 333, Maria Brown, 4000.00 |
| `Name`: Maria Brown                                         | 536, Alex Grey, 3300.00   |
| `Salary`: 4000.00                                           |                           |
| `Employee #2`:                                              |                           |
| `Id`:536                                                    |                           |
| `Name`: Alex Grey                                           |                           |
| `Salary`: 3000.00                                           |                           |
| `Enter the employee id that will have salary increase`: 776 |                           |


To solve this problem, you should create a CLASS according to the project alongside:

| **Employee**                                                                            |
|-----------------------------------------------------------------------------------------|
| - id: `Integer`                                                                         |
| - name: `String`                                                                        |
| - salay : `Double`                                                                      |
| =====================================================================================   |
| + `increaseSalary(percentage: double): void`                                            |
| + `isIdTaken(employees: List<Employee>, id: int): boolean`                              |
| + `addEmployee(employees: List<Employee>, id: int, name: String, salary: double): void` |
| + `findEmployeeById(employees: List<Employee>, id: int): Employee`                      |
