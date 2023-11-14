package Lab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class p08_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentsCount = Integer.parseInt(scanner.nextLine());
        TreeMap<String, List<Double>> studentsMap = new TreeMap<>();

        for (int i = 0; i < studentsCount; i++) {
            String name = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                            .map(Double::parseDouble).collect(Collectors.toList());

            studentsMap.putIfAbsent(name, grades);
        }

        DecimalFormat df = new DecimalFormat("##.#######################");
        for (Map.Entry<String, List<Double>> entry : studentsMap.entrySet()) {
            double sum = 0;
            for (double num : entry.getValue()) {
                sum += num;
            }
            double avg = sum / entry.getValue().size();

            System.out.printf("%s is graduated with %s%n", entry.getKey(), df.format(avg));
        }
    }
}