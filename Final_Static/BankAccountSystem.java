package Final_Static;
import java.util.Scanner;

class BankAccount {
    static String bankName;
    private static int totalAccounts = 0;
    private String accountHolderName;
    private final int accountNumber;

    BankAccount(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    static int getTotalAccounts() {
        return totalAccounts;
    }

    void displayDetails() {
        System.out.println("Bank: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
    }
}

public class BankAccountSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Bank Name: ");
        BankAccount.bankName = sc.nextLine();

        System.out.print("Enter number of accounts to create: ");
        int n = sc.nextInt();
        sc.nextLine();

        BankAccount[] accounts = new BankAccount[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Account Holder Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Account Number: ");
            int accNo = sc.nextInt();
            sc.nextLine();
            accounts[i] = new BankAccount(name, accNo);
        }

        System.out.println("Total accounts created: " + BankAccount.getTotalAccounts());

        for (BankAccount account : accounts) {
            if (account instanceof BankAccount) {
                account.displayDetails();
            }
        }

        sc.close();
    }
}
