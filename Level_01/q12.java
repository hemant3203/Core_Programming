import java.util.Scanner;

public class q12 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base in cm: ");
        double base = sc.nextDouble();
        System.out.print("Enter height in cm: ");
        double height = sc.nextDouble();
        double areaCm = 0.5 * base * height;
        double areaInch = areaCm / 6.4516;
        System.out.println("Area in square cm is " + areaCm + " and in square inches is " + areaInch);
        sc.close();
    }
}
