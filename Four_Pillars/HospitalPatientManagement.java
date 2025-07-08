package Four_Pillars;

import java.util.Scanner;

interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientDetails() {
        return patientId + " - " + name + " (Age: " + age + ")";
    }

    public abstract double calculateBill();
}

class InPatient extends Patient implements MedicalRecord {
    private double roomCharges;
    private String diagnosis;

    public InPatient(String patientId, String name, int age, double roomCharges) {
        super(patientId, name, age);
        this.roomCharges = roomCharges;
    }

    public double calculateBill() {
        return roomCharges + 2000;
    }

    public void addRecord(String record) {
        this.diagnosis = record;
    }

    public void viewRecords() {
        System.out.println("Diagnosis: " + diagnosis);
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String prescription;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void addRecord(String record) {
        this.prescription = record;
    }

    public void viewRecords() {
        System.out.println("Prescription: " + prescription);
    }
}

public class HospitalPatientManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Patient[] patients = new Patient[2];
        InPatient p1 = new InPatient("P001", "John", 45, 5000);
        p1.addRecord("Surgery - Appendicitis");

        OutPatient p2 = new OutPatient("P002", "Emily", 30, 800);
        p2.addRecord("General Checkup");

        patients[0] = p1;
        patients[1] = p2;

        for (Patient p : patients) {
            System.out.println(p.getPatientDetails());
            System.out.println("Total Bill: ₹" + p.calculateBill());
            if (p instanceof MedicalRecord) {
                ((MedicalRecord) p).viewRecords();
            }
            System.out.println();
        }

        sc.close();
    }
}
