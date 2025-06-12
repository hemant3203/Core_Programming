package Practice_problem_01;

import java.util.Scanner;

public class q28 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double pounds = sc.nextDouble();
        double kilograms = pounds / 2.2; // 1 pound = 2.2 kg
        System.out.println("The weight of the person in pounds is " + pounds + " and in kg is " + kilograms);
    sc.close();
    }
}
