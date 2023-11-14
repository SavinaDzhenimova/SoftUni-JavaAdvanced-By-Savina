package p06_StrategyPattern;

import java.util.Comparator;

public class PersonComparatorByName implements Comparator<Person> {

    @Override
    public int compare(Person person, Person other) {
        int result = Integer.compare(person.getName().length(), other.getName().length());
        if (result == 0) {
            char firstName = person.getName().toLowerCase().charAt(0);
            char secondName = other.getName().toLowerCase().charAt(0);
            result = Character.compare(firstName, secondName);
        }
        return result;
    }
}