# Problem Statement Example 15

**Instructions**: Create a program that uses the `TreeSet` implementation, which will read data from a Product (name and
price) and then print the data in an ordered manner according to the compareTo of the product objects.

### Example Inputs and Outputs

| **Input**            | **Output**         |
|----------------------|--------------------|
| `Smartphone, 910.00` | Computer, 890.50   |
| `Tablet, 550.00`     | Smartphone, 910.00 |
| `Computer, 890.50`   | Tablet, 550.00     |

### compareTo Method:

````java

@Override
public int compareTo(Product other) {
    return name.toUpperCase().compareTo(other.name.toUpperCase());
}
````