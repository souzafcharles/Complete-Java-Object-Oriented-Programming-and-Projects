# Problem Statement Example 09

**Instructions**: Create a class Client with attributes `name` and `email`. Implement the `equals` and `hashCode`
methods so that two clients are considered equal if and only if they have the same name and email.

### Example Inputs and Outputs

| **Input**                         | **Output**  |
|-----------------------------------|-------------|
| `Balthazar` `balthazar@email.com` | 1821642965  |
| `Ophelia` `ophelia@email.com`     | -1556178369 |
|                                   | false       |

### Class Client:

```java
public class Client {
    private String name;
    private String email;
}
```