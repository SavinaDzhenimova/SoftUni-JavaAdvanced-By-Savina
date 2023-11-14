package Exam_2021_26_June;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p01_OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tasksArr = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] threadsArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int taskToKill = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> threadsQueue = new ArrayDeque<>();
        for (int t : threadsArr) {
            threadsQueue.offer(t);
        }
        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        for (int task : tasksArr) {
            tasksStack.push(task);
        }

        while (!threadsQueue.isEmpty() && !tasksStack.isEmpty()) {
            int thread = threadsQueue.peek();
            int task = tasksStack.peek();

            if (task == taskToKill) {
                System.out.printf("Thread with value %d killed task %d%n", thread, taskToKill);
                break;
            } else {
                threadsQueue.poll();
                if (thread >= task) {
                    tasksStack.pop();
                }
            }
        }

        for (int t : threadsQueue) {
            System.out.print(t + " ");
        }
    }
}