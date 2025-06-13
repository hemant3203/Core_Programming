package Java_ControlFlow;
import java.util.*;
public class check_the_natural {
    public static void main(String[] args) {
        Scanner sc=new Scanner("System.in");
        int n=sc.nextInt();
        if(n<=0){
            System.out.println("The number" +n+" is not a natural number");

        }
        else{
            System.out.println("The sum of "+n+"natural number is "+n*(n+1)/2 );
        }
        sc.close();
    }
}
