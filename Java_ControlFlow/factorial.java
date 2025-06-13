package Java_ControlFlow;
import java.util.*;
public class factorial {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n factorial");
        int n=sc.nextInt();
        int cal=1;
        while(n>=1){
             cal=cal*n;
             n--;
        }
        System.out.println(cal);
        sc.close();
    }
}
