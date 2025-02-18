# Exercise05

**Instructions**: Write a program to read the data of a bank account and then perform a withdrawal from this bank
account, displaying the new balance. A withdrawal cannot occur if there is no balance in the account or if the
withdrawal amount is greater than the account's withdrawal limit. Implement the bank account according to the project
below.

---

### Account Model

![Account Model](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_L12_Handling_Exceptions/Exercise05/account-model.png)

---

### Example Inputs and Outputs

#### Example 01:

| **Input**                           | **Output**         |
|-------------------------------------|--------------------|
| `Enter account data`                | `New balance`: 400 |
| `Number`: 8021                      |                    |
| `Holder`: Bob Brown                 |                    |
| `Initial balance`: 500.00           |                    |
| `Withdraw limit`: 300.00            |                    |
| `Enter amount for withdraw`: 100.00 |                    |

#### Example 02:

| **Input**                           | **Output**                                          |
|-------------------------------------|-----------------------------------------------------|
| `Enter account data`                | `Withdraw error`: The amount exceeds withdraw limit |
| `Number`: 8021                      |                                                     |
| `Holder`: Bob Brown                 |                                                     |
| `Initial balance`: 500.00           |                                                     |
| `Withdraw limit`: 300.00            |                                                     |
| `Enter amount for withdraw`: 400.00 |                                                     |

#### Example 03:

| **Input**                           | **Output**                                          |
|-------------------------------------|-----------------------------------------------------|
| `Enter account data`                | `Withdraw error`: The amount exceeds withdraw limit |
| `Number`: 8021                      |                                                     |
| `Holder`: Bob Brown                 |                                                     |
| `Initial balance`: 500.00           |                                                     |
| `Withdraw limit`: 300.00            |                                                     |
| `Enter amount for withdraw`: 800.00 |                                                     |

#### Example 04:

| **Input**                           | **Output**                           |
|-------------------------------------|--------------------------------------|
| `Enter account data`                | `Withdraw error`: Not enough balance |
| `Number`: 8021                      |                                      |
| `Holder`: Bob Brown                 |                                      |
| `Initial balance`: 500.00           |                                      |
| `Withdraw limit`: 300.00            |                                      |
| `Enter amount for withdraw`: 250.00 |                                      |
