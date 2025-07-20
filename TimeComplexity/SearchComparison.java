package TimeComplexity;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SearchComparison{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 10000;
        int[] data = new int[n];
        Random rand = new Random();

        
        for (int i = 0; i < n; i++) {
            data[i] = rand.nextInt(n * 10);  
        }

        
        System.out.print("Enter target value to search: ");
        int target = sc.nextInt();

       
        long startLinear = System.nanoTime();
        int linearResult = linearSearch(data, target);
        long endLinear = System.nanoTime();


        Arrays.sort(data);
        long startBinary = System.nanoTime();
        int binaryResult = binarySearch(data, target);
        long endBinary = System.nanoTime();

    
        System.out.println("\n--- Search Results ---");
        System.out.println("Linear Search: " + (linearResult != -1 ? "Found at index " + linearResult : "Not found"));
        System.out.println("Time taken: " + (endLinear - startLinear) + " ns");

        System.out.println("Binary Search: " + (binaryResult != -1 ? "Found at index " + binaryResult : "Not found"));
        System.out.println("Time taken (including sorting): " + (endBinary - startBinary) + " ns");

        sc.close();
    }


    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }


    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}
