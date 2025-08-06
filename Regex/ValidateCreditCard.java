package Regex;

import java.util.Scanner;

public class ValidateCreditCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        if (number.matches("^4\\d{15}$")) {
            System.out.println("Valid Visa");
        } else if (number.matches("^5\\d{15}$")) {
            System.out.println("Valid MasterCard");
        } else {
            System.out.println("Invalid");
        }
        sc.close();
    }
}
