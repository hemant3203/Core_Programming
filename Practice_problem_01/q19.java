package Practice_problem_01;

import java.util.Scanner;

public class q19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double side1 = sc.nextDouble();
        double side2 = sc.nextDouble();
        double side3 = sc.nextDouble();
        double perimeter = side1 + side2 + side3;
        int rounds = (int)(5000 / perimeter); // 5km = 5000 meters
        System.out.println("The total number of rounds the athlete will run is " + rounds + " to complete 5 km");
    sc.close();
    }
}
