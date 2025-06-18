package Strings;

import java.util.Scanner;

public class LowercaseCompare {

    public static String convertToLowerCase(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32);
            }
            result += ch;
        }
        return result;
    }

    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String lowerBuiltIn = input.toLowerCase();
        String lowerCustom = convertToLowerCase(input);
        boolean result = compareStrings(lowerBuiltIn, lowerCustom);
        System.out.println("Converted using custom method: " + lowerCustom);
        System.out.println("Comparison result: " + result);
        sc.close();
    }
}
