# Exercise 03
**Instructions**: 
Create a program to read the name of a student and the three grades they obtained in the three trimesters of the year (the first trimester is worth 30 and the second and third are worth 35 each). In the end, show the student's final grade for the year. Also say whether the student is approved (PASS) or not (FAILED) and, if negative, how many points are missing for the student to obtain the minimum to be approved (which is 60% of the grade). You must create a Student class to solve this problem.

## Student Class Structure

| **Student**                     |
|---------------------------------|
| - Name: `String`                |
| - Grade01: `double`             |
| - Grade02: `double`             |
| - Grade03: `double`             |
| **Methods**                     |
| + `CalculateFinalGrade()`: `double` |
| + `isPassed()`: `boolean`       |
| + `pointsMissing()`: `double`   |

### Example Inputs and Outputs

| **Input**         | **Output**         |
|-------------------|------------------- |
| Alex Green        | FINAL GRADE = 90.00|
| 27.00             | PASS               |
| 31.00             |                    |
|  32.00            |                    |
|-------------------|--------------------|
| Alex Green        | FINAL GRADE = 52.00|
| 17.00             | FAILED             |
| 20.00             | MISSING 8.00 POINTS|
| 15.00             |                    |
