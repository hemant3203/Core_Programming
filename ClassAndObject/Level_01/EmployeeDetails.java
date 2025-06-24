package ClassAndObject.Level_01;
import java.util.*;
 class Employee{
    String name;
    int id;
    double salary;

    Employee(String name,int id,double salary){
        this.name=name;
        this.id=id;
        this.salary=salary;
    }

    void displayDetails(){
        System.out.println("Name: " + name + ", ID: " + id + ", Salary: " + salary);
    }
 }
public class EmployeeDetails {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String name=sc.nextLine();
        int id=sc.nextInt();
        double salary=sc.nextInt();
        Employee emp = new Employee(name, id, salary);
        emp.displayDetails();
        sc.close();
    }
}
