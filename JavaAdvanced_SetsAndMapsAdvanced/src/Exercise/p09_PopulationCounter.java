package Exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class p09_PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, LinkedHashMap<String, Long>> citiesByCountry = new LinkedHashMap<>();
        LinkedHashMap<String, Long> countriesOnly = new LinkedHashMap<>();

        while (!input.equals("report")) {
            String[] data = input.split("\\|");
            String city = data[0];
            String country = data[1];
            long population = Long.parseLong(data[2]);

            citiesByCountry.putIfAbsent(country, new LinkedHashMap<>());
            citiesByCountry.get(country).put(city, population);
            countriesOnly.putIfAbsent(country, 0L);
            countriesOnly.put(country, countriesOnly.get(country) + population);

            input = scanner.nextLine();
        }

        citiesByCountry.entrySet()
                .stream()
                .sorted((c1, c2)-> countriesOnly.get(c2.getKey()).compareTo(countriesOnly.get(c1.getKey())))
                .forEach(country -> {
                    System.out.format("%s (total population: %d)%n",country.getKey(),countriesOnly.get(country.getKey()));
                    country.getValue().entrySet()
                            .stream().sorted((t1,t2)-> t2.getValue().compareTo(t1.getValue())).forEach(city ->{
                                System.out.format("=>%s: %d%n", city.getKey(),city.getValue());
                            });
                });
    }
}