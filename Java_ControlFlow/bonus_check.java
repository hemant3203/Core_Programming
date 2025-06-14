package Java_ControlFlow;
import java.util.*;

public class bonus_check {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double salary = sc.nextDouble();
        int yearsOfService = sc.nextInt();
        double bonus = 0;

        if (yearsOfService > 5) {
            bonus = 0.05 * salary;
        }

        System.out.println(bonus);
        sc.close();
    }
}
