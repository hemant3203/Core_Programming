package Strings;

import java.util.Scanner;

public class VowelConsonantIdentifier {

    public static String getCharType(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
        }

        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return "Vowel";
            else return "Consonant";
        }

        return "Not a Letter";
    }

    public static String[][] getCharDetails(String text) {
        int len = 0;
        try {
            while (true) {
                text.charAt(len);
                len++;
            }
        } catch (Exception e) {}

        String[][] result = new String[len][2];
        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = getCharType(ch);
        }
        return result;
    }

    public static void displayCharTable(String[][] data) {
        System.out.println("Char\tType");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[][] charDetails = getCharDetails(text);
        displayCharTable(charDetails);
        sc.close();
    }
}
