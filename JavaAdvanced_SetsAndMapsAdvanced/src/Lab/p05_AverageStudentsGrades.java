package Lab;

import java.util.*;

public class p05_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentsCount = Integer.parseInt(scanner.nextLine());
        TreeMap<String, List<Double>> studentsWithGrades = new TreeMap<>();

        for (int i = 0; i < studentsCount; i++) {
            String[] studentData = scanner.nextLine().split("\\s+");
            String studentName = studentData[0];
            double grade = Double.parseDouble(studentData[1]);

            studentsWithGrades.putIfAbsent(studentName, new ArrayList<>());
            studentsWithGrades.get(studentName).add(grade);
        }

        for (Map.Entry<String, List<Double>> entry : studentsWithGrades.entrySet()) {
            double sum = 0;
            for (double n : entry.getValue()) {
                sum += n;
            }
            double avg = sum / entry.getValue().size();

            System.out.print(entry.getKey() + " -> ");
            for (double num : entry.getValue()) {
                System.out.printf("%.2f ", num);
            }
            System.out.printf("(avg: %.2f)%n", avg);
        }
    }
}