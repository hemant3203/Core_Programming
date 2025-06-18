package Strings;

import java.util.*;

public class ArraysIndexOutOfBounds {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];

        for(int i = 0;i<n;i++){
            str[i] = sc.next();
        }

        handleException(str);
        
        generateException(str);
        
        
        
        sc.close();
        }

        
        private static void generateException(String [] str) {
        System.out.println("\nGenerating exception...");
        System.out.println(str[str.length + 1]); 
        }

        
        private static void handleException(String [] str) {
        System.out.println("\nHandling exception...");
        try {
            System.out.println(str[str.length + 1]);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e.getMessage());
            System.out.println("Cannot access index beyond string length");
        }
    }
}
