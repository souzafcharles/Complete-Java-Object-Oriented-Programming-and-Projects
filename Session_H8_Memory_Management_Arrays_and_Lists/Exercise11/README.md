# Exercise 11
**Instructions**: Given a dataset containing the height and gender (M, F) of N people. Write a program that calculates and prints the tallest and shortest height in the group, the average height of women, and the number of men.

To solve this problem, you should create a CLASS according to the project alongside:

| **Person**                                            |
|-------------------------------------------------------|
| - Name: `String`                                      |
| - Height : `double`                                   | 
| - Gender: `char`                                      |
| =========================================             |
| + `calculateShortestHeight(person: Person[]): double` |
| + `calculateTallestHeight(person: Person[]): double`  |
| + `calculateAverageGrade(person: Person[]): double`   |
| + `calculateNumberOfMen(person: Person[]): int`       |

### Example Inputs and Outputs

| **Input**                           | **Output**                       |
|-------------------------------------|----------------------------------|
| `How many people will you enter?` 5 | `Shortest height` = 1.54         |
| `Height of the 1º person`: 1.70     | `Tallest height` = 1.83          |
| `Gender of the 1º person`: F        | `Average height of women` = 1.69 |
| `Height of the 2º person`: 1.83     | `Number of men` = 2              |
| `Gender of the 2º person`: M        |                                  |
| `Height of the 3º person`: 1.54     |                                  |
| `Gender of the 3º person`: M        |                                  |
| `Height of the 4º person`: 1.61     |                                  |
| `Gender of the 4º person`: F        |                                  |
| `Height of the 5º person`: 1.75     |                                  |
| `Gender of the 5º person`: F        |                                  |
