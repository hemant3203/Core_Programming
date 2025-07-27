package Collections;
import java.util.*;
import java.time.*;

class Policy {
    String policyNumber;
    String holderName;
    LocalDate expiryDate;

    Policy(String policyNumber, String holderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
    }

    String getPolicyNumber() {
        return policyNumber;
    }

    String getHolderName() {
        return holderName;
    }

    LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String toString() {
        return policyNumber + " - " + holderName + " - " + expiryDate;
    }
}

public class InsurancePolicySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Policy> hashMap = new HashMap<>();
        Map<String, Policy> linkedMap = new LinkedHashMap<>();
        TreeMap<LocalDate, List<Policy>> treeMap = new TreeMap<>();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String policyNumber = sc.nextLine();
            String holderName = sc.nextLine();
            LocalDate expiry = LocalDate.parse(sc.nextLine());
            Policy p = new Policy(policyNumber, holderName, expiry);

            hashMap.put(policyNumber, p);
            linkedMap.put(policyNumber, p);
            treeMap.computeIfAbsent(expiry, k -> new ArrayList<>()).add(p);
        }

        String queryPolicyNumber = sc.nextLine();
        if (hashMap.containsKey(queryPolicyNumber)) {
            System.out.println(hashMap.get(queryPolicyNumber));
        }

        LocalDate now = LocalDate.now();
        System.out.println("Expiring in next 30 days:");
        for (Map.Entry<LocalDate, List<Policy>> entry : treeMap.subMap(now, now.plusDays(30)).entrySet()) {
            for (Policy p : entry.getValue()) {
                System.out.println(p);
            }
        }

        String searchHolder = sc.nextLine();
        for (Policy p : linkedMap.values()) {
            if (p.getHolderName().equalsIgnoreCase(searchHolder)) {
                System.out.println(p);
            }
        }

        System.out.println("Removing expired policies:");
        Iterator<Map.Entry<String, Policy>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Policy> entry = it.next();
            if (entry.getValue().getExpiryDate().isBefore(now)) {
                System.out.println("Removed: " + entry.getValue());
                it.remove();
            }
        }

        sc.close();
    }
}
