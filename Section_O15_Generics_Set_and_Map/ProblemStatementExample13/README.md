# Problem Statement Example 12

**Instructions**: Make a program that reads the integer elements A: `0, 2, 4, 5, 6, 8, 10` and integer elements B:
`5, 6, 7, 8, 9, 10` and performs `TreeSet` operations with union, intersection and difference.

### Example Inputs and Outputs

| **Input**              | **Output**                   |
|------------------------|------------------------------|
| `0, 2, 4, 5, 6, 8, 10` | [0, 2, 4, 5, 6, 7, 8, 9, 10] |
| `5, 6, 7, 8, 9, 10`    | [5, 6, 8, 10]                |
|                        | [0, 2, 4]                    |   

### TreeSet O(log n) operations on Red-Black Tree:

```java
Set<Integer> a = new TreeSet<>;
```

### Operations with Union:

Adds the elements of the other set to the set, without repetition.

```java
addAll(other)
```

### Operations with Intersection:

Removes from the set the elements not contained in other.

```java
retainAll(other)
```

### Operations with Difference:

Removes elements contained in other from the set.

```java
removeAll(other)
```
