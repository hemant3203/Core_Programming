import java.util.*;

public class DataStructureSearchComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 100000;
        Random rand = new Random();
        int[] array = new int[n];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int value = rand.nextInt(n * 10);
            array[i] = value;
            hashSet.add(value);
            treeSet.add(value);
        }

        System.out.print("Enter target value to search: ");
        int target = sc.nextInt();

        long startArray = System.nanoTime();
        boolean foundInArray = false;
        for (int num : array) {
            if (num == target) {
                foundInArray = true;
                break;
            }
        }
        long endArray = System.nanoTime();

        long startHashSet = System.nanoTime();
        boolean foundInHashSet = hashSet.contains(target);
        long endHashSet = System.nanoTime();

        long startTreeSet = System.nanoTime();
        boolean foundInTreeSet = treeSet.contains(target);
        long endTreeSet = System.nanoTime();

        System.out.println("\n--- Search Time Comparison (n = " + n + ") ---");
        System.out.println("Array Search: " + (foundInArray ? "Found" : "Not Found") + " in " + (endArray - startArray) + " ns");
        System.out.println("HashSet Search: " + (foundInHashSet ? "Found" : "Not Found") + " in " + (endHashSet - startHashSet) + " ns");
        System.out.println("TreeSet Search: " + (foundInTreeSet ? "Found" : "Not Found") + " in " + (endTreeSet - startTreeSet) + " ns");

        sc.close();
    }
}
