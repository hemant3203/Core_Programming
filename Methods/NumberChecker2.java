package Methods;
import java.util.*;

public class NumberChecker2 {
    public static int[] getDigits(int n) {
        String s = String.valueOf(n);
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) arr[i] = s.charAt(i) - '0';
        return arr;
    }

    public static int sumDigits(int[] arr) {
        int sum = 0;
        for (int d : arr) sum += d;
        return sum;
    }

    public static int sumSquares(int[] arr) {
        int sum = 0;
        for (int d : arr) sum += Math.pow(d, 2);
        return sum;
    }

    public static boolean isHarshad(int n, int[] arr) {
        return n % sumDigits(arr) == 0;
    }

    public static int[][] digitFrequency(int[] arr) {
        int[] freq = new int[10];
        for (int d : arr) freq[d]++;
        int[][] result = new int[10][2];
        for (int i = 0; i < 10; i++) {
            result[i][0] = i;
            result[i][1] = freq[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] digits = getDigits(n);
        System.out.println("Sum of Digits: " + sumDigits(digits));
        System.out.println("Sum of Squares: " + sumSquares(digits));
        System.out.println("Harshad: " + isHarshad(n, digits));
        int[][] freq = digitFrequency(digits);
        for (int[] row : freq) {
            if (row[1] > 0) System.out.println(row[0] + ": " + row[1]);
        }
        sc.close();
    }
}
