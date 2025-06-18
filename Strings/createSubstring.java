package String;

import java.util.Scanner;

public class createSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = sc.next();
        System.out.println("Enter start index: ");
        int start = sc.nextInt();
        System.out.println("Enter end index: ");
        int end = sc.nextInt();

        String subStringUsingCharAt = getSubstringUsingCharAt(str, start, end);
        System.out.println("Substring using charAt(): " + subStringUsingCharAt);

        String subStringUsingBuiltIn = str.substring(start, end);
        System.out.println("Substring using built-in method: " + subStringUsingBuiltIn);

        boolean areEqual = compareStrings(subStringUsingCharAt, subStringUsingBuiltIn);
        System.out.println("Are the substrings equal? " + areEqual);

        sc.close();
        }

        public static String getSubstringUsingCharAt(String str, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end && i < str.length(); i++) {
            result.append(str.charAt(i));
        }
        return result.toString();
        }

        public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
            return false;
            }
        }
        return true;
        
    }
}
