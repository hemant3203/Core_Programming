package Strings.EXTRAS;

import java.util.Scanner;

public class ReplaceWordInSentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        String wordToReplace = sc.nextLine();
        String replacement = sc.nextLine();
        String result = sentence.replace(wordToReplace, replacement);
        System.out.println(result);
        sc.close();
    }
}
