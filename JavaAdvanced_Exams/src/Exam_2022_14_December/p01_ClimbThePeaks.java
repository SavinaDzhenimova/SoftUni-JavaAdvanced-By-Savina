package Exam_2022_14_December;

import java.util.*;

public class p01_ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] foodInput = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] staminaInput = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> foodPortionsStack = new ArrayDeque<>();
        for (int food : foodInput) {
            foodPortionsStack.push(food);
        }
        ArrayDeque<Integer> staminaQueue = new ArrayDeque<>();
        for (int s : staminaInput) {
            staminaQueue.offer(s);
        }

        LinkedHashMap<Integer, String> mountainPeaks = new LinkedHashMap<>();
        mountainPeaks.put(80, "Vihren");
        mountainPeaks.put(90, "Kutelo");
        mountainPeaks.put(100, "Banski Suhodol");
        mountainPeaks.put(60, "Polezhan");
        mountainPeaks.put(70, "Kamenitza");
        List<Integer> peaks = new ArrayList<>();
        peaks.add(80);
        peaks.add(90);
        peaks.add(100);
        peaks.add(60);
        peaks.add(70);

        LinkedHashSet<String> conqueredPeaks = new LinkedHashSet<>();

        int days = 7;
        while (days-- > 0) {
            int food = foodPortionsStack.pop();
            int stamina = staminaQueue.poll();
            int sum = food + stamina;

            if (sum >= peaks.get(0)) {
                String conqueredPeak = mountainPeaks.get(peaks.get(0));
                conqueredPeaks.add(conqueredPeak);
                mountainPeaks.remove(peaks.get(0));
                peaks.remove(0);

                if (mountainPeaks.isEmpty()) {
                    System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
                    break;
                }
            }
        }

        if (!mountainPeaks.isEmpty()) {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if (!conqueredPeaks.isEmpty()) {
            System.out.println("Conquered peaks:");
            for (String peak : conqueredPeaks) {
                System.out.println(peak);
            }
        }
    }
}