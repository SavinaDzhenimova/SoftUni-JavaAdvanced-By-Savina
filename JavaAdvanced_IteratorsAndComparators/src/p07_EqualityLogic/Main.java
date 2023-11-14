package p07_EqualityLogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scanner.nextLine());
        TreeSet<Person> peopleTreeSet = new TreeSet<>();
        HashSet<Person> peopleHashSet = new HashSet<>();

        for (int i = 0; i < peopleCount; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person person = new Person(name, age);
            peopleTreeSet.add(person);
            peopleHashSet.add(person);
        }

        System.out.println(peopleTreeSet.size());
        System.out.println(peopleHashSet.size());
    }
}