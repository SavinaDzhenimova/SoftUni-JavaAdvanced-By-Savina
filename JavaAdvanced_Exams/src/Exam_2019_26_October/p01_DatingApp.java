package Exam_2019_26_October;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p01_DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] malesArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] femalesArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> femalesQueue = new ArrayDeque<>();
        for (int female : femalesArr) {
            femalesQueue.offer(female);
        }
        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        for (int male : malesArr) {
            malesStack.push(male);
        }

        int matches = 0;
        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {
            int male = malesStack.peek();
            int female = femalesQueue.peek();

            if (male % 25 == 0 && male > 0) {
                malesStack.pop();
                malesStack.pop();

                if (malesStack.isEmpty()) {
                    break;
                } else {
                    continue;
                }
            }

            if (female % 25 == 0 && female > 0) {
                femalesQueue.poll();
                femalesQueue.poll();

                if (femalesQueue.isEmpty()) {
                    break;
                } else {
                    continue;
                }
            }

            if (male > 0 && female > 0) {
                if (male == female) {
                    malesStack.pop();
                    matches++;
                } else {
                    male -= 2;
                    malesStack.pop();
                    if (male > 0) {
                        malesStack.push(male);
                    }
                }
                femalesQueue.poll();
            } else {
                if (female <= 0) {
                    femalesQueue.poll();
                }
                if (male <= 0) {
                    malesStack.pop();
                }
            }

        }

        System.out.println("Matches: " + matches);
        if (malesStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.println("Males left: " + malesStack.stream().map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }

        if (femalesQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.println("Females left: " + femalesQueue.stream().map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }
    }
}