# Problem Statement Example 10

**Instructions**: Make a program that reads the names of 3 items and performs `HashSet` operations.

### Example Inputs and Outputs

| **Input**                    | **Output** |
|------------------------------|------------|
| `Computer`                   | Smartphone |
| `Smatphone`                  | Tablet     |
| `Tablet`                     | Computer   |   
| `set.contains("Notebook")`   | false      |
| `set.contains("Smartphone")` | true       |

### HashSet O(1) operations on Hash Table:

```java
Set<String> set = new HashSet<>();
```