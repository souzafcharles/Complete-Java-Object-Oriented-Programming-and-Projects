# Exercise 10
**Instructions**: Write a program to read a set of N student names, as well as the grades they got in the 1st and 2nd semesters. Each of these pieces of information should be stored in a array. Then, print the names of the approved students, considering approved those whose average grade is greater than or equal to 6.0 (six).

To solve this problem, you should create a CLASS according to the project alongside:

| **Studant**                                              |
|----------------------------------------------------------|
| - Name: `String`                                         |
| - gradeFirstSemester: `double`                           | 
| - gradeSecondSemester: `double`                          |
| =========================================                |
| + `calculateAverageGrade(): double`                      |
| + `showNameStudentApproved(students: Student[]): String` |

### Example Inputs and Outputs

| **Input**                                                | **Output**           |
|----------------------------------------------------------|----------------------|
| `How many students will you enter?` 4                    | `Approved students`: |
| `Enter name, first and second grade of the 1º student` : | Joao Silva           |
| Joao Silva                                               | Maria Teixeira       |
| 7.0                                                      | Teresa Pires         |
| 8.5                                                      |                      |
| `Enter name, first and second grade of the 2º student` : |                      |
| Maria Teixeira                                           |                      |
| 9.2                                                      |                      |
| 6.5                                                      |                      |
| `Enter name, first and second grade of the 3º student` : |                      |
| Carlos Carvalho                                          |                      |
| 5.0                                                      |                      |
| 6.0                                                      |                      |
| `Enter name, first and second grade of the 4º student` : |                      |
| Teresa Pires                                             |                      |
| 5.5                                                      |                      |
| 6.5                                                      |                      |