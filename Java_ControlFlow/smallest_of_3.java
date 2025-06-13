package Java_ControlFlow;
import java.util.*;
public class smallest_of_3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter three number to be compare ");
        int num1=sc.nextInt();
        int num2=sc.nextInt();
        int num3=sc.nextInt();
        if(num1<num2&&num1<num3){
            System.out.println("Is the first number the smallest: YES" );
        }
        else{
             System.out.println("Is the first number the smallest: NO" );
        }
        sc.close();

    }
}
