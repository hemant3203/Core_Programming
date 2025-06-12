package Practice_problem_01;

import java.util.Scanner;

public class q25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chocolates = sc.nextInt();
        int children = sc.nextInt();
        int eachGets = chocolates / children;
        int remaining = chocolates % children;
        System.out.println("The number of chocolates each child gets is " + eachGets + " and the number of remaining chocolates is " + remaining);
    sc.close();
    }
}
