package JavaConstructor;

import java.util.Scanner;

class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

class PostgraduateStudent extends Student {
    String researchArea;

    public PostgraduateStudent(int rollNumber, String name, double CGPA, String researchArea) {
        super(rollNumber, name, CGPA);
        this.researchArea = researchArea;
    }

    public void displayPostgraduateDetails() {
        System.out.println("Postgraduate Student:");
        System.out.println("Name (accessed from protected): " + name);
        System.out.println("Research Area: " + researchArea);
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter CGPA: ");
        double cgpa = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter research area: ");
        String research = sc.nextLine();

        PostgraduateStudent pgStudent = new PostgraduateStudent(roll, name, cgpa, research);
        pgStudent.displayStudentDetails();
        pgStudent.displayPostgraduateDetails();

        sc.close();
    }
}
