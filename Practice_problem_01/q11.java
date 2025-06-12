package Practice_problem_01;

import java.util.Scanner;

public class q11 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Get distance in feet
        System.out.print("Enter distance in feet: ");
        double feet = sc.nextDouble();
        double yards = feet / 3;
        double miles = yards / 1760;
        System.out.printf("The distance in yards is %.2f while the distance in miles is %.2f\n", yards, miles);
     sc.close();   
    }
}
