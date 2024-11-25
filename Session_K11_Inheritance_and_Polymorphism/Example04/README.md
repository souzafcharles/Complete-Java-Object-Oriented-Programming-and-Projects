# Example04

**Instructions**: Consider a banking business that has a standard account, business account and savings account. The
business account and savings account includes all members from the standard account, along with a loan limit and a
function to issue loans.

## Step 01:

### Example - Final Class

Suppose you want to prevent subclasses from being created for SavingsAccount.

### SavingsAccount:

```java
public final class SavingsAccount {
}
```

### Account Model

![Account Model](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Session_K11_Inheritance_and_Polymorphism/Example04/account-model.png)

## Step 02:

### Example - Final Method

Suppose you don't want the Withdraw method of SavingsAccount to be overridden.

### SavingsAccount:

```java

@Override
public final void withdraw(double amount) {
    balance -= amount;
}
```
