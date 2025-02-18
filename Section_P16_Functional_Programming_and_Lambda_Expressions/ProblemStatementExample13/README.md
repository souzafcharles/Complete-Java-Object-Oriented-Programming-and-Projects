# Problem Statement Example 13 - Reference Method with Non-Static Method.

**Instructions**: Assume a Product class with name and price attributes. From a list of products, increase the price of
the products by `10%`. Perform operations with Interface Functional using Consumer (example with forEach).

### Product Model

![Product Model](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_P16_Functional_Programming_and_Lambda_Expressions/ProblemStatementExample13/product-model.png)

### Example Inputs and Outputs:

| **Input**          | **Output**       |
|--------------------|------------------|
| `TV`, `900.00`     | TV - $990.00     |
| `Mouse`, `50.00`   | Mouse - $55.00   |
| `Tablet`, `450.00` | Tablet - $495.00 |
| `HD Case`, `80.90` | HD Case - $88.99 |

### Non-Static Method - Product Class

```java
public void nonStaticProductConsumer () {
    price *=  1.1;
}
```
