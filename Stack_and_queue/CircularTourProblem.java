package Stack_and_queue;
import java.util.*;

public class CircularTourProblem {
    public static int tour(int[] petrol, int[] distance, int n) {
        int start = 0, curr_petrol = 0, prev_deficit = 0;
        for (int i = 0; i < n; i++) {
            curr_petrol += petrol[i] - distance[i];
            if (curr_petrol < 0) {
                start = i + 1;
                prev_deficit += curr_petrol;
                curr_petrol = 0;
            }
        }
        return (curr_petrol + prev_deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] petrol = new int[n];
        int[] distance = new int[n];
        for (int i = 0; i < n; i++) petrol[i] = sc.nextInt();
        for (int i = 0; i < n; i++) distance[i] = sc.nextInt();
        System.out.println(tour(petrol, distance, n));
        sc.close();
    }
}
