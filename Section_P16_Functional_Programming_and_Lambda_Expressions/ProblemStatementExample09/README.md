# Problem Statement Example 09 - Declared Lambda Expression.

**Instructions**: Assume a Product class with name and price attributes. From a list of products, removes from the list only those whose minimum price is 100. Perform operations with Interface Functional using Predicate (example with removeIf).

### Product Model

![Product Model](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_P16_Functional_Programming_and_Lambda_Expressions/ProblemStatementExample09/product-model.png)

### Example Inputs and Outputs:

| **Input**          | **Output**       |
|--------------------|------------------|
| `TV`, `900.00`     | Mouse - $50.00   |
| `Mouse`, `50.00`   | HD Case - $80.90 |
| `Tablet`, `450.00` |                  |
| `HD Case`, `80.90` |                  |


### Lambda Expression
```java
Predicate<Product> predicate = product -> product.getPrice() >= 100.00;
}
```
