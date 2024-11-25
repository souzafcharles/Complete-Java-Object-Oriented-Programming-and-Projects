# Example03

**Instructions**: Consider a banking business that has a standard account and a business account. The business account
includes all members from the standard account, along with a loan limit and a function to issue loans.

Assume that a withdrawal operation has a fee of 5.0. However, if the account is of the savings type, this fee should not
be charged.

How to solve this?

**Answer**: by overriding the withdraw method in the SavingsAccount subclass.

### Account Model

![Account Model](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/master/Session_K11_Inheritance_and_Polymorphism/Example03/account-model.png)

### Account:

```java
public void withdraw(double amount) {
    balance -= amount + 5.0;
}
```

### SavingsAccount:

```java

@Override
public void withdraw(double amount) {
    balance -= amount;
}
```