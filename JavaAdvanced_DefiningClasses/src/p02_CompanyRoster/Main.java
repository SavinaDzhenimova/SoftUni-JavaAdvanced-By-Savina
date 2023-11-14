package p02_CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, ArrayList<Employee>> departments = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            String email;
            int age;

            Employee employee = null;
            if (tokens.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (tokens.length == 6) {
                email = tokens[4];
                age = Integer.parseInt(tokens[5]);

                employee = new Employee(name, salary, position, department, email, age);
            } else if (tokens.length == 5) {
                if (tokens[4].contains("@")) {
                    email = tokens[4];

                    employee = new Employee(name, salary, position, department, email);
                } else {
                    age = Integer.parseInt(tokens[4]);

                    employee = new Employee(name, salary, position, department, age);
                }
            }

            departments.putIfAbsent(department, new ArrayList<>());
            departments.get(department).add(employee);
        }

        List<Department> departmentsWithAvgSalary = new ArrayList<>();
        for (Map.Entry<String, ArrayList<Employee>> entry : departments.entrySet()) {
            int sum = 0;
            for (Employee employee : entry.getValue()) {
                sum += employee.getSalary();
            }
            double avgSalary = sum * 1.00 / entry.getValue().size();

            Department dep = new Department(entry.getKey(), entry.getValue(), avgSalary);
            departmentsWithAvgSalary.add(dep);
        }

        departmentsWithAvgSalary.sort(Comparator.comparing(Department::getAvgSalary));
        Collections.reverse(departmentsWithAvgSalary);

        System.out.println("Highest Average Salary: " + departmentsWithAvgSalary.get(0).getDepartment());
        departmentsWithAvgSalary.get(0).getEmployees().sort(Comparator.comparing(Employee::getSalary).reversed());
        departmentsWithAvgSalary.get(0).getEmployees().forEach(System.out::println);
    }
}