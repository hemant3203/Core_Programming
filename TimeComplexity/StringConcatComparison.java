import java.util.Scanner;

public class StringConcatComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 1_000_000;
        String text = "a";

        long startString = System.nanoTime();
        String resultString = "";
        for (int i = 0; i < n; i++) {
            resultString += text;
        }
        long endString = System.nanoTime();

        long startBuilder = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(text);
        }
        long endBuilder = System.nanoTime();

        long startBuffer = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbf.append(text);
        }
        long endBuffer = System.nanoTime();

        System.out.println("\n--- String Concatenation Performance (n = " + n + ") ---");
        System.out.println("Using String: " + ((endString - startString) / 1_000_000) + " ms");
        System.out.println("Using StringBuilder: " + ((endBuilder - startBuilder) / 1_000_000) + " ms");
        System.out.println("Using StringBuffer: " + ((endBuffer - startBuffer) / 1_000_000) + " ms");

        sc.close();
    }
}
