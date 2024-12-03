# Example Problem 02
**Instructions**:
Write a program to read the data of a product in stock (name, price and quantity in stock).

Then:
- Display the product data (name, price, quantity in stock, total value in stock)
- Perform a stock entry and display the product data again
- Perform a stock exit and display the product data again

### Proposal to improve the program's project for reading product data in stock:

We will create an optional constructor, which only receives the product's name and price. The quantity in stock of this new product should then be initialized with the value zero by default.

**Note**: it is also possible to include a default constructor.

## Version 02: Understanding the This Keyword and Overloading.

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

### Example Inputs and Outputs

| **Input**                                                | **Output**                                           |
|----------------------------------------------------------|------------------------------------------------------|
| Enter product data:                                      | Product data: TV, $900.00, 10 units, Total: $9000.00 |
| Name: TV                                                 | Update data: TV, $900.00, 15 units, Total: $13500.00 |
| Price: 900.00                                            | Update data: TV, $900.00, 12 units, Total: $10800.00 |
| Quantity in stock: 10                                    |                                                      |                                                        |                                                      |
| Enter the number of products to be added in stock: 5     |                                                      |
| Enter the number of products to be removed from stock: 3 |                                                      |

****