package Built_in_Functions;

import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first date (yyyy-mm-dd): ");
        String firstInput = sc.nextLine();
        LocalDate firstDate = LocalDate.parse(firstInput);

        System.out.print("Enter second date (yyyy-mm-dd): ");
        String secondInput = sc.nextLine();
        LocalDate secondDate = LocalDate.parse(secondInput);

        if (firstDate.isBefore(secondDate)) {
            System.out.println("The first date is before the second date.");
        } else if (firstDate.isAfter(secondDate)) {
            System.out.println("The first date is after the second date.");
        } else if (firstDate.isEqual(secondDate)) {
            System.out.println("Both dates are the same.");
        }

        sc.close();
    }
}
