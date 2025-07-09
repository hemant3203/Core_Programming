package Stack_and_queue;
import java.util.Scanner;
import java.util.Stack;

public class ImplementaQueueUsingStacks {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int x) {
        stack1.push(x);
    }

    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) return -1;
        return stack2.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ImplementaQueueUsingStacks q = new ImplementaQueueUsingStacks();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String op = sc.next();
            if (op.equals("enqueue")) {
                int x = sc.nextInt();
                q.enqueue(x);
            } else if (op.equals("dequeue")) {
                System.out.println(q.dequeue());
            }
        }
        sc.close();
    }
}
