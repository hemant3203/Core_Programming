package Methods;

import java.util.Random;

public class ZaraBonusCalculator {

    public static int[][] generateEmployeeData(int n) {
        Random rand = new Random();
        int[][] data = new int[n][2]; // salary, yearsOfService
        for (int i = 0; i < n; i++) {
            data[i][0] = 10000 + rand.nextInt(90000);
            data[i][1] = rand.nextInt(11);
        }
        return data;
    }

    public static double[][] calculateNewSalaryAndBonus(int[][] data) {
        double[][] result = new double[data.length][2]; // bonus, newSalary
        for (int i = 0; i < data.length; i++) {
            double bonus = data[i][1] > 5 ? data[i][0] * 0.05 : data[i][0] * 0.02;
            result[i][0] = bonus;
            result[i][1] = data[i][0] + bonus;
        }
        return result;
    }

    public static void displaySummary(int[][] original, double[][] updated) {
        int totalOld = 0;
        double totalNew = 0, totalBonus = 0;

        System.out.printf("%-10s %-10s %-12s %-12s %-12s%n", "Employee", "Salary", "Years", "Bonus", "New Salary");
        for (int i = 0; i < original.length; i++) {
            System.out.printf("%-10d %-10d %-12d %-12.2f %-12.2f%n", i + 1, original[i][0], original[i][1], updated[i][0], updated[i][1]);
            totalOld += original[i][0];
            totalBonus += updated[i][0];
            totalNew += updated[i][1];
        }

        System.out.println("\nTotal Old Salary: " + totalOld);
        System.out.println("Total Bonus: " + totalBonus);
        System.out.println("Total New Salary: " + totalNew);
    }

    public static void main(String[] args) {
        int[][] data = generateEmployeeData(10);
        double[][] updated = calculateNewSalaryAndBonus(data);
        displaySummary(data, updated);
    }
}
