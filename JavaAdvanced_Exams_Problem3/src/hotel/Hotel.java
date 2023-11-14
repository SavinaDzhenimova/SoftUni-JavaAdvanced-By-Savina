package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Person> getRoster() {
        return roster;
    }

    public void add(Person person) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name) {
        return this.roster.removeIf(p -> p.getName().equals(name));
    }

    public Person getPerson(String name, String hometown) {
        return this.roster.stream()
                .filter(p -> (p.getName().equals(name) && p.getHometown().equals(hometown)))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.roster.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The people in the hotel ").append(this.name).append(" are:").append(System.lineSeparator());
        this.roster.forEach(p -> sb.append(p.toString()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}