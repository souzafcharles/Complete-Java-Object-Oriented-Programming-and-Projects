# Problem Statement Example 08

**Instructions**: Make a method that copies the elements of a list to another list that can be more generic than the
first.

### Get/Put Principle - Covariance:

```java
List<Integer> intList = new ArrayList<Integer>();
intList.

add(100);
intList.

add(50);

List<? extends Number> list = intList;
Number x = list.get(0);
list.

add(200); // compilation error
```
| get     | OK         |
|---------|------------|
| **put** | **ERRORS** |

### Get/Put Principle - Contravariance:

```java
List<Object> myObjs = new ArrayList<Object>();
myObjs.add("Balthazar");
myObjs.add("Ophelia");

List<? super Number> myNums = myObjs;
myNums.add(100);
myNums.add(33.333);

Number x = myNums.get(0); // compilation error
```
| get     | ERRORS |
|---------|--------|
| **put** | **OK** |
