# Example01
**Instructions**: Consider a banking business that has a standard account and a business account. The business account includes all members from the standard account, along with a loan limit and a function to issue loans.

**Step 01**: Implement the classes Account and BusinessAccount and conduct some tests.

### Account Model
![Account Model](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Session_K11_Inheritance_and_Polymorphism/Example01/account-model.png)

**Step 02**: Assume that a 10.0 fee is deducted when a loan is issued.

This results in an error:
```java
public void loan(double amount) {
    if (amount <= loanLimit) {
        balance += amount - 10.0;
    }
}
```