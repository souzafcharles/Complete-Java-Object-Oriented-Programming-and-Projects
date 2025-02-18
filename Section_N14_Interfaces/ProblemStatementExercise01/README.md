# Problem Statement Example 01

**Instructions**: A company wishes to automate the processing of its contracts. Processing a contract consists of
generating the installments to be paid for that contract, based on the desired number of months.

The company uses an online payment service to make the installment payments. Online payment services typically charge a
monthly interest rate, as well as a fee per payment. For now, the service contracted by the company is `Paypal`, which
applies a simple interest of `1%` to each installment, plus a `2%` payment fee.

Make a program to read the data of a contract (contract number, contract date, and total contract value). Then, the
program should read the number of months for the contract installment, and then generate the installment records to be
paid (date and value), with the first installment to be paid one month after the contract date, the second installment
two months after the contract, and so on. Show the installment data on the screen.

### Contract Model

![Contract Rental Model](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_N14_Interfaces/ProblemStatementExercise01/contract-model.png)

### Example Inputs and Outputs

| **Input**                            | **Output**          |
|--------------------------------------|---------------------|
| `Input the contract details`:        | `Instalments`:      |
| `Number`: 8028                       | 12/01/2024 - 206.04 |
| `Date (dd/MM/yyyy)`: 12/12/2024      | 12/02/2024 - 208.08 |
| `Contract value`: 600.00             | 12/03/2024 - 210.12 |
| `Enter the number of instalments`: 3 |                     |

```
Calculations (1% simple monthly interest + 2% payment fee):

Installment #1:
200 + 1% * 1 = 202
202 + 2% = 206.04

Installment #2:
200 + 1% * 2 = 204
204 + 2% = 208.08

Installment #3:
200 + 1% * 3 = 206
206 + 2% = 210.12
```

### Objects in Memory

![Objects in Memory Contract](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_N14_Interfaces/ProblemStatementExercise01/objects-in-memory-contract.png)

### Service Layer Design

![Service Layer Design Contract](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_N14_Interfaces/ProblemStatementExercise01/service-layer-design-contract.png)
