# Exercise01

**Instructions**: Write a program to read the data of a hotel reservation (room number, check-in date, and check-out
date) and display the reservation data, including its duration in days. Subsequently, read new check-in and check-out
dates, update the reservation, and display the reservation again with the updated data. The program must not accept
invalid data for the reservation, according to the following rules:

- Reservation changes can only occur for future dates;
- The1 check-out date must be greater than the check-in date.

---

### Reservation Model

![Reservation Model](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Session_L12_Handling_Exceptions/Exercise01/reservation-model.png)

---

### Solution 1 (very poor) | Validation logic in the main program (App):

- Validation logic not delegated to the Reservation class.

### Example Inputs and Outputs

#### Example 01:

| **Input**                                 | **Output**                                                                          |
|-------------------------------------------|-------------------------------------------------------------------------------------|
| `Room number`: 8021                       | `Reservation`: Room 8021, `check-in`: 23/09/2019, `check-out`: 26/09/2019, 3 nights |
| `Check-in date (dd/MM/yyyy)`: 23/09/2024  | `Reservation`: Room 8021, `check-in`: 24/09/2019, `check-out`: 29/09/2019, 5 night  |
| `Check-out date (dd/MM/yyyy)`: 26/09/2024 |                                                                                     |
| `Enter data to update the reservation`:   |                                                                                     |
| `Check-in date (dd/MM/yyyy)`: 24/09/2024  |                                                                                     |
| `Check-out date (dd/MM/yyyy)`: 29/09/2024 |                                                                                     |

#### Example 02:

| **Input**                                 | **Output**                                                         |
|-------------------------------------------|--------------------------------------------------------------------|
| `Room number`: 8021                       | `Error in reservation`: Check-out date must be after check-in date |
| `Check-in date (dd/MM/yyyy)`: 23/09/2024  |                                                                    |
| `Check-out date (dd/MM/yyyy)`: 21/09/2024 |                                                                    |

#### Example 03:

| **Input**                                 | **Output**                                                                          |
|-------------------------------------------|-------------------------------------------------------------------------------------|
| `Room number`: 8021                       | `Reservation`: Room 8021, `check-in`: 23/09/2019, `check-out`: 26/09/2019, 3 nights |
| `Check-in date (dd/MM/yyyy)`: 23/09/2024  | `Error in reservation`: Reservation dates for update must be future dates           |
| `Check-out date (dd/MM/yyyy)`: 26/09/2024 |                                                                                     |
| `Enter data to update the reservation`:   |                                                                                     |
| `Check-in date (dd/MM/yyyy)`: 24/09/2020  |                                                                                     |
| `Check-out date (dd/MM/yyyy)`: 29/09/2020 |                                                                                     |

#### Example 04:

| **Input**                                 | **Output**                                                                          |
|-------------------------------------------|-------------------------------------------------------------------------------------|
| `Room number`: 8021                       | `Reservation`: Room 8021, `check-in`: 23/09/2019, `check-out`: 26/09/2019, 3 nights |
| `Check-in date (dd/MM/yyyy)`: 23/09/2024  | `Error in reservation`: Check-out date must be after check-in date                  |
| `Check-out date (dd/MM/yyyy)`: 26/09/2024 |                                                                                     |
| `Enter data to update the reservation`:   |                                                                                     |
| `Check-in date (dd/MM/yyyy)`: 24/09/2025  |                                                                                     |
| `Check-out date (dd/MM/yyyy)`: 22/09/2025 |                                                                                     |