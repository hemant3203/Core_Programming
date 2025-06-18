package Strings;

import java.util.Scanner;

public class IllegalArgumentExample{
    public static void generateException(String input) {
        String result = input.substring(5, 2); // Start index > end index
        System.out.println("Substring: " + result);
    }

    public static void handleIllegalArgumentException(String input) {
        try {
            String result = input.substring(5, 2); // Invalid indices
            System.out.println("Substring: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: start index is greater than end index.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        // generateException(text); // this line Will Genreate the exception
        handleIllegalArgumentException(text);
        sc.close();
    }
}
