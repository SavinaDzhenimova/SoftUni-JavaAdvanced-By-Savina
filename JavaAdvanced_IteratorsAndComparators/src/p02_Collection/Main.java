package p02_Collection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        ListyIterator listyIterator = new ListyIterator();
        while (!command.equals("END")) {
            String[] tokens = command.split("\\s+");

            switch (tokens[0]) {
                case "Create":
                    String[] elements = new String[tokens.length - 1];
                    System.arraycopy(tokens, 1, elements, 0, tokens.length - 1);
                    listyIterator = new ListyIterator(elements);
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch(IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "PrintAll":
                    listyIterator.forEach(e -> System.out.print(e + " "));
                    System.out.println();
                    break;
            }

            command = scanner.nextLine();
        }
    }
}