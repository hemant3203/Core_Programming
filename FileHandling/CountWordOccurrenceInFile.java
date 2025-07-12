package FileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountWordOccurrenceInFile {
    public static void main(String[] args) {
        String filePath = "input.txt";
        String targetWord = "hello";
        int count = 0;

        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equals(targetWord)) {
                        count++;
                    }
                }
            }

            br.close();
            fr.close();

            System.out.println("Occurrences of word \"" + targetWord + "\": " + count);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
