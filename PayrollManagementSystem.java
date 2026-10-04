package com.mentorbridge.Employee;
// Employee Payroll Management System
// ABSTRACT CLASS
abstract class Employee {

    // ENCAPSULATION - Private variables
    private int employeeId;
    private String employeeName;
    private double basicSalary;

    // Constructor
    public Employee(int employeeId, String employeeName, double basicSalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.basicSalary = basicSalary;
    }

    // Getter methods
     public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public double getBasicSalary() {
        return basicSalary;
    }


    // Abstract method - ABSTRACTION
    public abstract double calculateSalary();

    // Abstract method to get allowances
    public abstract double getAllowances();

    // Abstract get role method
    public abstract String getRole();

    //  employee details
    public void displayDetails() {

        System.out.println("-----------------------------------");
        System.out.println("Employee ID    : " + getEmployeeId());
        System.out.println("Employee Name  : " + getEmployeeName());
        System.out.println("Employee Role  : " + getRole());
        System.out.println("Basic Salary   : Rs." + getBasicSalary());
        System.out.println("Allowances     : Rs." + getAllowances());
        System.out.println("Total Salary   : Rs." + calculateSalary());
        System.out.println("-----------------------------------");
    }
}


// DEVELOPER CLASS
class Developer extends Employee {

    protected double developerAllowance;

    // Constructor
    public Developer(int employeeId, String employeeName,
                     double basicSalary) {

        // Calling parent class constructor
        super(employeeId, employeeName, basicSalary);

    }

    // METHOD OVERRIDING
    @Override
    public double calculateSalary() {

        return getBasicSalary() + developerAllowance;
    }

    @Override
    public double getAllowances() {

        return 5000.0;
    }

    @Override
    public String getRole() {

        return "Developer";
    }
}


// LEVEL 2 - MULTILEVEL INHERITANCE
class SeniorDeveloper extends Developer {

    protected double seniorAllowance;

    // Constructor
    public SeniorDeveloper(int employeeId, String employeeName,
                           double basicSalary) {

        // Calling Developer constructor
        super(employeeId, employeeName, basicSalary);

    }

    // METHOD OVERRIDING
    @Override
    public double calculateSalary() {

        return getBasicSalary() + seniorAllowance;
    }

    @Override
    public double getAllowances() {

        return 10000;
    }

    @Override
    public String getRole() {

        return "Senior Developer";
    }
}


// LEVEL 3 - MULTILEVEL INHERITANCE
class TeamLead extends SeniorDeveloper {

    private double teamLeadAllowance;

    // Constructor
    public TeamLead(int employeeId, String employeeName,
                    double basicSalary) {

        // Calling SeniorDeveloper constructor
        super(employeeId, employeeName,
                basicSalary);

    }

    // METHOD OVERRIDING
    @Override
    public double calculateSalary() {

        return getBasicSalary() + teamLeadAllowance;
    }



    @Override
    public double getAllowances() {

        return 15000;
    }

    @Override
    public String getRole() {

        return "Team Lead";
    }
}


// MAIN CLASS
public class

PayrollManagementSystem {

    public static void main(String[] args) {



        Employee emp1 = new Developer(7579,"Pavi",30000);


        Employee emp2 = new SeniorDeveloper(887999,"Renaa", 4500);


        Employee emp3 = new TeamLead(7965396,"Arun", 60000);


        // Display employee details
        System.out.println("-----------------------------------");
        System.out.println("EMPLOYEE PAYROLL MANAGEMENT SYSTEM");

        emp1.displayDetails();
        emp2.displayDetails();
        emp3.displayDetails();
    }
}