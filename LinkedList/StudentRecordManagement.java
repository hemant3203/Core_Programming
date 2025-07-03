package LinkedList;

import java.util.Scanner;

public class StudentRecordManagement {
    static class Node {
        int rollNumber;
        String name;
        int age;
        String grade;
        Node next;

        Node(int rollNumber, String name, int age, String grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }

    Node head = null;

    void addAtBeginning(int rollNumber, String name, int age, String grade) {
        Node newNode = new Node(rollNumber, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    void addAtEnd(int rollNumber, String name, int age, String grade) {
        Node newNode = new Node(rollNumber, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    void addAtPosition(int pos, int rollNumber, String name, int age, String grade) {
        if (pos == 1) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        Node newNode = new Node(rollNumber, name, age, grade);
        Node temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++)
            temp = temp.next;
        if (temp == null)
            return;
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void deleteByRollNumber(int rollNumber) {
        if (head == null)
            return;
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber)
            temp = temp.next;
        if (temp.next == null)
            return;
        temp.next = temp.next.next;
    }

    void searchByRollNumber(int rollNumber) {
        Node temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println("Roll Number: " + temp.rollNumber);
                System.out.println("Name: " + temp.name);
                System.out.println("Age: " + temp.age);
                System.out.println("Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    void updateGradeByRollNumber(int rollNumber, String newGrade) {
        Node temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                temp.grade = newGrade;
                return;
            }
            temp = temp.next;
        }
    }

    void displayAll() {
        Node temp = head;
        while (temp != null) {
            System.out.println("Roll Number: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentRecordManagement srm = new StudentRecordManagement();
        while (true) {
            System.out.println("1. Add at Beginning\n2. Add at End\n3. Add at Position\n4. Delete by Roll Number\n5. Search by Roll Number\n6. Update Grade\n7. Display All\n8. Exit");
            int choice = sc.nextInt();
            if (choice == 8)
                break;
            switch (choice) {
                case 1:
                    System.out.println("Enter Roll Number, Name, Age, Grade:");
                    srm.addAtBeginning(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;
                case 2:
                    System.out.println("Enter Roll Number, Name, Age, Grade:");
                    srm.addAtEnd(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;
                case 3:
                    System.out.println("Enter Position, Roll Number, Name, Age, Grade:");
                    srm.addAtPosition(sc.nextInt(), sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;
                case 4:
                    System.out.println("Enter Roll Number:");
                    srm.deleteByRollNumber(sc.nextInt());
                    break;
                case 5:
                    System.out.println("Enter Roll Number:");
                    srm.searchByRollNumber(sc.nextInt());
                    break;
                case 6:
                    System.out.println("Enter Roll Number and New Grade:");
                    srm.updateGradeByRollNumber(sc.nextInt(), sc.next());
                    break;
                case 7:
                    srm.displayAll();
                    break;
            }
        }
        sc.close();
    }
}
