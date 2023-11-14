package Exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class p05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, String> phonebook = new LinkedHashMap<>();

        while (!input.equals("search")) {
            String[] data = input.split("-");
            String name = data[0];
            String phoneNumber = data[1];

            phonebook.put(name, phoneNumber);

            input = scanner.nextLine();
        }

        String searchName = scanner.nextLine();

        while (!searchName.equals("stop")) {
            if (phonebook.containsKey(searchName)) {
                System.out.printf("%s -> %s%n", searchName, phonebook.get(searchName));
            } else {
                System.out.printf("Contact %s does not exist.%n", searchName);
            }

            searchName = scanner.nextLine();
        }
    }
}