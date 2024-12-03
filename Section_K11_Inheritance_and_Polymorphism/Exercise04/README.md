# Exercise04

**Instructions**: Write a program to read the data of N taxpayers (N provided by the user), which can be individuals or
companies, and then display the amount of tax paid by each, as well as the total tax collected.

The data for individuals are: name, annual income, and health expenditures. The data for companies are: name, annual
income, and number of employees. The rules for calculating taxes are as follows:

- Individuals: people whose income was below 20000.00 pay 15% tax. People with incomes of 20000.00 or more pay 25% tax.
  If the person had health expenditures, 50% of these expenditures are deducted from the tax.<br/>Example: a person
  whose income was 50000.00 and had 2000.00 in health expenditures, the tax is: (50000 * 25%) - (2000 * 50%) = 11500.00
  <br/><br/>
- Companies: companies pay 16% tax. However, if the company has more than 10 employees, it pays 14% tax.
  <br/>Example: a company whose income was 400000.00 and has 25 employees, the tax is: 400000 * 14% = 56000.00

### TaxPayer Model

![Account Model](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Session_K11_Inheritance_and_Polymorphism/Exercise04/tax-payer-model.png)

### Example Inputs and Outputs

| **Input**                           | **Output**                |
|-------------------------------------|---------------------------|
| `Enter the number of tax payers`: 3 | `TAXES PAID:`             |
| `Tax payer #1 data`:                | `Alex`: $ 11500.00        |
| `Individual or company (i/c)?`: i   | `SoftTech`: $ 56000.00    |
| `Name:`: Alex                       | `Bob`: $ 29500.00         |
| `Anual income`:  50000.00           | `TOTAL TAXES`: $ 97000.00 |
| `Health expenditures:` 2000.00      |                           |
| `Tax payer #2 data`:                |                           |
| `Individual or company (i/c)?`: c   |                           |
| `Name:`: SoftTech                   |                           |
| `Anual income`:  400000.00          |                           |
| `Number of employees:` 25           |                           |
| `Tax payer #3 data`:                |                           |
| `Individual or company (i/c)?`: i   |                           |
| `Name:`: Bob                        |                           |
| `Anual income`:  120000.00          |                           |
| `Health expenditures:` 1000.00      |                           |

### TaxPayer Local Memory Management:

![Tax Payer Local Memory Management](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Session_K11_Inheritance_and_Polymorphism/Exercise04/tax-payer-local-memory-management.png)