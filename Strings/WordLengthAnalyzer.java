package Strings;

import java.util.Scanner;

public class WordLengthAnalyzer{

    public static String[] customSplit(String text) {
        int len = getLength(text);
        int wordCount = 1;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') wordCount++;
        }

        int[] spaceIndexes = new int[wordCount - 1];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') spaceIndexes[index++] = i;
        }

        String[] words = new String[wordCount];
        int start = 0;
        for (int i = 0; i < wordCount - 1; i++) {
            int end = spaceIndexes[i];
            String word = "";
            for (int j = start; j < end; j++) word += text.charAt(j);
            words[i] = word;
            start = end + 1;
        }

        String word = "";
        for (int i = start; i < len; i++) word += text.charAt(i);
        words[wordCount - 1] = word;

        return words;
    }

    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    public static String[][] getWordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    public static int[] getShortestAndLongest(String[][] wordLengths) {
        int minLen = Integer.parseInt(wordLengths[0][1]);
        int maxLen = Integer.parseInt(wordLengths[0][1]);
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < wordLengths.length; i++) {
            int len = Integer.parseInt(wordLengths[i][1]);
            if (len < minLen) {
                minLen = len;
                minIndex = i;
            }
            if (len > maxLen) {
                maxLen = len;
                maxIndex = i;
            }
        }

        return new int[]{minIndex, maxIndex};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = customSplit(text);
        String[][] wordLengths = getWordsWithLengths(words);
        int[] result = getShortestAndLongest(wordLengths);
        System.out.println("Shortest word: " + wordLengths[result[0]][0]);
        System.out.println("Longest word: " + wordLengths[result[1]][0]);
        sc.close();
    }
}
