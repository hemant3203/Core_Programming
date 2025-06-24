package ClassAndObject.Level_01;
import java.util.Scanner;

class Circle {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double getArea() {
        return Math.PI * radius * radius;
    }

    double getCircumference() {
        return 2 * Math.PI * radius;
    }

    void displayDetails() {
        System.out.println("Area: " + getArea() + ", Circumference: " + getCircumference());
    }
}

public class CircleDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double radius = sc.nextDouble();
        Circle circle = new Circle(radius);
        circle.displayDetails();
        sc.close();
    }
}
