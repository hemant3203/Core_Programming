import java.util.*;

@FunctionalInterface
interface Sumcal{
    int cal(int a,int b);
}


public class square{
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Number :");
        int a=sc.nextInt();
        int b=sc.nextInt();
      Sumcal s=(x,y)-> x+y;
    //   Squarecal c=(n)->n*n*n;
      int ans=s.cal(a,b);
    //   int res=c.cal(a);
      System.out.println("Square of "+a+" is : " +ans);
    //   System.out.println("Cube of "+a+" is : "+ res);
      sc.close();
    }
}