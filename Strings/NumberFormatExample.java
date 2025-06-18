package Strings;

import java.util.Scanner;

public class NumberFormatExample {

    public static void generateException(String text) {
        int number = Integer.parseInt(text); 
        System.out.println("Parsed number: " + number);
    }

    public static void handleNumberFormatException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: input is not a valid integer.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        // generateException(input); // Uncomment to check the  actual exception
        handleNumberFormatException(input);
        sc.close();
    }
}
