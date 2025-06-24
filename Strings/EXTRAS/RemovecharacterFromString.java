package Strings.EXTRAS;

import java.util.Scanner;

public class RemovecharacterFromString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char toRemove = sc.next().charAt(0);
        String result = "";
        for (char ch : input.toCharArray()) {
            if (ch != toRemove) {
                result += ch;
            }
        }
        System.out.println("Modified String: \"" + result + "\"");
        sc.close();
    }
}
