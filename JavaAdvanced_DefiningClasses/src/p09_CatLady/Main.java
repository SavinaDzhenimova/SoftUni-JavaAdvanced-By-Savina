package p09_CatLady;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        LinkedHashMap<String, Siamese> siameseMap = new LinkedHashMap<>();
        LinkedHashMap<String, Cymric> cymricMap = new LinkedHashMap<>();
        LinkedHashMap<String, StreetExtraordinaire> streetExtraordinaireMap = new LinkedHashMap<>();

        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            String catBreed = tokens[0];
            String catName = tokens[1];

            switch (catBreed) {
                case "Siamese":
                    double earSize = Double.parseDouble(tokens[2]);
                    Siamese siamese = new Siamese(catName, earSize);
                    siameseMap.put(catName, siamese);
                    break;
                case "Cymric":
                    double furLength = Double.parseDouble(tokens[2]);
                    Cymric cymric = new Cymric(catName, furLength);
                    cymricMap.put(catName, cymric);
                    break;
                case "StreetExtraordinaire":
                    double decibelsOfMeows = Double.parseDouble(tokens[2]);
                    StreetExtraordinaire streetExtraordinaire = new StreetExtraordinaire(catName, decibelsOfMeows);
                    streetExtraordinaireMap.put(catName, streetExtraordinaire);
                    break;
            }

            command = scanner.nextLine();
        }

        String catName = scanner.nextLine();
        if (siameseMap.containsKey(catName)) {
            System.out.println(siameseMap.get(catName));
        } else if (cymricMap.containsKey(catName)) {
            System.out.println(cymricMap.get(catName));
        } else if (streetExtraordinaireMap.containsKey(catName)) {
            System.out.println(streetExtraordinaireMap.get(catName));
        }
    }
}