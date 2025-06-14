package Java_ControlFlow;
import java.util.*;

public class age_height_check {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ageAmar = sc.nextInt();
        int heightAmar = sc.nextInt();
        int ageAkbar = sc.nextInt();
        int heightAkbar = sc.nextInt();
        int ageAnthony = sc.nextInt();
        int heightAnthony = sc.nextInt();

        int youngestAge = ageAmar;
        if (ageAkbar < youngestAge) {
            youngestAge = ageAkbar;
        }
        if (ageAnthony < youngestAge) {
            youngestAge = ageAnthony;
        }

        int tallestHeight = heightAmar;
        if (heightAkbar > tallestHeight) {
            tallestHeight = heightAkbar;
        }
        if (heightAnthony > tallestHeight) {
            tallestHeight = heightAnthony;
        }

        System.out.println(youngestAge);
        System.out.println(tallestHeight);
        sc.close();
    }
}
