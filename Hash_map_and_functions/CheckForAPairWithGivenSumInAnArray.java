package Hash_map_and_functions;
import java.util.*;

public class CheckForAPairWithGivenSumInAnArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int target = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        boolean found = false;
        for (int num : arr) {
            if (set.contains(target - num)) {
                found = true;
                break;
            }
            set.add(num);
        }
        System.out.println(found);
        sc.close();
    }
}
