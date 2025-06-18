package Strings;

import java.util.Scanner;

public class compareString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(str1.equals(str2));
        sc.close();
    }
}
