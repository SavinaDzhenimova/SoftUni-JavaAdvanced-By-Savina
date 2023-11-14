package p07_CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        CustomList<String> stringCustomList = new CustomList<>();

        while (!command.equals("END")) {
            String[] tokens = command.split("\\s+");
            String element;

            switch (tokens[0]) {
                case "Add":
                    element = tokens[1];
                    stringCustomList.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(tokens[1]);
                    stringCustomList.remove(index);
                    break;
                case "Contains":
                    element = tokens[1];
                    System.out.println(stringCustomList.contains(element));
                    break;
                case "Swap":
                    int index1 = Integer.parseInt(tokens[1]);
                    int index2 = Integer.parseInt(tokens[2]);
                    stringCustomList.swap(index1, index2);
                    break;
                case "Greater":
                    element = tokens[1];
                    System.out.println(stringCustomList.countGreaterThan(element));
                    break;
                case "Max":
                    System.out.println(stringCustomList.getMax());
                    break;
                case "Min":
                    System.out.println(stringCustomList.getMin());
                    break;
                case "Print":
                    stringCustomList.print();
                    break;
            }

            command = scanner.nextLine();
        }
    }
}