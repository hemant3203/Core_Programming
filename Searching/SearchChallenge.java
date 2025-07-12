package Searching;

import java.util.Arrays;

public class SearchChallenge {

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Replace negative numbers, zeros, and numbers > n by 1 (since missing positive <= n+1)
        boolean containsOne = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                containsOne = true;
            }
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        if (!containsOne) {
            return 1;
        }

        // Step 2: Use index as a hash key and mark presence by making nums[index] negative
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (val == n) {
                nums[0] = -Math.abs(nums[0]);  // use index 0 as special flag for number n
            } else {
                nums[val] = -Math.abs(nums[val]);
            }
        }

        // Step 3: Find first positive index
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }

        if (nums[0] > 0) {
            return n;
        }

        return n + 1;
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1, 6, 8, 2};
        int target = 4;

        int missing = firstMissingPositive(arr);
        System.out.println("First missing positive: " + missing);

        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);

        int targetIndex = binarySearch(sortedArr, target);
        System.out.println("Index of target (" + target + "): " + targetIndex);
    }
}
