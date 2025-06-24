package Strings.EXTRAS;

import java.util.Scanner;

public class RemoveDuplicatesFromString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String result = "";
        for (char ch : input.toCharArray()) {
            if (result.indexOf(ch) == -1) {
                result += ch;
            }
        }
        System.out.println(result);
        sc.close();
    }
}
