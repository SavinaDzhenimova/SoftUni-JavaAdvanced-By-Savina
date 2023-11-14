package Exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class p06_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        LinkedHashMap<String, String> people = new LinkedHashMap<>();

        while (!name.equals("stop")) {
            String email = scanner.nextLine();
            String[] emailArr = email.split("\\.");
            String ending = emailArr[emailArr.length - 1];

            if (!ending.equals("uk") && !ending.equals("us") && !ending.equals("com")) {
                people.put(name, email);
            }

            name = scanner.nextLine();
        }

        people.entrySet().stream().
                forEach(e -> System.out.printf("%s -> %s%n", e.getKey(), e.getValue()));
    }
}