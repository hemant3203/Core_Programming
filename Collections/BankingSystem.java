package Collections;

import java.util.*;

public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Double> accounts = new HashMap<>();
        TreeMap<Double, List<String>> balanceSorted = new TreeMap<>();
        Queue<String> withdrawalQueue = new LinkedList<>();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String accNumber = sc.nextLine();
            double balance = Double.parseDouble(sc.nextLine());
            accounts.put(accNumber, balance);
            balanceSorted.computeIfAbsent(balance, k -> new ArrayList<>()).add(accNumber);
        }

        int q = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < q; i++) {
            String withdrawRequest = sc.nextLine();
            withdrawalQueue.add(withdrawRequest);
        }

        System.out.println("Processing withdrawals:");
        while (!withdrawalQueue.isEmpty()) {
            String acc = withdrawalQueue.poll();
            if (accounts.containsKey(acc)) {
                double bal = accounts.get(acc);
                if (bal >= 100) {
                    accounts.put(acc, bal - 100);
                    System.out.println("Withdrew $100 from " + acc + ", new balance: " + (bal - 100));
                } else {
                    System.out.println("Insufficient funds in account: " + acc);
                }
            } else {
                System.out.println("Invalid account: " + acc);
            }
        }

        System.out.println("Accounts sorted by balance:");
        for (Map.Entry<Double, List<String>> entry : balanceSorted.entrySet()) {
            for (String acc : entry.getValue()) {
                System.out.println(acc + " - $" + entry.getKey());
            }
        }

        sc.close();
    }
}
  
