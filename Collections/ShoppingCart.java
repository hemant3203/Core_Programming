package Collections;

import java.util.*;

public class ShoppingCart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Double> priceMap = new HashMap<>();
        Map<String, Double> orderedCart = new LinkedHashMap<>();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String product = sc.nextLine();
            double price = Double.parseDouble(sc.nextLine());
            priceMap.put(product, price);
            orderedCart.put(product, price);
        }

        TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>();
        for (Map.Entry<String, Double> entry : orderedCart.entrySet()) {
            sortedByPrice.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }

        System.out.println("Products in insertion order:");
        for (Map.Entry<String, Double> entry : orderedCart.entrySet()) {
            System.out.println(entry.getKey() + " - $" + entry.getValue());
        }

        System.out.println("Products sorted by price:");
        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            for (String item : entry.getValue()) {
                System.out.println(item + " - $" + entry.getKey());
            }
        }

        sc.close();
    }
}

