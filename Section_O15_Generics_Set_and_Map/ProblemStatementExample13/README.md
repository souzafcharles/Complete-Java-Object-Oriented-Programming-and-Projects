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
### Checklist:

| **Problem Statement Examples** | **Perspective**                                                          | **Solution**                                                                                                                                                                          |
|--------------------------------|--------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `ProblemStatementExample01`    | Motivating Problem 01 (Reuse)                                            | <center>[01](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_O15_Generics_Set_and_Map/ProblemStatementExample01)</center> |
| `ProblemStatementExample02`    | Motivating Problem 02 (Type Safety & Performance)                        | <center>[02](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_O15_Generics_Set_and_Map/ProblemStatementExample02)</center> |
| `ProblemStatementExample03`    | Solution with Generics (Integer)                                         | <center>[03](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_O15_Generics_Set_and_Map/ProblemStatementExample03)</center> |
| `ProblemStatementExample04`    | Solution with Generics (String)                                          | <center>[04](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_O15_Generics_Set_and_Map/ProblemStatementExample04)</center> |
| `ProblemStatementExample05`    | Bounded Generics                                                         | <center>[05](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_O15_Generics_Set_and_Map/ProblemStatementExample05)</center> |
| `ProblemStatementExample06`    | Bounded Generics (Alternative Complete Version)                          | <center>[06](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_O15_Generics_Set_and_Map/ProblemStatementExample06)</center> |
| `ProblemStatementExample07`    | Bounded Wildcards                                                        | <center>[07](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_O15_Generics_Set_and_Map/ProblemStatementExample07)</center> |
| `ProblemStatementExample08`    | Get/Put Principle - Covariance & Contravariance                          | <center>[08](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_O15_Generics_Set_and_Map/ProblemStatementExample08)</center> |
| `ProblemStatementExample09`    | HashCode & Equals                                                        | <center>[09](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_O15_Generics_Set_and_Map/ProblemStatementExample09)</center> |
| `ProblemStatementExample10`    | HashSet O(1) operations on Hash Table                                    | <center>[10](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_O15_Generics_Set_and_Map/ProblemStatementExample10)</center> |
| `ProblemStatementExample11`    | TreeSet O(log n) operations on Red-Black Tree                            | <center>[11](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_O15_Generics_Set_and_Map/ProblemStatementExample11)</center> |
| `ProblemStatementExample12`    | LinkedHashSet Operations (add, remove, contains) O(1) and Iteration O(n) | <center>[12](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_O15_Generics_Set_and_Map/ProblemStatementExample12)</center> |
| `ProblemStatementExample13`    | TreeSet Operations with Union, Intersection and Difference               | <center>[13](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_O15_Generics_Set_and_Map/ProblemStatementExample13)</center> |

****