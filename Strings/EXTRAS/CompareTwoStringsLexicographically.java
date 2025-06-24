package Strings.EXTRAS;

import java.util.Scanner;

public class CompareTwoStringsLexicographically {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int minLength = Math.min(s1.length(), s2.length());
        boolean compared = false;
        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                System.out.println(s1 + " comes before " + s2);
                compared = true;
                break;
            } else if (s1.charAt(i) > s2.charAt(i)) {
                System.out.println(s2 + " comes before " + s1);
                compared = true;
                break;
            }
        }
        if (!compared) {
            if (s1.length() < s2.length()) {
                System.out.println(s1 + " comes before " + s2);
            } else if (s1.length() > s2.length()) {
                System.out.println(s2 + " comes before " + s1);
            } else {
                System.out.println("Both strings are equal");
            }
        }
        sc.close();
    }
}
