# Problem Statement Example 02

**Instructions**: A Brazilian car rental company applies an hourly rate for rentals not exceeding 12 hours. For rentals
surpassing 12 hours, a daily rate is employed. Additionally, a tax is levied on the rental value, adhering to Brazilian
tax regulations: 20% for values up to 100.00 and 15% for values exceeding 100.00. Develop a program to input rental
details (car model, rental commencement and conclusion times), hourly rate, and daily rate. Subsequently, generate a
payment invoice displaying the rental cost, tax amount, and total payment. Refer to the provided examples.

### CarRental Model

![Car Rental Model](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_N14_Interfaces/ProblemStatementExample02/car-rental-model.png)

### Example Inputs and Outputs 01

| **Input**                                      | **Output**             |
|------------------------------------------------|------------------------|
| `Input the rental data`:                       | `INVOICE`:             |
| `Car model`: Civic                             | `Basic payment`: 50.00 |
| `Pick-up (dd/MM/yyyy hh:mm)`: 08/12/2024 10:30 | `Tax`: 10.00           |
| `Return (dd/MM/yyyy hh:mm)`: 08/12/2024 14:40  | `Total payment`: 60.00 |
| `Enter the hourly rate`: 10.00                 |                        |
| `Enter the daily rate`: 130.00                 |                        |

```
Calculations:
Duration = (08/12/2024 14:40) - (08/12/22024 10:30) = 4:10 = 5 hours
Basic payment = 5 × 10 = 50
Tax = 50 × 20% = 50 × 0.2 = 10
```

### Example Inputs and Outputs 02

| **Input**                                      | **Output**              |
|------------------------------------------------|-------------------------|
| `Input the rental data`:                       | `INVOICE`:              |
| `Car model`: Civic                             | `Basic payment`: 390.00 |
| `Pick-up (dd/MM/yyyy hh:mm)`: 08/12/2024 10:30 | `Tax`: 58.50            |
| `Return (dd/MM/yyyy hh:mm)`: 10/12/2024 11:40  | `Total payment`: 448.50 |
| `Enter the hourly rate`: 10.00                 |                         |
| `Enter the daily rate`: 130.00                 |                         |

```
Calculations:
Duration = (10/12/2018 11:40) - (25/06/2018 10:30) = 2 days + 1:10 = 3 days
Basic payment = 3 × 130 = 390
Tax = 390 × 15% = 390 × 0.15 = 58.50
```

### Objects in Memory

![Objects in Memory Car Rental](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_N14_Interfaces/ProblemStatementExample02/objects-in-memory-car-rental.png)

### Service Layer Design

![Service Layer Design Car Rental](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_N14_Interfaces/ProblemStatementExample02/service-layer-design-car-rental.png)
