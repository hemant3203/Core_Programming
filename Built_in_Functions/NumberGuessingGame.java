package Built_in_Functions;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lowerBound = 1;
        int upperBound = 100;
        boolean guessedCorrectly = false;

        System.out.println("Think of a number between 1 and 100. I will try to guess it.");
        
        while (!guessedCorrectly && lowerBound <= upperBound) {
            int guess = generateGuess(lowerBound, upperBound);
            System.out.println("Is your number " + guess + "?");
            System.out.print("Enter 'high' if my guess is too high, 'low' if it's too low, or 'correct' if I guessed it: ");
            String feedback = getUserFeedback(sc);

            if (feedback.equals("correct")) {
                System.out.println("Yay! I guessed your number correctly.");
                guessedCorrectly = true;
            } else if (feedback.equals("high")) {
                upperBound = guess - 1;
            } else if (feedback.equals("low")) {
                lowerBound = guess + 1;
            }
        }

        if (!guessedCorrectly) {
            System.out.println("Hmm, something went wrong. Did you give consistent feedback?");
        }

        sc.close();
    }

    public static int generateGuess(int lower, int upper) {
        Random rand = new Random();
        return rand.nextInt(upper - lower + 1) + lower;
    }

    public static String getUserFeedback(Scanner sc) {
        String input = sc.nextLine().trim().toLowerCase();
        while (!input.equals("high") && !input.equals("low") && !input.equals("correct")) {
            System.out.print("Invalid input. Please enter 'high', 'low', or 'correct': ");
            input = sc.nextLine().trim().toLowerCase();
        }
        return input;
    }
}
