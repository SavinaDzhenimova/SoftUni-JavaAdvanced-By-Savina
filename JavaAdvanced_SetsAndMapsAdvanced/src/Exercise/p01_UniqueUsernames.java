package Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class p01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int linesCount = Integer.parseInt(scanner.nextLine());
        LinkedHashSet<String> usernamesSet = new LinkedHashSet<>();

        for (int i = 0; i < linesCount; i++) {
            String username = scanner.nextLine();

            usernamesSet.add(username);
        }

        for (String user : usernamesSet) {
            System.out.println(user);
        }
    }
}