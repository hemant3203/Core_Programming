package ClassAndObject.Level_02;
import java.util.Scanner;

class BankAccount {
    String accountHolder;
    String accountNumber;
    double balance;

    BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    void displayBalance() {
        System.out.println("Account Holder: " + accountHolder + ", Account Number: " + accountNumber + ", Balance: " + balance);
    }
}

public class BankAccountSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String accountHolder = sc.nextLine();
        String accountNumber = sc.nextLine();
        double balance = sc.nextDouble();
        BankAccount account = new BankAccount(accountHolder, accountNumber, balance);
        int choice = sc.nextInt();
        if (choice == 1) {
            double amount = sc.nextDouble();
            account.deposit(amount);
        } else if (choice == 2) {
            double amount = sc.nextDouble();
            account.withdraw(amount);
        }
        account.displayBalance();
        sc.close();
    }
}
