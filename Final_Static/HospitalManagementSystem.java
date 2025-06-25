package Final_Static;
import java.util.Scanner;

class Patient {
    static String hospitalName;
    private static int totalPatients = 0;
    private final int patientID;
    private String name;
    private int age;
    private String ailment;

    Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    static int getTotalPatients() {
        return totalPatients;
    }

    void displayDetails() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Hospital Name: ");
        Patient.hospitalName = sc.nextLine();

        System.out.print("Enter number of patients to admit: ");
        int n = sc.nextInt();
        sc.nextLine();

        Patient[] patients = new Patient[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Patient Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Patient Age: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Ailment: ");
            String ailment = sc.nextLine();
            System.out.print("Enter Patient ID: ");
            int patientID = sc.nextInt();
            sc.nextLine();

            patients[i] = new Patient(name, age, ailment, patientID);
        }

        System.out.println("Total patients admitted: " + Patient.getTotalPatients());

        for (Patient patient : patients) {
            if (patient instanceof Patient) {
                patient.displayDetails();
            }
        }

        sc.close();
    }
}
