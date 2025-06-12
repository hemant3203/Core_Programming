package Practice_problem_01;

import java.util.Scanner;

public class q20 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double salary = sc.nextDouble();
        double bonus = sc.nextDouble();
        double totalIncome = salary + bonus;
        System.out.println("The salary is INR " + salary + " and the bonus is INR " + bonus + ". Hence Total Income is INR " + totalIncome);
   sc.close();
    }
}
