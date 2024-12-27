# Problem Statement Exercise 01

**Instructions**: An internet website records a log of user accesses. A log record consists of the username (a single
word) and the instant the user accessed the site in ISO 8601 format, separated by a space, as in the example. Write a
program that reads the access log from a file and then reports how many distinct users accessed the website.

### LogAccess Model

![LogAccess Model](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Section_O15_Generics_Set_and_Map/ProblemStatementExercise01/logAccess-model.png)


### Example Inputs and Outputs

| **Input**                            | **Output**          |
|--------------------------------------|---------------------|
| `balthazar 2024-12-26T20:45:08Z`     | Total users: `4`    |
| `ophelia 2024-12-26T21:49:37Z`       |                     |
| `ludovico 2024-12-27T03:19:13Z`      |                     |
| `balthazar 2024-12-27T08:11:00Z`     |                     |
| `sebastiana 2024-12-27T09:19:24Z`    |                     |
| `ophelia 2024-12-27T22:39:52Z`       |                     |
| `balthazar 2024-12-28T07:42:19Z`     |                     |

### Execution:

```declarative
Enter file full path: c:\tmp\log.txt
```
