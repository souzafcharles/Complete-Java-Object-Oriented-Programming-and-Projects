# Problem Statement Example 19 - Declared Lambda Expression.

**Instructions**: Assume a Product class with name and price attributes. From a list of products, generate a new list
containing the product names in `uppercase`. Perform operations with Interface Functional using Function (example with
map).

### Product Model

![Product Model](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_P16_Functional_Programming_and_Lambda_Expressions/ProblemStatementExample19/product-model.png)

### Example Inputs and Outputs:

| **Input**          | **Output** |
|--------------------|------------|
| `TV`, `900.00`     | TV         |
| `Mouse`, `50.00`   | MOUSE      |
| `Tablet`, `450.00` | TABLET     |
| `HD Case`, `80.90` | HD CASE    |

### Lambda Expression

```java
Function<Product, String> function = product -> product.getName().toUpperCase();
```