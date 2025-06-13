package Java_ControlFlow;
import java.util.*;

public class springSeason {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter month and day in integer");
        int month=sc.nextInt();
        int day=sc.nextInt();
      if(month>=3 && month <=6){
        if(month==3&&day>=20){
            System.out.println("Spring Season");
        }
        else if(month==6&& day<=20){
            System.out.println("Spring Season");
        }
        else{
        System.out.println("Not a Spring Season");
      }
      }
      else{
        System.out.println("Not a Spring Season");
      }
      sc.close();
    }
}
