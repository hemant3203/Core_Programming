package Java_ControlFlow;
import java.util.*;
public class rocket_launch {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter countdown");
        int n=sc.nextInt();
        for(int i=n;i>=0;i--){
            System.out.println("countdown:"+i);
        }
        sc.close();
    }
}
