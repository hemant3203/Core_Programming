package Methods;

import java.util.Arrays;
import java.util.Scanner;

public class PalindromeDuckChecker {

    public static int countDigits(int num) {
        return String.valueOf(num).length();
    }

    public static int[] storeDigits(int num) {
        int[] digits = new int[countDigits(num)];
        int i = digits.length - 1;
        while (num > 0) {
            digits[i--] = num % 10;
            num /= 10;
        }
        return digits;
    }

    public static int[] reverseDigits(int[] arr) {
        int[] rev = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            rev[i] = arr[arr.length - 1 - i];
        }
        return rev;
    }

    public static boolean isPalindrome(int[] arr) {
        return Arrays.equals(arr, reverseDigits(arr));
    }

    public static boolean isDuckNumber(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] digits = storeDigits(num);

        System.out.println("Palindrome: " + isPalindrome(digits));
        System.out.println("Duck Number: " + isDuckNumber(digits));
        sc.close();
    }
}
