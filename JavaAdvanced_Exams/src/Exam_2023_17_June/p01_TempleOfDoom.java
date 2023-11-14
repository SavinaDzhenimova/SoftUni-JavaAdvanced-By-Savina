package Exam_2023_17_June;

import java.util.*;
import java.util.stream.Collectors;

public class p01_TempleOfDoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] toolsInput = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] substancesInput = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<Integer> challenges = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        ArrayDeque<Integer> tools = new ArrayDeque<>();
        for (int el : toolsInput) {
            tools.offer(el);
        }
        ArrayDeque<Integer> substances = new ArrayDeque<>();
        for (int el : substancesInput) {
            substances.push(el);
        }

        while (!tools.isEmpty() && !substances.isEmpty()) {
            int tool = tools.poll();
            int substance = substances.pop();

            if (challenges.contains(tool * substance)) {
                challenges.remove(Integer.valueOf(tool * substance));

                if (challenges.isEmpty()) {
                    System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
                    break;
                }
            } else {
                tool += 1;
                tools.offer(tool);
                substance -= 1;
                if (substance > 0) {
                    substances.push(substance);
                }
            }
        }

        if ((tools.isEmpty() || substances.isEmpty()) && !challenges.isEmpty()) {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        }

        if (!tools.isEmpty()) {
            System.out.println("Tools: " + tools.stream().map(Object::toString).collect(Collectors.joining(", ")));
        }
        if (!substances.isEmpty()) {
            System.out.println("Substances: " + substances.stream().map(Object::toString).collect(Collectors.joining(", ")));
        }
        if (!challenges.isEmpty()) {
            System.out.println("Challenges: " + challenges.stream().map(Object::toString).collect(Collectors.joining(", ")));
        }
    }
}