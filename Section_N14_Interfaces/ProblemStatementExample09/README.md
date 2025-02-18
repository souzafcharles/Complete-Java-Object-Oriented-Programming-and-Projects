# Problem Example 09

**Instructions**: Write a program to read an amount and the duration in months of a loan. Display the value to be paid
after the loan term, according to Brazilian and USA interest rules. The Brazilian interest calculation rule is a
standard compound interest of 2% per month and the USA interest calculation rule is a standard compound interest of 1%
per month.

### Interest Model

![Interest Model](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_N14_Interfaces/ProblemStatementExample09/interest-model.png)

### Example Inputs and Outputs

**Brazilian interest**:

| **Input**        | **Output**                |
|------------------|---------------------------|
| `Amount`: 200.00 | `Payment after 3 months`: |
| `Months`: 3      | 212.24                    |

```
Calculation: 
Payment = 200 * 1.02 * 1.02 * 1.02 = 200 * 1.023 = 212.2416
Payment = amount * (1 + interestRate / 100)^N
```

**USA interest**:

| **Input**        | **Output**                |
|------------------|---------------------------|
| `Amount`: 200.00 | `Payment after 3 months`: |
| `Months`: 3      | 206.06                    |

```
Calculation: 
Payment = 200 * 1.01 * 1.01 * 1.01 = 200 * 1.013 = 206.0602
Payment = amount * (1 + interestRate / 100)^N
```
