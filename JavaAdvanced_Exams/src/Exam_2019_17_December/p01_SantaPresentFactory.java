package Exam_2019_17_December;

import java.util.*;
import java.util.stream.Collectors;

public class p01_SantaPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] boxesArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] magicLevelsArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> boxesStack = new ArrayDeque<>();
        for (int material : boxesArr) {
            boxesStack.push(material);
        }
        ArrayDeque<Integer> magicLevelsQueue = new ArrayDeque<>();
        for (int magicLevel : magicLevelsArr) {
            magicLevelsQueue.offer(magicLevel);
        }

        TreeMap<String, Integer> craftedToys = new TreeMap<>();
        craftedToys.put("Doll", 0);
        craftedToys.put("Teddy bear", 0);
        craftedToys.put("Wooden train", 0);
        craftedToys.put("Bicycle", 0);

        while (!boxesStack.isEmpty() && !magicLevelsQueue.isEmpty()) {
            int material = boxesStack.peek();
            int magicLevel = magicLevelsQueue.peek();
            int result = magicLevel * material;

            if (result > 0) {
                if (result == 150) {
                    craftedToys.put("Doll", craftedToys.get("Doll") + 1);
                    boxesStack.pop();
                } else if (result == 250) {
                    craftedToys.put("Wooden train", craftedToys.get("Wooden train") + 1);
                    boxesStack.pop();
                } else if (result == 300) {
                    craftedToys.put("Teddy bear", craftedToys.get("Teddy bear") + 1);
                    boxesStack.pop();
                } else if (result == 400) {
                    craftedToys.put("Bicycle", craftedToys.get("Bicycle") + 1);
                    boxesStack.pop();
                } else {
                    boxesStack.pop();
                    material += 15;
                    boxesStack.push(material);
                }
                magicLevelsQueue.poll();
            } else if (result < 0) {
                result = magicLevel + material;
                boxesStack.pop();
                magicLevelsQueue.poll();
                boxesStack.push(result);
            } else {
                if (material == 0) {
                    boxesStack.pop();
                }
                if (magicLevel == 0) {
                    magicLevelsQueue.poll();
                }
            }
        }

        if (((craftedToys.get("Doll") >= 1 && (craftedToys.get("Wooden train") >= 1))
                || (craftedToys.get("Teddy bear") >= 1 && craftedToys.get("Bicycle") >= 1))) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!boxesStack.isEmpty()) {
            System.out.println("Materials left: " + boxesStack.stream().map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }
        if (!magicLevelsQueue.isEmpty()) {
            System.out.println("Magic left: " + magicLevelsQueue.stream().map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }

        for (Map.Entry<String, Integer> entry : craftedToys.entrySet()) {
            if (entry.getValue() >= 1) {
                System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
            }
        }
    }
}