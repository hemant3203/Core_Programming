package ClassAndObject.Level_02;
import java.util.Scanner;

class PalindromeChecker {
    String text;

    PalindromeChecker(String text) {
        this.text = text;
    }

    boolean isPalindrome() {
        StringBuilder sb = new StringBuilder(text);
        return text.equals(sb.reverse().toString());
    }

    void displayResult() {
        System.out.println("Is Palindrome: " + isPalindrome());
    }
}

public class PalindromeCheckerMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        PalindromeChecker checker = new PalindromeChecker(text);
        checker.displayResult();
        sc.close();
    }
}
