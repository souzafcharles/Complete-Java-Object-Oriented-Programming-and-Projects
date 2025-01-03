# Problem Statement Example 12 - Reference Method with Static Method.

**Instructions**: Assume a Product class with name and price attributes. From a list of products, increase the price of
the products by `10%`. Perform operations with Interface Functional using Consumer (example with forEach).

### Product Model

![Product Model](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_P16_Functional_Programming_and_Lambda_Expressions/ProblemStatementExample12/product-model.png)

### Example Inputs and Outputs:

| **Input**          | **Output**       |
|--------------------|------------------|
| `TV`, `900.00`     | TV - $990.00     |
| `Mouse`, `50.00`   | Mouse - $55.00   |
| `Tablet`, `450.00` | Tablet - $495.00 |
| `HD Case`, `80.90` | HD Case - $88.99 |

### Static Method - Product Class

```java
public static void staticProductConsumer (Product product) {
    product.setPrice(product.getPrice() * 1.1);
}
```