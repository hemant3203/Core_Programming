package Strings;

import java.util.Scanner;

public class StringLengthFinder {

    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        //
        int customLength = getLength(input);
        int builtinLength = input.length();
        System.out.println("Custom length: " + customLength);
        System.out.println("Built-in length: " + builtinLength);
        sc.close();
    }
}
