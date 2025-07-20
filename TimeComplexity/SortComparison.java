import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10000;

        int[] original = new int[n];
        Random rand = new Random();

        
        for (int i = 0; i < n; i++) {
            original[i] = rand.nextInt(n * 10);
        }

       
        int[] bubbleArray = Arrays.copyOf(original, n);
        int[] mergeArray = Arrays.copyOf(original, n);
        int[] quickArray = Arrays.copyOf(original, n);

        
        long startBubble = System.nanoTime();
        bubbleSort(bubbleArray);
        long endBubble = System.nanoTime();

       
        long startMerge = System.nanoTime();
        mergeSort(mergeArray, 0, n - 1);
        long endMerge = System.nanoTime();

       
        long startQuick = System.nanoTime();
        quickSort(quickArray, 0, n - 1);
        long endQuick = System.nanoTime();

        
        System.out.println("\n--- Sorting Time Comparison (n = " + n + ") ---");
        System.out.println("Bubble Sort Time: " + (endBubble - startBubble) + " ns");
        System.out.println("Merge Sort Time: " + (endMerge - startMerge) + " ns");
        System.out.println("Quick Sort Time: " + (endQuick - startQuick) + " ns");

        sc.close();
    }


    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                  
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; 
        }
    }

    
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1; 
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
               
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
