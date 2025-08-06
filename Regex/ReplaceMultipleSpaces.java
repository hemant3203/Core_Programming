package Regex;

import java.util.Scanner;

public class ReplaceMultipleSpaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String output = input.replaceAll("\\s+", " ");
        System.out.println(output);
        sc.close();
    }
}
