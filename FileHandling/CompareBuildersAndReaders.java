package FileHandling;

import java.io.*;
// import java.util.Scanner;

public class CompareBuildersAndReaders {
    public static void main(String[] args) {
        int repetitions = 1_000_000;
        String word = "hello";

        long startSB = System.nanoTime();
        StringBuilder sbuilder = new StringBuilder();
        for (int i = 0; i < repetitions; i++) {
            sbuilder.append(word);
        }
        long endSB = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endSB - startSB) / 1_000_000 + " ms");

        long startSBF = System.nanoTime();
        StringBuffer sbuffer = new StringBuffer();
        for (int i = 0; i < repetitions; i++) {
            sbuffer.append(word);
        }
        long endSBF = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endSBF - startSBF) / 1_000_000 + " ms");

        String filePath = "largefile.txt";

        try {
            long startFR = System.nanoTime();
            FileReader fr = new FileReader(filePath);
            BufferedReader brFR = new BufferedReader(fr);

            int wordCountFR = 0;
            String lineFR;
            while ((lineFR = brFR.readLine()) != null) {
                String[] words = lineFR.trim().split("\\s+");
                if (!lineFR.trim().isEmpty()) {
                    wordCountFR += words.length;
                }
            }

            brFR.close();
            fr.close();
            long endFR = System.nanoTime();
            System.out.println("FileReader Word Count: " + wordCountFR);
            System.out.println("FileReader Time: " + (endFR - startFR) / 1_000_000 + " ms");

        } catch (IOException e) {
            System.out.println("Error reading file with FileReader: " + e.getMessage());
        }

        try {
            long startISR = System.nanoTime();
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader brISR = new BufferedReader(isr);

            int wordCountISR = 0;
            String lineISR;
            while ((lineISR = brISR.readLine()) != null) {
                String[] words = lineISR.trim().split("\\s+");
                if (!lineISR.trim().isEmpty()) {
                    wordCountISR += words.length;
                }
            }

            brISR.close();
            isr.close();
            fis.close();
            long endISR = System.nanoTime();
            System.out.println("InputStreamReader Word Count: " + wordCountISR);
            System.out.println("InputStreamReader Time: " + (endISR - startISR) / 1_000_000 + " ms");

        } catch (IOException e) {
            System.out.println("Error reading file with InputStreamReader: " + e.getMessage());
        }
    }
}
