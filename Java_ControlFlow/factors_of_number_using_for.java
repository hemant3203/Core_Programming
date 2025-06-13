package Java_ControlFlow;
import java.util.*;

public class factors_of_number_using_for {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    System.out.println(i);
                }
            }
        }

        sc.close();
    }
}
