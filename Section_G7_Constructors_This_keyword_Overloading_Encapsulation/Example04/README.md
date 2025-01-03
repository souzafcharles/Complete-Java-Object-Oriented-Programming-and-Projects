# Example Problem 04
**Instructions**:
Write a program to read the data of a product in stock (name, price and quantity in stock).

Then:
- Display the product data (name, price, quantity in stock, total value in stock)
- Perform a stock entry and display the product data again
- Perform a stock exit and display the product data again

## Version 04: Updating access modifiers for Encapsulation.

To solve this problem, you should create a CLASS according to the project alongside:

| **Product**                               |
|-------------------------------------------|
| - Name: `String`                          |
| - Price: `double`                         |
| - Quantity: `int`                         |
| ========================================= |
| + `Product()`                             |
| + `TotalValueInStock()`: `double`         |
| + `AddProducts(quantity: int)`: `void`    |
| + `RemoveProducts(quantity: int)`: `void` |

***
| **Order**                                 |
|-------------------------------------------|
| - Date: `Date`                            |
| - Product: `Product`                      |
| ========================================= |
|                                           |

### Example Inputs and Outputs

| **Input**                                                | **Output**                                           |
|----------------------------------------------------------|------------------------------------------------------|
| Enter product data:                                      | Product data: TV, $900.00, 10 units, Total: $9000.00 |
| Name: TV                                                 | Update data: TV, $900.00, 15 units, Total: $13500.00 |
| Price: 900.00                                            | Update data: TV, $900.00, 12 units, Total: $10800.00 |
| Quantity in stock: 10                                    |                                                      |                                                        |                                                      |
| Enter the number of products to be added in stock: 5     |                                                      |
| Enter the number of products to be removed from stock: 3 |                                                      |

***