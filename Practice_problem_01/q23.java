package Practice_problem_01;

import java.util.Scanner;

public class q23 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of students
        int handshakes = (n * (n - 1)) / 2;
        System.out.println("The maximum number of handshakes is " + handshakes);
    sc.close();
    }
}
