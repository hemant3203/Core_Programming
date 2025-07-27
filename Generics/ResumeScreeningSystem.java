package Generics;

import java.util.*;

abstract class JobRole {
    abstract String getRole();
}

class SoftwareEngineer extends JobRole {
    String getRole() {
        return "Software Engineer";
    }
}

class DataScientist extends JobRole {
    String getRole() {
        return "Data Scientist";
    }
}

class ProductManager extends JobRole {
    String getRole() {
        return "Product Manager";
    }
}

class Resume<T extends JobRole> {
    private T role;

    Resume(T role) {
        this.role = role;
    }

    String process() {
        return "Processing resume for: " + role.getRole();
    }
}

public class ResumeScreeningSystem {
    public static void processResumes(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            System.out.println("Screening: " + role.getRole());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Resume<? extends JobRole> resume;
        if (input.equalsIgnoreCase("ds")) {
            resume = new Resume<>(new DataScientist());
        } else if (input.equalsIgnoreCase("pm")) {
            resume = new Resume<>(new ProductManager());
        } else {
            resume = new Resume<>(new SoftwareEngineer());
        }
        System.out.println(resume.process());
        sc.close();
    }
}
