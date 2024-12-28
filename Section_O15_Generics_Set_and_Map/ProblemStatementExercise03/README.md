# Problem Statement Exercise 03

**Instructions**: In a voting count of an election, several voting records are generated containing the candidate's name
and the number of votes (`in.csv` format) that he obtained in a voting machine. You must make a program to read the
voting records from a file, and then generate a consolidated report with the totals of each candidate.

### Example Input File:

| **in.txt**               |
|--------------------------|
| `Balthazar de Bigode,15` |
| `Ophelia Birrenta,22`    |
| `Ludovico Crispim,21`    |
| `Balthazar de Bigode,30` |
| `Ludovico Crispim,15`    |
| `Ophelia Birrenta,27`    |
| `Ophelia Birrenta,22`    |
| `Ludovico Crispim,25`    |
| `Balthazar de Bigode,31` |

### Example Inputs and Outputs:

| **Input**                             | **Output**                |
|---------------------------------------|---------------------------|
| Enter file full path: `c:\tmp\in.txt` | Balthazar de Bigode: `76` |
|                                       | Ophelia Birrenta: `71`    |
|                                       | Ludovico Crispim: `61`    |    