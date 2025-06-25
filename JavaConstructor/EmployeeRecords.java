package JavaConstructor;

import java.util.Scanner;

class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        if (salary > 0)
            this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void displayManagerInfo() {
        System.out.println("Employee ID (public): " + employeeID);
        System.out.println("Department (protected): " + department);
        System.out.println("Salary (via getter): " + getSalary());
    }
}

public class EmployeeRecords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter department: ");
        String dept = sc.nextLine();
        System.out.print("Enter salary: ");
        double sal = sc.nextDouble();

        Manager mgr = new Manager(id, dept, sal);
        mgr.setSalary(sal + 1000);
        mgr.displayManagerInfo();

        sc.close();
    }
}
