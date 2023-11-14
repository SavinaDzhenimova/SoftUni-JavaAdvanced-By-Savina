package Exam_2022_13_April;

import java.util.*;
import java.util.stream.Collectors;

public class p01_Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] steelInput = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] carbonInput = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> steelQueue = new ArrayDeque<>();
        for (int s : steelInput) {
            steelQueue.offer(s);
        }
        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();
        for (int c : carbonInput) {
            carbonStack.push(c);
        }

        TreeMap<String, Integer> swords = new TreeMap<>();
        swords.put("Gladius", 70);
        swords.put("Shamshir", 80);
        swords.put("Katana", 90);
        swords.put("Sabre", 110);

        int gladius = 0;
        int shamshir = 0;
        int katana = 0;
        int sabre = 0;

        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
            int steel = steelQueue.poll();
            int carbon = carbonStack.pop();
            int sum = steel+ carbon;

            if (sum >= 70 && sum <= 110) {
                if (sum == swords.get("Sabre")) {
                    sabre++;
                } else if (sum == swords.get("Katana")) {
                    katana++;
                } else if (sum == swords.get("Shamshir")) {
                    shamshir++;
                } else if (sum == swords.get("Gladius")) {
                    gladius++;
                } else {
                    carbon += 5;
                    carbonStack.push(carbon);
                }

            } else {
                carbon += 5;
                carbonStack.push(carbon);
            }
        }

        int swordsSum = gladius + shamshir + katana + sabre;
        if (swordsSum > 0) {
            System.out.printf("You have forged %d swords.%n", swordsSum);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (steelQueue.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            System.out.println("Steel left: " + steelQueue.stream().map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }

        if (carbonStack.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            System.out.println("Carbon left: " + carbonStack.stream().map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }

        if (gladius > 0) {
            System.out.printf("Gladius: %d%n", gladius);
        }
        if (katana > 0) {
            System.out.printf("Katana: %d%n", katana);
        }
        if (sabre > 0) {
            System.out.printf("Sabre: %d%n", sabre);
        }
        if (shamshir > 0) {
            System.out.printf("Shamshir: %d%n", shamshir);
        }
    }
}