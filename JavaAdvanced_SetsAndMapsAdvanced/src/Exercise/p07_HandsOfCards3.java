package Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class p07_HandsOfCards3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, LinkedHashSet<String>> playersCards = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String[] data = input.split(":\\s+");
            String personName = data[0];
            LinkedHashSet<String> cards = Arrays.stream(data[1].split(",\\s+"))
                    .collect(Collectors.toCollection(LinkedHashSet::new));

            playersCards.putIfAbsent(personName, new LinkedHashSet<>());
            for (String c : cards) {
                playersCards.get(personName).add(c);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashSet<String>> entry : playersCards.entrySet()) {
            int value = 0;
            for (String card : entry.getValue()) {
                value += cardsValue(card);
            }

            System.out.printf("%s: %d%n", entry.getKey(), value);
        }
    }

    public static int cardsValue(String card) {
        String cardNum;
        int power = 0;
        char type;
        int multiplier = 0;

        if (card.length() == 3) {
            cardNum = card.substring(0, 2);
            type = card.charAt(2);
        } else {
            cardNum = card.substring(0, 1);
            type = card.charAt(1);
        }

        switch (cardNum) {
            case "1":
                power = 1;
                break;
            case "2":
                power = 2;
                break;
            case "3":
                power = 3;
                break;
            case "4":
                power = 4;
                break;
            case "5":
                power = 5;
                break;
            case "6":
                power = 6;
                break;
            case "7":
                power = 7;
                break;
            case "8":
                power = 8;
                break;
            case "9":
                power = 9;
                break;
            case "10":
                power = 10;
                break;
            case "J":
                power = 11;
                break;
            case "Q":
                power = 12;
                break;
            case "K":
                power = 13;
                break;
            case "A":
                power = 14;
                break;
        }

        if (type == 'S') {
            multiplier = 4;
        } else if (type == 'H') {
            multiplier = 3;
        } else if (type == 'D') {
            multiplier = 2;
        } else if (type == 'C') {
            multiplier = 1;
        }

        return multiplier * power;
    }
}