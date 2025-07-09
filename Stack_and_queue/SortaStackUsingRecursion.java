package Stack_and_queue;
import java.util.Scanner;
import java.util.Stack;

public class SortaStackUsingRecursion {
    public static void sort(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sort(stack);
            insert(stack, temp);
        }
    }

    private static void insert(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }
        int temp = stack.pop();
        insert(stack, element);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }
        sort(stack);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        sc.close();
    }
}
