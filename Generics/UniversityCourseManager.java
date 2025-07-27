package Generics;

import java.util.*;

abstract class CourseType {
    abstract String getEvaluationMethod();
}

class ExamCourse extends CourseType {
    String getEvaluationMethod() {
        return "Exam";
    }
}

class AssignmentCourse extends CourseType {
    String getEvaluationMethod() {
        return "Assignments";
    }
}

class ResearchCourse extends CourseType {
    String getEvaluationMethod() {
        return "Research";
    }
}

class Course<T extends CourseType> {
    private String title;
    private T type;

    Course(String title, T type) {
        this.title = title;
        this.type = type;
    }

    String getCourseInfo() {
        return title + " - " + type.getEvaluationMethod();
    }
}

public class UniversityCourseManager {
    public static void printCourses(List<? extends CourseType> courseTypes) {
        for (CourseType ct : courseTypes) {
            System.out.println(ct.getEvaluationMethod());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        Course<ExamCourse> course = new Course<>(title, new ExamCourse());
        System.out.println(course.getCourseInfo());
        sc.close();
    }
}
