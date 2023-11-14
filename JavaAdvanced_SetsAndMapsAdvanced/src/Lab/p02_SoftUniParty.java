package Lab;

import java.util.Scanner;
import java.util.TreeSet;

public class p02_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String guest = scanner.nextLine();
        TreeSet<String> vipGuests = new TreeSet<>();
        TreeSet<String> regularGuests = new TreeSet<>();

        while (!guest.equals("PARTY")) {
            char firstChar = guest.charAt(0);

            if (Character.isDigit(firstChar)) {
                vipGuests.add(guest);
            } else {
                regularGuests.add(guest);
            }

            guest = scanner.nextLine();
        }

        String comeGuests = scanner.nextLine();

        while (!comeGuests.equals("END")) {
            vipGuests.remove(comeGuests);
            regularGuests.remove(comeGuests);

            comeGuests = scanner.nextLine();
        }

        System.out.println(vipGuests.size() + regularGuests.size());
        for (String g : vipGuests) {
            System.out.println(g);
        }

        for (String g : regularGuests) {
            System.out.println(g);
        }
    }
}