package Java_ControlFlow;
import java.util.*;
public class sum_tillzero {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double sum=0.0;
       while(true){
        double n=sc.nextDouble();
        sum=sum+n;
             if(n==0){
                break;
             }
       }
       System.out.println("sum till user input 0 is :"+sum);
       sc.close();
        
    }
}
