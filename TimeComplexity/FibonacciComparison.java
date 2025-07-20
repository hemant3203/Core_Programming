import java.util.Scanner;

public class FibonacciComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of N (e.g., 30): ");
        int n = sc.nextInt();

        long startRecursive = System.nanoTime();
        int resultRecursive = fibonacciRecursive(n);
        long endRecursive = System.nanoTime();

        long startIterative = System.nanoTime();
        int resultIterative = fibonacciIterative(n);
        long endIterative = System.nanoTime();

        System.out.println("\n--- Fibonacci Computation Comparison ---");
        System.out.println("Recursive Result: " + resultRecursive);
        System.out.println("Time: " + ((endRecursive - startRecursive) / 1_000_000.0) + " ms");

        System.out.println("Iterative Result: " + resultIterative);
        System.out.println("Time: " + ((endIterative - startIterative) / 1_000_000.0) + " ms");

        sc.close();
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
