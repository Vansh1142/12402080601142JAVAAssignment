// Problem statement:
//Demonstrate a BankAccount class in Java that performs basic banking operations such as deposit, withdraw, and balance inquiry.

import java.util.Scanner;

class BankAccount {

    String name;      // Account holder's name
    double balance;   // Current account balance

    // Constructor to initialize account with name and balance
    BankAccount(String n, double b) {
        name = n;
        balance = b;
    }

    // Method to deposit money into account
    void deposit(double amt) {
        if (amt <= 0) { // check for invalid deposit
            System.out.println("Enter valid amount");
        } else {
            balance = balance + amt; // add to balance
            System.out.println("Deposited: " + amt + "  New Balance: " + balance);
        }
    }

    // Method to withdraw money from account
    void withdraw(double amt) {
        if (amt > balance) { // check for insufficient funds
            System.out.println("Insufficient balance!");
        } else {
            balance = balance - amt; // subtract from balance
            System.out.println("Withdrawn: " + amt + "  New Balance: " + balance);
        }
    }

    // Method to display account details
    void checkBalance() {
        System.out.println("Account Holder: " + name + "  Balance: " + balance);
    }

    // Main method to test BankAccount class
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input account holder name
        System.out.print("Enter account holder name: ");
        String aName = sc.nextLine();

        // Input initial balance
        System.out.print("Enter initial balance: ");
        double initBal = sc.nextDouble();

        // Create BankAccount object
        BankAccount acc = new BankAccount(aName, initBal);

        // Show initial balance
        acc.checkBalance();

        // Deposit money
        System.out.print("Enter deposit amount: ");
        double dep = sc.nextDouble();
        acc.deposit(dep);

        // Withdraw money
        System.out.print("Enter withdraw amount: ");
        double wit = sc.nextDouble();
        acc.withdraw(wit);

        // Final balance check
        acc.checkBalance();

        sc.close();
    }
}
