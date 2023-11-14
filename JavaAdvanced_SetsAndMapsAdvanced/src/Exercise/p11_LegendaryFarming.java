package Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class p11_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        TreeMap<String, Integer> keyMaterials = new TreeMap<>();
        TreeMap<String, Integer> junkMaterials = new TreeMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        while (!input.isEmpty()){
            List<String> data = Arrays.stream(input.split("\\s+")).collect(Collectors.toList());

            while (!data.isEmpty()) {
                int quantity = Integer.parseInt(data.get(0));
                String item = data.get(1).toLowerCase();

                data.remove(0);
                data.remove(0);

                if (keyMaterials.containsKey(item)) {
                    keyMaterials.put(item, keyMaterials.get(item) + quantity);
                } else {
                    junkMaterials.putIfAbsent(item, 0);
                    junkMaterials.put(item, junkMaterials.get(item) + quantity);
                }

                if (isLegendaryItemObtained(keyMaterials)) {
                    break;
                }
            }

            if (isLegendaryItemObtained(keyMaterials)) {
                printObtainedLegendaryItem(keyMaterials);
                break;
            }

            input = scanner.nextLine();
        }

        keyMaterials.entrySet()
                .stream()
                .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .forEach(el -> System.out.printf("%s: %d%n", el.getKey(), el.getValue()));

        junkMaterials.forEach((key1, value1) -> System.out.printf("%s: %d%n", key1, value1));
    }

    public static boolean isLegendaryItemObtained(TreeMap<String, Integer> keyMaterials) {
        return keyMaterials.get("shards") >= 250 ||
                keyMaterials.get("fragments") >= 250 ||
                keyMaterials.get("motes") >= 250;
    }

    public static void printObtainedLegendaryItem(TreeMap<String, Integer> keyMaterials) {
        String result = "";
        if (keyMaterials.get("shards") >= 250) {
            result = "Shadowmourne obtained!";

            keyMaterials.put("shards", Math.max(keyMaterials.get("shards") - 250, 0));
        } else if (keyMaterials.get("fragments") >= 250) {
            result = "Valanyr obtained!";

            keyMaterials.put("fragments", Math.max(keyMaterials.get("fragments") - 250, 0));
        } else if (keyMaterials.get("motes") >= 250) {
            result = "Dragonwrath obtained!";

            keyMaterials.put("motes", Math.max(keyMaterials.get("motes") - 250, 0));
        }

        System.out.println(result);
    }
}