package Exam_2023_18_February;

import java.util.*;
import java.util.stream.Collectors;

public class p01_ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] textilesInput = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] medicamentInput = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> textiles = new ArrayDeque<>();
        for (int t : textilesInput) {
            textiles.offer(t);
        }
        ArrayDeque<Integer> medicament = new ArrayDeque<>();
        for (int m : medicamentInput) {
            medicament.push(m);
        }

        TreeMap<String, Integer> healingItems = new TreeMap<>();

        while (!textiles.isEmpty() && !medicament.isEmpty()) {
            int textile = textiles.poll();
            int med = medicament.pop();
            int sum = textile + med;

            if (sum >= 30 && sum <= 100) {
                if (sum == 30) {
                    healingItems.putIfAbsent("Patch", 0);
                    healingItems.put("Patch", healingItems.get("Patch") + 1);
                } else if (sum == 40) {
                    healingItems.putIfAbsent("Bandage", 0);
                    healingItems.put("Bandage", healingItems.get("Bandage") + 1);
                } else if (sum == 100) {
                    healingItems.putIfAbsent("MedKit", 0);
                    healingItems.put("MedKit", healingItems.get("MedKit") + 1);
                } else {
                    med += 10;
                    medicament.push(med);
                }

            } else {
                if (sum > 100) {
                    healingItems.putIfAbsent("MedKit", 0);
                    healingItems.put("MedKit", healingItems.get("MedKit") + 1);

                    sum -= 100;
                    int newMed = medicament.pop() + sum;
                    medicament.push(newMed);
                } else {
                    med += 10;
                    medicament.push(med);
                }

            }
        }

        if (textiles.isEmpty() && medicament.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textiles.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else {
            System.out.println("Medicaments are empty.");
        }

        healingItems.entrySet()
                .stream()
                .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .forEach(item -> {
                    if (item.getValue() != 0) {
                        System.out.printf("%s - %d%n", item.getKey(), item.getValue());
                    }
                });

        if (!textiles.isEmpty()) {
            System.out.println("Textiles left: " + textiles.stream().map(Object::toString)
                    .collect(Collectors.joining(", ")));
        } else if (!medicament.isEmpty()) {
            System.out.println("Medicaments left: " + medicament.stream().map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }
    }
}