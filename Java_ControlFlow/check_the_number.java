package Java_ControlFlow;
import java.util.*;
public class check_the_number {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner("System.in");
        System.out.println("Enter the Number");
        int n=sc.nextInt();
        if(n>0){
            System.out.println("Number is Positive");
        }
        else if(n==0){
            System.out.println("Number is Zero");
        }
        else{
            System.out.println("Number is Negative");
        }
    
        sc.close();
    }

}
