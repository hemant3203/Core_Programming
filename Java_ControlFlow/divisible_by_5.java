package Java_ControlFlow;
import java.util.*;
public class divisible_by_5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a  number to check");
        int n=sc.nextInt();
        if(n%5==0){
            System.out.println("Is the number "+n+"divisible by 5? TRUE");
        }
        else{
             System.out.println("Is the number "+n+"divisible by 5? FALSE");
        }
        sc.close();
    }
}
