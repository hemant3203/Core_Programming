package Collections;

import java.util.*;

public class VotingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> voteMap = new HashMap<>();
        Map<String, Integer> orderedVotes = new LinkedHashMap<>();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String candidate = sc.nextLine();
            voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
            orderedVotes.put(candidate, orderedVotes.getOrDefault(candidate, 0) + 1);
        }

        System.out.println("Vote count:");
        for (Map.Entry<String, Integer> entry : voteMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        TreeMap<String, Integer> sortedVotes = new TreeMap<>(voteMap);
        System.out.println("Sorted result:");
        for (Map.Entry<String, Integer> entry : sortedVotes.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("Insertion order:");
        for (Map.Entry<String, Integer> entry : orderedVotes.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        sc.close();
    }
}

