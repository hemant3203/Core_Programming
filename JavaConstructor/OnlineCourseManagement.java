package JavaConstructor;

import java.util.Scanner;

class Course {
    String courseName;
    int duration;
    double fee;
    static String instituteName = "Default Institute";

    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: " + fee);
        System.out.println("Institute: " + instituteName);
    }

    static void updateInstituteName(String newName) {
        instituteName = newName;
    }
}

public class OnlineCourseManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter institute name: ");
        String instName = sc.nextLine();
        Course.updateInstituteName(instName);

        System.out.print("Enter number of courses: ");
        int n = sc.nextInt();
        sc.nextLine();

        Course[] courses = new Course[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter course name: ");
            String name = sc.nextLine();
            System.out.print("Enter duration in weeks: ");
            int duration = sc.nextInt();
            System.out.print("Enter fee: ");
            double fee = sc.nextDouble();
            sc.nextLine();
            courses[i] = new Course(name, duration, fee);
        }

        for (Course c : courses) {
            c.displayCourseDetails();
        }

        sc.close();
    }
}
