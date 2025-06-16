package Arrays;

import java.util.Scanner;

public class StudentGrades_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Take input for number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // 2. Create arrays for marks (2D), percentage (1D), and grades (1D)
        int[][] marks = new int[n][3]; // [n][0] = Physics, [n][1] = Chemistry, [n][2] = Math
        double[] percentage = new double[n];
        char[] grade = new char[n];

        // 3. Input marks with validation
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1) + ":");
            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Math";
                System.out.print(subject + ": ");
                int mark = sc.nextInt();
                if (mark < 0 || mark > 100) {
                    System.out.println("Invalid input! Please enter a number between 0 and 100.");
                    j--; // redo the current subject
                } else {
                    marks[i][j] = mark;
                }
            }
        }

        // 4. Calculate percentage and grade
        for (int i = 0; i < n; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3.0;

            if (percentage[i] >= 80)
                grade[i] = 'A';
            else if (percentage[i] >= 70)
                grade[i] = 'B';
            else if (percentage[i] >= 60)
                grade[i] = 'C';
            else if (percentage[i] >= 50)
                grade[i] = 'D';
            else if (percentage[i] >= 40)
                grade[i] = 'E';
            else
                grade[i] = 'R';
        }

        // 5. Display results
        System.out.println("\n===== Student Report =====");
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1) + " Details:");
            System.out.println("Physics: " + marks[i][0]);
            System.out.println("Chemistry: " + marks[i][1]);
            System.out.println("Math: " + marks[i][2]);
            System.out.printf("Percentage: %.2f%%\n", percentage[i]);
            System.out.println("Grade: " + grade[i]);
        }

        sc.close();
    }
}
