package Hash_map_and_functions;
import java.util.*;

public class TwoSumProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        int target = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i])) {
                System.out.println(map.get(target - nums[i]) + " " + i);
                sc.close();
                return;
            }
            map.put(nums[i], i);
        }
        System.out.println("No pair found");
        sc.close();
    }
}
