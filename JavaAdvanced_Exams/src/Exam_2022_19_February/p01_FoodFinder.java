package Exam_2022_19_February;

import java.util.*;

public class p01_FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] vowelsInput = scanner.nextLine().split("\\s+");
        String[] consonantsInput = scanner.nextLine().split("\\s+");

        ArrayDeque<String> vowelsQueue = new ArrayDeque<>();
        for (String v : vowelsInput) {
            vowelsQueue.offer(v);
        }
        ArrayDeque<String> consonantsStack = new ArrayDeque<>();
        for (String c : consonantsInput) {
            consonantsStack.push(c);
        }
        LinkedHashMap<String, Integer> words = new LinkedHashMap<>();
        words.put("pear", 4);
        words.put("flour", 5);
        words.put("pork", 4);
        words.put("olive", 5);
        List<String> usedVowels = new ArrayList<>();
        List<String> usedConsonants = new ArrayList<>();
        int producedWords = 0;

        while (!consonantsStack.isEmpty()) {
            String vowel = vowelsQueue.poll();
            String consonant = consonantsStack.pop();

            for (Map.Entry<String, Integer> entry : words.entrySet()) {
                if (entry.getValue() > 0) {
                    if (!usedVowels.contains(vowel)) {
                        if (entry.getKey().contains(vowel)) {
                            int newValue = entry.getValue() - 1;
                            entry.setValue(newValue);
                        }
                    }

                    if (!usedConsonants.contains(consonant)) {
                        if (entry.getKey().contains(consonant)) {
                            int newValue = entry.getValue() - 1;
                            entry.setValue(newValue);
                        }
                    }

                    if (entry.getValue() == 0) {
                        producedWords++;
                    }

                    vowelsQueue.offer(vowel);
                }
            }
            usedVowels.add(vowel);
            usedConsonants.add(consonant);

        }

        System.out.printf("Words found: %d%n", producedWords);
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            if (entry.getValue() == 0) {
                System.out.println(entry.getKey());
            }
        }
    }
}