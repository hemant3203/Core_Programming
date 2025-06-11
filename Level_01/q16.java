import java.util.*;
public class q16{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of Students");
        int N=sc.nextInt();
        System.out.println("Number of possible hand Shakes:"+(N*(N-1))/2);
        sc.close();
    }
}