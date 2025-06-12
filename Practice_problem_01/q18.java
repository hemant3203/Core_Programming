package Practice_problem_01;

import java.util.Scanner;

public class q18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double perimeter = sc.nextDouble();
        double side = perimeter / 4; // Perimeter of square = 4 * side
        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);
    sc.close();
    }
}
