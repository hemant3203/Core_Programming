package Java_ControlFlow;

import java.util.Scanner;

public class factorial_02 {
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n factorial");
        int fact=1;
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
              fact=fact*i;
        }
        System.out.println("Factorial till n "+fact);
        sc.close();
     }
}
