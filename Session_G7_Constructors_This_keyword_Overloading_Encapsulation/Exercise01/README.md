# Exercise 01
**Instructions**:

In a bank, to register a bank account, it is necessary to provide the account number, the account holder's name, and the initial deposit amount that the holder deposited when opening the account. This initial deposit amount, however, is optional, meaning that if the holder does not have any money to deposit when opening their account, the initial deposit will not be made and the initial account balance will naturally be zero.

Importantly, once a bank account has been opened, the account number can never be changed. However, the holder's name can be changed (as a person may change their name upon marriage, for example).

Finally, the account balance cannot be freely altered. There must be a mechanism to protect this. The balance only increases through deposits, and only decreases through withdrawals. For each withdrawal made, the bank charges a fee of $5.00. Note: the account can have a negative balance if the balance is insufficient to make the withdrawal and/or pay the fee.

You must create a program that performs the registration of an account, giving the option to enter the initial deposit amount or not. Then, make a deposit and then a withdrawal, always showing the account details after each operation.

## Class Account

| **Account**                         |
|-------------------------------------|
| - number: `Integer`                 |
| - holder: `String`                  |
| - balance: `Double`                 |
| =================================== |
| + `deposit(amount: double): void`   |
| + `withdraw(amout: double)`: `void` |


### Example Inputs and Outputs

| **Input**                               | **Output**                                                                  |
|-----------------------------------------|-----------------------------------------------------------------------------|
| `Enter account number`: 8532            | `Account data`: Account 8532, Holder: Alex Green, Balance: $ 500.00         |
| `Enter account holder`: Alex Green      | `Updated account data`: Account 8532, Holder: Alex Green, Balance: $ 700.00 |
| `Is there an initial deposit (y/n)?`: y | `Updated account data`: Account 8532, Holder: Alex Green, Balance: $ 395.00 |
| `Enter initial deposit value:` 500.00   |                                                                             |
| `Enter a deposit value`: 200.00         |                                                                             |
| `Enter a withdraw value`: 300.00        |                                                                             |

***

### Example Inputs and Outputs

| **Input**                               | **Output**                                                                   |
|-----------------------------------------|------------------------------------------------------------------------------|
| `Enter account number`: 7801            | `Account data`: Account 7801, Holder: Maria Brown, Balance: $ 0.00           |
| `Enter account holder`: Maria Brown     | `Updated account data`: Account 7801, Holder: Maria Brown, Balance: $ 200.00 |
| `Is there an initial deposit (y/n)?`: n | `Updated account data`: Account 7801, Holder: Maria Brown, Balance: $ -3.00  |
| `Enter a deposit value`: 200.00         |                                                                              |
| `Enter a deposit value`: 198.00         |                                                                              |
|                                         |                                                                              |


