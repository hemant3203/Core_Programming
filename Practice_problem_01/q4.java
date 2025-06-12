package Practice_problem_01;

import java.util.Scanner;

public class q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking distance in km as input from user
        System.out.print("Enter distance in kilometers: ");
        double km = sc.nextDouble();
        // 1 mile = 1.6 km
        double miles = km / 1.6;
        sc.close();
        System.out.printf("The total miles is %.2f mile for the given %.2f km\n", miles, km);
    }
}
