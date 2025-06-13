package Java_ControlFlow;
import java.util.*;
public class sum_natural {
    public static void main(String[] args) {
        Scanner sc=new Scanner("System.in");
        int n=sc.nextInt();
        int a=n;
        int sum=0;
        while(a>=0){
            sum=sum+a;
            a--;
        }
        int formula=n*(n+1)/2;
        
        if(sum==formula){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
        sc.close();
    }
}
