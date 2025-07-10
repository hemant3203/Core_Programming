import java.util.*;

// Interface for assigning grades
interface Graded {
    void assignGrade(Student student, Course course, String grade);
}

// Student class
class Student {
    String name;
    int id;
    Map<String, String> transcript = new HashMap<>();
    private double totalPoints = 0;
    private int totalCourses = 0;

    Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void receiveGrade(String courseName, String grade) {
        transcript.put(courseName, grade);
        double points = switch (grade) {
            case "A" -> 4.0;
            case "B" -> 3.0;
            case "C" -> 2.0;
            case "D" -> 1.0;
            case "F" -> 0.0;
            default -> -1; // Pass/Fail or others
        };
        if (points >= 0) {
            totalPoints += points;
            totalCourses++;
        }
    }

    double getGPA() {
        return totalCourses == 0 ? 0.0 : totalPoints / totalCourses;
    }

    String getName() {
        return name;
    }

    void printTranscript() {
        System.out.println(name + "'s Transcript:");
        transcript.forEach((course, grade) -> System.out.println(course + ": " + grade));
    }
}

// Undergraduate class (for future expansion)
class Undergraduate extends Student {
    Undergraduate(String name, int id) {
        super(name, id);
    }
}

// Postgraduate class (for future expansion)
class Postgraduate extends Student {
    Postgraduate(String name, int id) {
        super(name, id);
    }
}

// Course class
class Course {
    String name;
    Graded instructor;
    List<Student> enrolled = new ArrayList<>();

    Course(String name, Graded instructor) {
        this.name = name;
        this.instructor = instructor;
    }

    void enroll(Student s) {
        enrolled.add(s);
    }
}

// Faculty with letter grade system
class Faculty implements Graded {
    String name;

    Faculty(String name) {
        this.name = name;
    }

    public void assignGrade(Student student, Course course, String grade) {
        student.receiveGrade(course.name, grade);
    }
}

// Faculty with Pass/Fail system
class PassFailFaculty extends Faculty {
    PassFailFaculty(String name) {
        super(name);
    }

    @Override
    public void assignGrade(Student student, Course course, String grade) {
        if (grade.equals("Pass") || grade.equals("Fail")) {
            student.receiveGrade(course.name, grade);
        } else {
            throw new IllegalArgumentException("Only Pass/Fail grades allowed");
        }
    }
}

// Main
public class UniversitySystem {
    public static void main(String[] args) {
        Faculty profSmith = new Faculty("Prof. Smith");
        PassFailFaculty profLee = new PassFailFaculty("Prof. Lee");

        Course math = new Course("Math", profSmith);
        Course seminar = new Course("Seminar", profLee);

        Student alice = new Undergraduate("Alice", 1);
        Student bob = new Postgraduate("Bob", 2);

        math.enroll(alice);
        math.enroll(bob);
        seminar.enroll(bob);

        profSmith.assignGrade(alice, math, "A");
        profSmith.assignGrade(bob, math, "B");
        profLee.assignGrade(bob, seminar, "Pass");

        System.out.println(alice.getName() + " GPA: " + alice.getGPA());
        System.out.println(bob.getName() + " GPA: " + bob.getGPA());

        alice.printTranscript();
        bob.printTranscript();
    }
}
