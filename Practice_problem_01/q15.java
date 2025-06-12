package Practice_problem_01;

import java.util.Scanner;

public class q15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float number1 = sc.nextFloat();
        float number2 = sc.nextFloat();
        System.out.println("The addition, subtraction, multiplication, and division value of 2 numbers " + number1 + " and " + number2 +
                " is " + (number1 + number2) + ", " + (number1 - number2) + ", " + (number1 * number2) + ", and " + (number1 / number2));
    sc.close();
            }
}
