package Java_ControlFlow;
import java.util.*;
public class largest_of_3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter three Number");
        int num1=sc.nextInt();
        int num2=sc.nextInt();
        int num3=sc.nextInt();
        if(num1>=num2 &&num1>=num3){
            System.out.println("Is the first number the largest? : True");
        }
        else if(num2>num1&&num2>num3){
            System.out.println("Is the second number the largest?: True");
        }
        else{
           System.out.println("Is the third number the largest? True");
        }
        sc.close();

    }
}
