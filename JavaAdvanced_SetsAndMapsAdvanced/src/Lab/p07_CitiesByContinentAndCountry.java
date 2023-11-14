package Lab;

import java.util.*;

public class p07_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputLinesCount = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, LinkedHashMap<String, List<String>>> continentsMap = new LinkedHashMap<>();

        for (int i = 0; i < inputLinesCount; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String continent = data[0];
            String country = data[1];
            String city = data[2];

            continentsMap.putIfAbsent(continent, new LinkedHashMap<>());
            continentsMap.get(continent).putIfAbsent(country, new ArrayList<>());
            continentsMap.get(continent).get(country).add(city);
        }

        continentsMap.forEach((continent, countries) -> {
            System.out.println(continent + ":");

            countries.forEach((country, cities) -> {
                String joinedCities = String.join(", ", cities);
                System.out.println("  " + country + " -> " + joinedCities);
            });
        });
    }
}