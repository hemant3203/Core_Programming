package Strings;

import java.util.Scanner;

public class UpperCaseCompare{

    public static String convertToUpperCase(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - 32);
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
        String upperBuiltIn = input.toUpperCase();
        String upperCustom = convertToUpperCase(input);
        boolean result = compareStrings(upperBuiltIn, upperCustom);
        System.out.println("Converted using custom method: " + upperCustom);
        System.out.println("Comparison result: " + result);
        sc.close();
    }
}
