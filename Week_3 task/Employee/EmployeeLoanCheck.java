import java.util.Scanner;

class Employee {
    private int empId;
    private String empName;
    private double sal;  // Monthly salary
    private int yearsWorked;

    // Method to set employee details
    public void setEmployeeDetails(int empId, String empName, double sal, int yearsWorked) {
        this.empId = empId;
        this.empName = empName;
        this.sal = sal;
        this.yearsWorked = yearsWorked;
    }

    // Method to get employee details
    public void getEmployeeDetails() {
        System.out.println("\nEmployee Details:");
        System.out.println("ID: " + empId);
        System.out.println("Name: " + empName);
        System.out.println("Monthly Salary: " + sal);
        System.out.println("Years Worked: " + yearsWorked);
    }

    // Method to check loan eligibility
    public void getLoanEligibility() {
        double annualSalary = sal * 12;
        if (yearsWorked > 5) {
            if (annualSalary >= 15_00_000) {
                System.out.println("Eligible for a loan of ₹7,00,000");
            } else if (annualSalary >= 10_00_000) {
                System.out.println("Eligible for a loan of ₹5,00,000");
            } else if (annualSalary >= 6_00_000) {
                System.out.println("Eligible for a loan of ₹2,00,000");
            } else {
                System.out.println("Not eligible for a loan.");
            }
        } else {
            System.out.println("Not eligible for a loan (Must have worked > 5 years).");
        }
    }
}

public class EmployeeLoanCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input employee details
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Monthly Salary: ");
        double salary = scanner.nextDouble();
        
        System.out.print("Enter Years Worked: ");
        int years = scanner.nextInt();
        
        // Create employee object
        Employee emp = new Employee();
        emp.setEmployeeDetails(id, name, salary, years);
        
        // Display details and check loan eligibility
        emp.getEmployeeDetails();
        emp.getLoanEligibility();

        scanner.close();
    }
}
