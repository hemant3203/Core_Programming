package Java_ControlFlow;
import java.util.*;
public class power_of_number {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        int power=sc.nextInt();
        int result=1,counter=0;
           while(counter!=power){
            result=result*number;
            counter++;
           }
           System.out.println(result);
           sc.close();
    }
}
