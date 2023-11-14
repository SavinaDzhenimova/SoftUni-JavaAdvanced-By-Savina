package Exam_2021_14_April;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p01_Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tulipsArr = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] daffodilsArr = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        for (int tulip : tulipsArr) {
            tulipsStack.push(tulip);
        }
        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();
        for (int daffodil : daffodilsArr) {
            daffodilsQueue.offer(daffodil);
        }
        int bouquets = 0;
        int savedFlowers = 0;

        while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()) {
            int tulip = tulipsStack.pop();
            int daffodil = daffodilsQueue.poll();
            int sum = tulip + daffodil;

            if (sum == 15) {
                bouquets++;
            } else if (sum > 15) {
                while (tulip > 0) {
                    tulip -= 2;
                    sum = tulip + daffodil;

                    if (sum == 15) {
                        bouquets++;
                        break;
                    } else if (sum < 15) {
                        savedFlowers += sum;
                        break;
                    }
                }

            } else {
                savedFlowers += sum;
            }
        }

        bouquets += savedFlowers / 15;
        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!%n", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.%n", 5 - bouquets);
        }
    }
}