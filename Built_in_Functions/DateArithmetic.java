package Built_in_Functions;

import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a date (yyyy-mm-dd): ");
        String input = sc.nextLine();
        LocalDate date = LocalDate.parse(input);

        LocalDate updatedDate = date.plusDays(7).plusMonths(1).plusYears(2);
        LocalDate finalDate = updatedDate.minusWeeks(3);

        System.out.println("Original Date: " + date);
        System.out.println("After additions: " + updatedDate);
        System.out.println("Final Date after subtracting 3 weeks: " + finalDate);

        sc.close();
    }
}
