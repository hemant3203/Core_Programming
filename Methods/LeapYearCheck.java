package Methods;

import java.util.Scanner;

public class LeapYearCheck {

    public static boolean isLeapYear(int year) {
        if (year < 1582) {
            return false;
        }
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = sc.nextInt();

        if (year < 1582) {
            System.out.println("The year must be 1582 or later.");
        } else if (isLeapYear(year)) {
            System.out.println("Leap Year");
        } else {
            System.out.println("Not a Leap Year");
        }

        sc.close();
    }
}
