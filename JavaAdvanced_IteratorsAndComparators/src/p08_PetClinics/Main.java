package p08_PetClinics;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Pet> pets = new LinkedHashMap<>();
        Map<String, Clinic> clinics = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");

            switch (input[0]) {
                case "Create":
                    if (input[1].equals("Pet")) {
                        Pet pet = new Pet(input[2], Integer.parseInt(input[3]), input[4]);
                        pets.put(pet.getName(), pet);
                    } else {
                        try {
                            Clinic clinic = new Clinic(input[2], Integer.parseInt(input[3]));
                            clinics.put(clinic.getName(), clinic);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "Add":
                    System.out.println(clinics.get(input[2]).addPet(pets.get(input[1])));
                    break;
                case "Release":
                    System.out.println(clinics.get(input[1]).release());
                    break;
                case "HasEmptyRooms":
                    System.out.println(clinics.get(input[1]).hasEmptyRooms());
                    break;
                case "Print":
                    if (input.length == 2) {
                        clinics.get(input[1]).printAllRooms();
                    } else {
                        clinics.get(input[1]).printRoom(Integer.parseInt(input[2]));
                    }
                    break;
            }
        }
    }
}