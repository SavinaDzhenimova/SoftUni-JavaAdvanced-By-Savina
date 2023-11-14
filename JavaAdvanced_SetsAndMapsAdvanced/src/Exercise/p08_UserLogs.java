package Exercise;

import java.util.*;

public class p08_UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        TreeMap<String, LinkedHashMap<String, Integer>> userLogs = new TreeMap<>();

        while (!command.equals("end")) {
            String[] input = command.split("\\s+");

            String address = input[0].substring(findStartIndex(input[0]) + 1);
            String username = input[2].substring(findStartIndex(input[2]) + 1);

            userLogs.putIfAbsent(username, new LinkedHashMap<>());
            userLogs.get(username).putIfAbsent(address, 0);
            userLogs.get(username).put(address, userLogs.get(username).get(address) + 1);

            command = scanner.nextLine();
        }

        userLogs.entrySet()
                .stream()
                .forEach(e -> {
                    System.out.println(e.getKey() + ":");

                    int count = 0;
                    Map<String, Integer> value = e.getValue();

                    for (Map.Entry<String, Integer> secondMap : value.entrySet()) {
                        String format =
                                (count++ == value.size() - 1) ? "%s => %d.%n" : "%s => %d, ";
                        System.out.printf(format, secondMap.getKey(), secondMap.getValue());
                    }
                });
    }

    public static int findStartIndex(String input) {
        int startIndex = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '=') {
                startIndex = i;
            }
        }

        return startIndex;
    }
}