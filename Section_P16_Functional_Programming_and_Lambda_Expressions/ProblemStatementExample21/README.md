# Problem Statement Example 21 - Passing Functions as Arguments to other Functions.

**Instructions**: Assume a Product class with name and price attributes. From a list of products, calculate the
sum of the prices of only those products whose name begins with “T”.

### Product Model

![Product Model](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_P16_Functional_Programming_and_Lambda_Expressions/ProblemStatementExample21/product-model.png)

### Example Inputs and Outputs:

| **Input**          | **Output** |
|--------------------|------------|
| `TV`, `900.00`     | $1250.50   |
| `Mouse`, `50.00`   |            |
| `Tablet`, `350.50` |            |
| `HD Case`, `80.90` |            |

### Functions as Arguments

```java
public double filterSum(List<Product> productList, Predicate<Product> parameter) {
    double sum = 0.0;
    for (Product products : productList) {
        if (parameter.test(products)) {
            sum += products.getPrice();
        }
    }
    return sum;
}
```
