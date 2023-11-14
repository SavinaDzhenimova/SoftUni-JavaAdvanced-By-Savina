package christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return this.color;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.data.size() < this.capacity) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(p -> p.getName().equals(name));
    }

    public Present heaviestPresent() {
        return this.data.stream().max(Comparator.comparingDouble(Present::getWeight)).orElse(null);
    }

    public Present getPresent(String name) {
        return this.data.stream().filter(p -> p.getName().equals(name)).findAny().orElse(null);
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.color).append(" bag contains:").append(System.lineSeparator());
        this.data.forEach(p -> sb.append(p.toString()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}