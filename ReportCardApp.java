import java.util.*;

class InvalidMarkException extends Exception {
    public InvalidMarkException(String message) {
        super(message);
    }
}

class Student {
    String name;
    String[] subjects;
    int[] marks;

    public Student(String name, String[] subjects, int[] marks) throws InvalidMarkException {
        this.name = name;
        this.subjects = subjects;
        this.marks = new int[marks.length];
        
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 0 || marks[i] > 100) {
                throw new InvalidMarkException("Marks must be between 0 and 100. Invalid mark: " + marks[i]);
            }
            this.marks[i] = marks[i];
        }
    }

    public double calculateAverage() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }

    public String assignGrade(double average) {
        if (average >= 90) return "A+";
        else if (average >= 80) return "A";
        else if (average >= 70) return "B";
        else if (average >= 60) return "C";
        else if (average >= 50) return "D";
        else return "F";
    }

    public void displayReportCard() {
        System.out.println("=====================================");
        System.out.println("Student Name: " + name);
        System.out.println("-------------------------------------");
        System.out.printf("%-15s%-10s\n", "Subject", "Marks");
        System.out.println("-------------------------------------");
        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("%-15s%-10d\n", subjects[i], marks[i]);
        }
        double avg = calculateAverage();
        System.out.println("-------------------------------------");
        System.out.printf("Average: %.2f\n", avg);
        System.out.println("Grade: " + assignGrade(avg));
        System.out.println("=====================================\n");
    }
}

public class ReportCardApp {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            try {
                System.out.print("Enter student name: ");
                String name = sc.nextLine();

                System.out.print("Enter number of subjects: ");
                int subCount = sc.nextInt();
                sc.nextLine();

                String[] subjects = new String[subCount];
                int[] marks = new int[subCount];

                for (int j = 0; j < subCount; j++) {
                    System.out.print("Enter subject " + (j + 1) + " name: ");
                    subjects[j] = sc.nextLine();
                    System.out.print("Enter marks for " + subjects[j] + ": ");
                    marks[j] = sc.nextInt();
                    sc.nextLine();
                }

                Student s = new Student(name, subjects, marks);
                students.add(s);

            } catch (InvalidMarkException e) {
                System.out.println("Error: " + e.getMessage());
                i--; 
            }
        }

        System.out.println("\n***** Report Cards *****\n");
        for (Student s : students) {
            s.displayReportCard();
        }

        sc.close();
    }
}