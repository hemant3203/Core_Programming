package Practice_problem_01;

import java.util.Scanner;

public class q17 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double base = sc.nextDouble();
        double height = sc.nextDouble();
        double areaCm2 = 0.5 * base * height;
        double areaIn2 = areaCm2 / (2.54 * 2.54); // converting cm^2 to in^2
        System.out.println("The Area of the triangle in sq in is " + areaIn2 + " and sq cm is " + areaCm2);
    sc.close();
    }
}
