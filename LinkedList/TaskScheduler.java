package LinkedList;

import java.util.Scanner;

public class TaskScheduler {
    static class Node {
        int taskId;
        String taskName;
        int priority;
        String dueDate;
        Node next;

        Node(int taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null;
        }
    }

    Node head = null;
    Node current = null;

    void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            head.next = head;
            current = head;
            return;
        }
        Node temp = head;
        while (temp.next != head)
            temp = temp.next;
        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            head.next = head;
            current = head;
            return;
        }
        Node temp = head;
        while (temp.next != head)
            temp = temp.next;
        temp.next = newNode;
        newNode.next = head;
    }

    void addAtPosition(int pos, int taskId, String taskName, int priority, String dueDate) {
        if (pos == 1) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        Node temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++)
            temp = temp.next;
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void removeByTaskId(int taskId) {
        if (head == null)
            return;
        if (head.taskId == taskId && head.next == head) {
            head = null;
            current = null;
            return;
        }
        Node temp = head;
        Node prev = null;
        do {
            if (temp.taskId == taskId) {
                if (temp == head) {
                    Node last = head;
                    while (last.next != head)
                        last = last.next;
                    head = head.next;
                    last.next = head;
                    if (current == temp)
                        current = head;
                } else {
                    prev.next = temp.next;
                    if (current == temp)
                        current = prev.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    void viewCurrentTaskAndMoveNext() {
        if (current == null) {
            System.out.println("No tasks available");
            return;
        }
        System.out.println("Task ID: " + current.taskId + ", Name: " + current.taskName + ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
        current = current.next;
    }

    void displayAllTasks() {
        if (head == null)
            return;
        Node temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }
        Node temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found)
            System.out.println("No tasks found with that priority");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskScheduler task = new TaskScheduler();
        while (true) {
            System.out.println("1. Add at Beginning\n2. Add at End\n3. Add at Position\n4. Remove by Task ID\n5. View Current Task and Move to Next\n6. Display All Tasks\n7. Search by Priority\n8. Exit");
            int choice = sc.nextInt();
            if (choice == 8)
                break;
            switch (choice) {
                case 1:
                    System.out.println("Enter Task ID, Name, Priority, Due Date:");
                    task.addAtBeginning(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;
                case 2:
                    System.out.println("Enter Task ID, Name, Priority, Due Date:");
                    task.addAtEnd(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;
                case 3:
                    System.out.println("Enter Position, Task ID, Name, Priority, Due Date:");
                    task.addAtPosition(sc.nextInt(), sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;
                case 4:
                    System.out.println("Enter Task ID:");
                    task.removeByTaskId(sc.nextInt());
                    break;
                case 5:
                    task.viewCurrentTaskAndMoveNext();
                    break;
                case 6:
                    task.displayAllTasks();
                    break;
                case 7:
                    System.out.println("Enter Priority:");
                    task.searchByPriority(sc.nextInt());
                    break;
            }
        }
        sc.close();
    }
}
