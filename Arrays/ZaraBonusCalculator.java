package Arrays;

import java.util.Scanner;

public class ZaraBonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Declare arrays and variables
        final int EMPLOYEE_COUNT = 10;

        double[][] employeeData = new double[EMPLOYEE_COUNT][2]; // [][0] = salary, [][1] = years of service
        double[] bonusAmount = new double[EMPLOYEE_COUNT];
        double[] newSalary = new double[EMPLOYEE_COUNT];

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        // 2. Input salary and years of service with validation
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1));

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            System.out.print("Enter Years of Service: ");
            double years = sc.nextDouble();

            if (salary <= 0 || years < 0) {
                System.out.println("Invalid input. Salary must be positive and years must be non-negative.");
                i--; // retry input for current employee
            } else {
                employeeData[i][0] = salary;
                employeeData[i][1] = years;
            }
        }

        // 3. Calculate bonus, new salary and total values
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            double salary = employeeData[i][0];
            double years = employeeData[i][1];

            double bonus = (years > 5) ? salary * 0.05 : salary * 0.02;
            double updatedSalary = salary + bonus;

            bonusAmount[i] = bonus;
            newSalary[i] = updatedSalary;

            totalBonus += bonus;
            totalOldSalary += salary;
            totalNewSalary += updatedSalary;
        }

        // 4. Display per-employee details
        System.out.println("\n======= Employee Bonus Report =======");
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.printf("Employee %d:\n", i + 1);
            System.out.printf("  Old Salary: ₹%.2f\n", employeeData[i][0]);
            System.out.printf("  Years of Service: %.1f\n", employeeData[i][1]);
            System.out.printf("  Bonus: ₹%.2f\n", bonusAmount[i]);
            System.out.printf("  New Salary: ₹%.2f\n", newSalary[i]);
        }

        // 5. Display totals
        System.out.println("\n======= Zara Company Summary =======");
        System.out.printf("Total Bonus Paid: ₹%.2f\n", totalBonus);
        System.out.printf("Total Old Salary: ₹%.2f\n", totalOldSalary);
        System.out.printf("Total New Salary: ₹%.2f\n", totalNewSalary);

        sc.close();
    }
}
