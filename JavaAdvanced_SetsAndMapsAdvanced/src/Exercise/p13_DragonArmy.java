package Exercise;

import java.util.*;

public class p13_DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputLines = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, TreeMap<String, List<Integer>>> dragonsByType = new LinkedHashMap<>();
        LinkedHashMap<String, List<Double>> avgStats = new LinkedHashMap<>();

        for (int i = 0; i < inputLines; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String type = data[0];
            String dragonName = data[1];

            int damage;
            if (data[2].equals("null")) {
                damage = 45;
            } else {
                damage = Integer.parseInt(data[2]);
            }

            int health;
            if (data[3].equals("null")) {
                health = 250;
            } else {
                health = Integer.parseInt(data[3]);
            }

            int armor;
            if (data[4].equals("null")) {
                armor = 10;
            } else {
                armor = Integer.parseInt(data[4]);
            }

            dragonsByType.putIfAbsent(type, new TreeMap<>());
            dragonsByType.get(type).put(dragonName, new ArrayList<>());
            dragonsByType.get(type).get(dragonName).add(damage);
            dragonsByType.get(type).get(dragonName).add(health);
            dragonsByType.get(type).get(dragonName).add(armor);

            avgStats.putIfAbsent(type, new ArrayList<>());
        }

        for (Map.Entry<String, TreeMap<String, List<Integer>>> entry : dragonsByType.entrySet()) {
            double sumDamage = 0;
            double sumHealth = 0;
            double sumArmor = 0;

            for (Map.Entry<String, List<Integer>> e : entry.getValue().entrySet()) {
                sumDamage += e.getValue().get(0);
                sumHealth += e.getValue().get(1);
                sumArmor += e.getValue().get(2);
            }

            double avgDamage = sumDamage / entry.getValue().size();
            avgStats.get(entry.getKey()).add(avgDamage);

            double avgHealth = sumHealth / entry.getValue().size();
            avgStats.get(entry.getKey()).add(avgHealth);

            double avgArmor = sumArmor / entry.getValue().size();
            avgStats.get(entry.getKey()).add(avgArmor);
        }

        dragonsByType.forEach((type, dragons) -> {
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type,
                    avgStats.get(type).get(0),
                    avgStats.get(type).get(1),
                    avgStats.get(type).get(2));

            dragons.forEach((key1, value1) -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", key1,
                    value1.get(0), value1.get(1), value1.get(2)));
        });
    }
}