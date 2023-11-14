package Exercise;

import java.util.Scanner;
import java.util.TreeMap;

public class p10_LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int logLines = Integer.parseInt(scanner.nextLine());
        TreeMap<String, TreeMap<String, Integer>> users = new TreeMap<>();

        for (int i = 0; i < logLines; i++) {
            String[] tokens = scanner.nextLine().split(" ");

            String address = tokens[0];
            String user = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            users.putIfAbsent(user, new TreeMap<>());
            users.get(user).putIfAbsent(address, 0);
            users.get(user).put(address, users.get(user).get(address) + duration);
        }

        users.forEach((user, addresses) -> {
            int totalDuration = addresses.values().stream().mapToInt(Integer::intValue).sum();

            String[] ips = addresses.keySet().toArray(String[]::new);

            System.out.printf("%s: %d [%s]%n", user, totalDuration, String.join(", ", ips));
        });
    }
}