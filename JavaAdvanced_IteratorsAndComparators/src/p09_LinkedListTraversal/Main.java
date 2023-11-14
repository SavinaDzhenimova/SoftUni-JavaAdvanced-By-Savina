package p09_LinkedListTraversal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandsCount = Integer.parseInt(scanner.nextLine());
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < commandsCount; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            int number = Integer.parseInt(tokens[1]);

            switch (command) {
                case "Add":
                    linkedList.add(number);
                    break;
                case "Remove":
                    linkedList.remove(number);
                    break;
            }
        }

        System.out.println(linkedList.getSize());
        linkedList.forEach(e -> System.out.print(e + " "));
    }
}