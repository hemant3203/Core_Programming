package Java_ControlFlow;
import java.util.*;

public class power_calc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int power = sc.nextInt();
        int result = 1;

        for (int i = 1; i <= power; i++) {
            result = result * number;
        }

        System.out.println(result);
        sc.close();
    }
}
