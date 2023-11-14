package p02_CompanyRoster;

import java.util.ArrayList;

public class Department {
    String department;
    private ArrayList<Employee> employees;
    private double avgSalary;

    public Department(String department, ArrayList<Employee> employees, double avgSalary) {
        this.department = department;
        this.employees = employees;
        this.avgSalary = avgSalary;
    }

    public String getDepartment() {
        return department;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public double getAvgSalary() {
        return avgSalary;
    }
}
