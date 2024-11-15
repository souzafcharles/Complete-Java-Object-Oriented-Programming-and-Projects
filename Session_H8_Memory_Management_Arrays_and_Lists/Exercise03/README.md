# Exercise 03
**Instructions**: Write a program to read the name, age, and height of N people, as shown in the example. Then, display on the screen the average height of the people, and also show the percentage of people under 16 years old, as well as the names of these people if any.

To solve this problem, you should create a CLASS according to the project alongside:

| **Person**                                               |
|----------------------------------------------------------|
| - Name: `String`                                         |
| - Age: `int`                                             | 
| - Height: `double`                                       |
| =========================================                |
| + `calculateAverageHeight(person: Person[]): double`     |
| + `countPeopleUnder16YearsOld(person: Person[]): double` |
| + `namePeopleUnder16YearsOld(person: Person[]): String`  |

***
### Example Inputs and Outputs

| **Input**                            | **Output**                         |
|--------------------------------------|------------------------------------|
| `How many people will be entered?` 5 | `Average height`: 1.69             |
| `Data of the 1º person`:             | `People under 16 years old`: 40.0% |
| `Name:`: John                        | John                               |
| `Age`: 15                            | Teresa                             |
| `Height`: 1.82                       |                                    |
| `Data of the 2º person`:             |                                    |
| `Name:`: Mary                        |                                    |
| `Age`: 16                            |                                    |
| `Height`: 1.60                       |                                    |
| `Data of the 3º person`:             |                                    |
| `Name:`: Teresa                      |                                    |
| `Age`: 14                            |                                    |
| `Height`: 1.58                       |                                    |
| `Data of the 4º person`:             |                                    |
| `Name:`: Charles                     |                                    |
| `Age`: 21                            |                                    |
| `Height`: 1.65                       |                                    |
| `Data of the 5º person`:             |                                    |
| `Name:`: Paul                        |                                    |
| `Height`: 1.78                       |                                    |

