package Exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p12_SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, LinkedHashMap<String, Integer>> locationsMap = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String regex = "(?<singerName>\\w+(?: \\w+)*) @(?<venue>\\w+(?: \\w+)*) (?<price>\\d+) (?<count>\\d+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String singerName = matcher.group("singerName").trim();
                String venue = matcher.group("venue").trim();
                int ticketPrice = Integer.parseInt(matcher.group("price"));
                int ticketsCount = Integer.parseInt(matcher.group("count"));

                int income = ticketPrice * ticketsCount;

                if (!locationsMap.containsKey(venue)) {
                    locationsMap.putIfAbsent(venue, new LinkedHashMap<>());
                    locationsMap.get(venue).put(singerName, income);
                } else {
                    locationsMap.get(venue).putIfAbsent(singerName, 0);
                    locationsMap.get(venue).put(singerName, locationsMap.get(venue).get(singerName) + income);
                }
            }

            input = scanner.nextLine();
        }

        locationsMap.forEach((location, singers) -> {
            System.out.printf("%s%n", location);

            singers.entrySet()
                    .stream()
                    .sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue()))
                    .forEach(singer -> System.out.printf("#  %s -> %d%n", singer.getKey(), singer.getValue()));
        });
    }
}