# Problem Statement Example 07

**Instructions**: Write a method to return the sum of the areas of a list of figures.

### Shape Model

![Shape Model](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_O15_Generics_Set_and_Map/ProblemStatementExample07/shape-model.png)

### Example Inputs and Outputs 01

| **Input**    | **Output**           |
|--------------|----------------------|
| `3.0`, `2.0` | Total area: `18.566` |
| `2.0`        |                      |

### Example Inputs and Outputs 02

| **Input** | **Output**           |
|-----------|----------------------|
| `2.0`     | Total area: `40.841` |
| `3.0`     |                      |


### Class ShapeCalculation

**Delimited Wildcards:**
```java
public double totalArea(List<? extends Shape> shapeList) {
    double sum = 0.0;
    for (Shape shape : shapeList) {
        sum += shape.area();
    }
    return sum;
}
```
