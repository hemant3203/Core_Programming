package Stack_and_queue;
import java.util.Scanner;
import java.util.Stack;

public class StockSpanProblem {
    public static void calculateSpan(int[] price, int n, int[] span) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        span[0] = 1;
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }
            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }
        int[] span = new int[n];
        calculateSpan(price, n, span);
        for (int x : span) {
            System.out.print(x + " ");
        }
        sc.close();
    }
}
