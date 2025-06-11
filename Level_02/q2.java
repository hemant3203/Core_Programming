package Level_02;

import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base in cm: ");
        double base = sc.nextDouble();
        System.out.print("Enter height in cm: ");
        double height = sc.nextDouble();

        double area_cm2 = 0.5 * base * height;
        double area_in2 = area_cm2 / (2.54 * 2.54);

        System.out.println("The Area of the triangle in sq in is " + area_in2 + " and sq cm is " + area_cm2);
    sc.close();    
    }
}
