package Strings;

import java.util.Scanner;

public class VowelConsonantCounter{

    public static String checkCharType(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }

    public static int[] countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        int i = 0;
        try {
            while (true) {
                char ch = text.charAt(i);
                String result = checkCharType(ch);
                if (result.equals("Vowel")) vowels++;
                else if (result.equals("Consonant")) consonants++;
                i++;
            }
        } catch (Exception e) {
            return new int[]{vowels, consonants};
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] counts = countVowelsAndConsonants(input);
        System.out.println("Vowels: " + counts[0]);
        System.out.println("Consonants: " + counts[1]);
        sc.close();
    }
}
