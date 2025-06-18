package Strings;

import java.util.Scanner;

public class CustomTrimCompare {

    public static int[] findTrimIndexes(String text) {
        int start = 0;
        int end = -1;
        int length = 0;
        try {
            while (true) {
                text.charAt(length);
                length++;
            }
        } catch (Exception e) {
        }

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) != ' ') {
                start = i;
                break;
            }
        }

        for (int i = length - 1; i >= 0; i--) {
            if (text.charAt(i) != ' ') {
                end = i;
                break;
            }
        }

        return new int[]{start, end};
    }

    public static String customSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    public static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int[] indexes = findTrimIndexes(text);
        String trimmedCustom = customSubstring(text, indexes[0], indexes[1]);
        String trimmedBuiltIn = text.trim();
        boolean result = compareStrings(trimmedCustom, trimmedBuiltIn);
        System.out.println("Trimmed using custom method: " + trimmedCustom);
        System.out.println("Comparison result: " + result);
        sc.close();
    }
}
