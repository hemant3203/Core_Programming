package Strings.EXTRAS;

import java.util.Scanner;

public class FindSubstringOccurrences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mainStr = sc.nextLine();
        String subStr = sc.nextLine();
        int count = 0;
        int index = 0;
        while ((index = mainStr.indexOf(subStr, index)) != -1) {
            count++;
            index += subStr.length();
        }
        System.out.println(count);
        sc.close();
    }
}
