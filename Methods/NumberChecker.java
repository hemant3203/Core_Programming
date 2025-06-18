package Methods;
import java.util.Scanner;

public class NumberChecker {
    public static int countDigits(int n) {
        return String.valueOf(n).length();
    }

    public static int[] getDigits(int n) {
        String s = String.valueOf(n);
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) arr[i] = s.charAt(i) - '0';
        return arr;
    }

    public static boolean isDuck(int[] arr) {
        for (int i = 1; i < arr.length; i++) if (arr[i] == 0) return true;
        return false;
    }

    public static boolean isArmstrong(int n, int[] arr) {
        int sum = 0;
        for (int d : arr) sum += Math.pow(d, arr.length);
        return sum == n;
    }

    public static int[] largestTwo(int[] arr) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int n : arr) {
            if (n > first) {
                second = first;
                first = n;
            } else if (n > second && n != first) {
                second = n;
            }
        }
        return new int[]{first, second};
    }

    public static int[] smallestTwo(int[] arr) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int n : arr) {
            if (n < first) {
                second = first;
                first = n;
            } else if (n < second && n != first) {
                second = n;
            }
        }
        return new int[]{first, second};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] digits = getDigits(n);

        System.out.println("Digits: " + digits.length);
        System.out.println("Duck: " + isDuck(digits));
        System.out.println("Armstrong: " + isArmstrong(n, digits));
        int[] max2 = largestTwo(digits);
        System.out.println("Max1: " + max2[0] + ", Max2: " + max2[1]);
        int[] min2 = smallestTwo(digits);
        System.out.println("Min1: " + min2[0] + ", Min2: " + min2[1]);
        sc.close();
    }
}
