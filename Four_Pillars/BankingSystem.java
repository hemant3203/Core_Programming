package Four_Pillars;

import java.util.Scanner;

interface Loanable {
    boolean applyForLoan();
    double calculateLoanEligibility();
}

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public abstract double calculateInterest();
}

class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public double calculateInterest() {
        return getBalance() * 0.04;
    }

    public boolean applyForLoan() {
        return getBalance() > 1000;
    }

    public double calculateLoanEligibility() {
        return getBalance() * 2;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public double calculateInterest() {
        return 0;
    }

    public boolean applyForLoan() {
        return getBalance() > 5000;
    }

    public double calculateLoanEligibility() {
        return getBalance() * 1.5;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankAccount[] accounts = new BankAccount[2];

        accounts[0] = new SavingsAccount("S123", "Alice", 5000);
        accounts[1] = new CurrentAccount("C456", "Bob", 10000);

        for (BankAccount acc : accounts) {
            System.out.println("Account Holder: " + acc.getHolderName());
            System.out.println("Interest: ₹" + acc.calculateInterest());
            if (acc instanceof Loanable) {
                Loanable loan = (Loanable) acc;
                System.out.println("Loan Eligible: " + loan.applyForLoan());
                System.out.println("Loan Amount: ₹" + loan.calculateLoanEligibility());
            }
            System.out.println();
        }

        sc.close();
    }
}
