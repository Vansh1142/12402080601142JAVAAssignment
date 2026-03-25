// Problem Statement:
// Custom exception for bank withdrawal

import java.util.Scanner;

// Custom exception for insufficient funds
class InsufficientFundsException extends Exception {
    double shortage; // amount short

    InsufficientFundsException(double shortage) {
        // Pass message to Exception class
        super("Insufficient funds! Short by: " + shortage);
        this.shortage = shortage;
    }
}

// Custom exception for invalid withdrawal amount
class InvalidAmountException extends Exception {
    InvalidAmountException(String msg) {
        super(msg); // Pass custom message to Exception class
    }
}

// SecureAccount class with withdrawal logic
class SecureAccount {

    String holder;   // Account holder name
    double balance;  // Current balance

    SecureAccount(String holder, double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    // Withdraw method with exception handling
    void withdraw(double amt) throws InsufficientFundsException, InvalidAmountException {
        if (amt <= 0) {
            // Negative or zero withdrawal not allowed
            throw new InvalidAmountException("Amount must be positive!");
        }
        if (amt > balance) {
            // Withdrawal greater than balance → insufficient funds
            double s = amt - balance;
            throw new InsufficientFundsException(s);
        }
        // Valid withdrawal
        balance = balance - amt;
        System.out.println("Withdrawn: " + amt + "  Remaining Balance: " + balance);
    }
}

// Main class to test custom exceptions
class CustomException {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create account
        System.out.print("Enter account holder name: ");
        String sName = sc.nextLine();
        System.out.print("Enter balance: ");
        double sBal = sc.nextDouble();

        SecureAccount sa = new SecureAccount(sName, sBal);

        // First withdrawal attempt
        System.out.print("Enter amount to withdraw: ");
        double w1 = sc.nextDouble();
        try {
            sa.withdraw(w1);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        }

        // Second withdrawal attempt
        System.out.print("Enter amount to withdraw: ");
        double w2 = sc.nextDouble();
        try {
            sa.withdraw(w2);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        }

        // Third withdrawal attempt
        System.out.print("Enter amount to withdraw: ");
        double w3 = sc.nextDouble();
        try {
            sa.withdraw(w3);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
