package Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p06_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        TreeMap<String, LinkedHashMap<String, Double>> shopsMap = new TreeMap<>();

        while (!input.equals("Revision")) {
            String[] data = input.split(",\\s+");
            String shop = data[0];
            String product = data[1];
            double price = Double.parseDouble(data[2]);

            shopsMap.putIfAbsent(shop, new LinkedHashMap<>());
            shopsMap.get(shop).putIfAbsent(product, price);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Double>> entry : shopsMap.entrySet()) {
            System.out.println(entry.getKey() + "->");

            for (Map.Entry<String, Double> e : entry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", e.getKey(), e.getValue());
            }
        }
    }
}