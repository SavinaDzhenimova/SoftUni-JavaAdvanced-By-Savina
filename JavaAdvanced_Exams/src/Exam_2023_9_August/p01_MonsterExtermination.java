package Exam_2023_9_August;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p01_MonsterExtermination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] monstersArmorValues = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt).toArray();
        int[] soldierStrikingImpactValues = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> monstersArmor = new ArrayDeque<>();
        ArrayDeque<Integer> soldierStrikingImpact = new ArrayDeque<>();

        for (int value : monstersArmorValues) {
            monstersArmor.offer(value);
        }

        for (int value : soldierStrikingImpactValues) {
            soldierStrikingImpact.push(value);
        }

        int killedMonsters = 0;
        while (!monstersArmor.isEmpty() && !soldierStrikingImpact.isEmpty()) {
            int soldierPower = soldierStrikingImpact.pop();
            int monsterPower = monstersArmor.poll();

            if (soldierPower >= monsterPower) {
                if (soldierPower - monsterPower > 0) {
                    soldierPower -= monsterPower;

                    if (soldierStrikingImpact.isEmpty()) {
                        soldierStrikingImpact.push(soldierPower);
                    } else {
                        soldierStrikingImpact.push(soldierStrikingImpact.pop() + soldierPower);
                    }
                }
                killedMonsters++;
            } else {
                monsterPower -= soldierPower;
                monstersArmor.offer(monsterPower);
            }
        }

        if (monstersArmor.isEmpty()) {
            System.out.println("All monsters have been killed!");
        }
        if (soldierStrikingImpact.isEmpty()) {
            System.out.println("The soldier has been defeated.");
        }
        System.out.printf("Total monsters killed: %d%n", killedMonsters);
    }
}