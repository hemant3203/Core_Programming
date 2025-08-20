import java.util.*;
import java.util.regex.*;

class InvalidEmailFormatException extends RuntimeException {
    public InvalidEmailFormatException(String message) {
        super(message);
    }
}

class NoEmployeeFoundException extends Exception {
    public NoEmployeeFoundException(String message) {
        super(message);
    }
}


class Email {
    private String emailAddress;

    public Email(String emailAddress) {
        if (!isValid(emailAddress)) {
            throw new InvalidEmailFormatException("Invalid email format: " + emailAddress);
        }
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        if (!isValid(emailAddress)) {
            throw new InvalidEmailFormatException("Invalid email format: " + emailAddress);
        }
        this.emailAddress = emailAddress;
    }

    private boolean isValid(String email) {
        Pattern p = Pattern.compile("^[a-z0-9._]+@company\\.com$");
        Matcher m = p.matcher(email);
        return m.matches();
    }
}

class Employee {
    private String name;
    private Email email;

    public Employee(String name, String emailAddress) {
        this.name = name;
        this.email = new Email(emailAddress);
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Email: " + email.getEmailAddress();
    }
}


class EmailManager {
    private List<Employee> employeeList;

    public EmailManager() {
        this.employeeList = new ArrayList<>();
    }

    public void addEmployee(String name, String email) {
        try {
            Employee emp = new Employee(name, email);
            employeeList.add(emp);
            System.out.println("Employee added: " + emp);
        } catch (InvalidEmailFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public List<Employee> searchByDomain(String domain) throws NoEmployeeFoundException {
        List<Employee> result = new ArrayList<>();
        for (Employee e : employeeList) {
            if (e.getEmail().getEmailAddress().endsWith("@" + domain)) {
                result.add(e);
            }
        }

        if (result.isEmpty()) {
            throw new NoEmployeeFoundException("No employee found with domain: " + domain);
        }

        return result;
    }
}


public class EmailFiltering {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmailManager manager = new EmailManager();

        System.out.print("Enter total number of employees: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.print("Enter employee name: ");
            String name = sc.nextLine();
            System.out.print("Enter employee email: ");
            String email = sc.nextLine();
            manager.addEmployee(name, email);
        }

    
        System.out.print("\nEnter domain to search (e.g., company.com): ");
        String domain = sc.nextLine();
        try {
            List<Employee> found = manager.searchByDomain(domain);
            System.out.println("Employees with domain @" + domain + ":");
            for (Employee e : found) {
                System.out.println(e);
            }
        } catch (NoEmployeeFoundException e) {
            System.out.println("Search error: " + e.getMessage());
        }

        sc.close();
    }
}
