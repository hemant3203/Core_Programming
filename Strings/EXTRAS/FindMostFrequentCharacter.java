package Strings.EXTRAS;

import java.util.Scanner;

public class FindMostFrequentCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] freq = new int[256];
        for (char ch : input.toCharArray()) {
            freq[ch]++;
        }
        int max = 0;
        char maxChar = ' ';
        for (char ch : input.toCharArray()) {
            if (freq[ch] > max) {
                max = freq[ch];
                maxChar = ch;
            }
        }
        System.out.println("Most Frequent Character: '" + maxChar + "'");
        sc.close();
    }
}
