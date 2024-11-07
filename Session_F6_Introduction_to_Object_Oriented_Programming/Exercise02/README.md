# Exercise 02
**Instructions**: 
Write a program to read an employee's data (name, gross salary, and tax). Then, display the employee's data (name and net salary). Next, increase the employee's salary based on a given percentage (only the gross salary is affected by the percentage) and display the employee's data again. Use the designed class below:

## Class Structure

| **Employee**                                   |
|------------------------------------------------|
| - Name: `String`                               |
| - GrossSalary: `double`                        |
| - Tax: `double`                                |
| **Methods**                                    |
| + `NetSalary()`: `double`                      |
| + `IncreaseSalary(percentage: double)`: `void` |


### Example Inputs and Outputs

| **Input**                                   | **Output**                          |
|---------------------------------------------|-------------------------------------|
| `Nome`: Joao Silva                          | Employee: Joao Silva, $ 5000.00     |
| `Gross salary`: 6000.00                     | Updated data: Joao Silva, $ 5600.00 |
| `Tax`: 1000.00                              |                                     |
| `Which percentage to increase salary?` 10.0 |                                     |
