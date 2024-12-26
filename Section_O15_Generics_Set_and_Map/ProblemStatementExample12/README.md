# Problem Statement Example 12

**Instructions**: Make a program that reads the names of 3 items and performs `LinkedHashSet` operations.

### Example Inputs and Outputs

| **Input**                    | **Output** |
|------------------------------|------------|
| `Computer`                   | Computer   |
| `Smatphone`                  | Smartphone |
| `Tablet`                     | Tablet     |   
| `set.contains("Notebook")`   | false      |
| `set.contains("Smartphone")` | true       |

### LinkedHashSet Operations (add, remove, contains) O(1) and Iteration O(n):

```java
Set<String> set = new LinkedHashSet<>();
```