package Regex;

import java.util.Scanner;

public class ValidateSSN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.matches("^\\d{3}-\\d{2}-\\d{4}$")) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
        sc.close();
    }
}
