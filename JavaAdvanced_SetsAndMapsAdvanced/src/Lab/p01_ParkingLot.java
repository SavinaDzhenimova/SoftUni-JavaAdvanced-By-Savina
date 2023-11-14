package Lab;

import javax.crypto.spec.PSource;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class p01_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] tokens = input.split(",\\s+");
            String direction = tokens[0];
            String registration = tokens[1];

            if (direction.equals("IN")) {
                parkingLot.add(registration);
            } else {
                parkingLot.remove(registration);
            }

            input = scanner.nextLine();
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String reg : parkingLot) {
                System.out.println(reg);
            }
        }
    }
}