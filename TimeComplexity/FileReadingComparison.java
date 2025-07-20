import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileReadingComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full path of a large file (e.g., 500MB): ");
        String filePath = sc.nextLine();

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File does not exist.");
            sc.close();
            return;
        }

        long startFileReader = System.nanoTime();
        try (FileReader fr = new FileReader(file)) {
            while (fr.read() != -1) {
            }
        } catch (Exception e) {
            System.out.println("Error reading file using FileReader.");
        }
        long endFileReader = System.nanoTime();

        long startInputStreamReader = System.nanoTime();
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file))) {
            while (isr.read() != -1) {
            }
        } catch (Exception e) {
            System.out.println("Error reading file using InputStreamReader.");
        }
        long endInputStreamReader = System.nanoTime();

        System.out.println("\n--- File Reading Time Comparison ---");
        System.out.println("FileReader Time: " + ((endFileReader - startFileReader) / 1_000_000) + " ms");
        System.out.println("InputStreamReader Time: " + ((endInputStreamReader - startInputStreamReader) / 1_000_000) + " ms");

        sc.close();
    }
}
