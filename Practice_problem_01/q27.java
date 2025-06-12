package Practice_problem_01;

import java.util.Scanner;

public class q27 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int temp = number1;
        number1 = number2;
        number2 = temp;
        System.out.println("The swapped numbers are " + number1 + " and " + number2);
    sc.close();
    }
}
