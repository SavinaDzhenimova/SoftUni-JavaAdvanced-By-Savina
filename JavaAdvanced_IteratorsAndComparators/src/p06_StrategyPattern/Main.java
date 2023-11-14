package p06_StrategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scanner.nextLine());
        TreeSet<Person> peopleNameSet = new TreeSet<>(new PersonComparatorByName());
        TreeSet<Person> peopleAgeSet = new TreeSet<>(new PersonComparatorByAge());

        for (int i = 0; i < peopleCount; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person person = new Person(name, age);
            peopleNameSet.add(person);
            peopleAgeSet.add(person);
        }

        for (Person person : peopleNameSet) {
            System.out.println(person);
        }
        for (Person person : peopleAgeSet) {
            System.out.println(person);
        }
    }
}