package p06_StrategyPattern;

import java.util.Comparator;

public class PersonComparatorByAge implements Comparator<Person> {

    @Override
    public int compare(Person person, Person other) {
        return Integer.compare(person.getAge(), other.getAge());
    }
}