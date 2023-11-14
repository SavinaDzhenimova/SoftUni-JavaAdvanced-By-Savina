package sanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Habitat {
    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant) {
        if (this.data.size() < this.capacity) {
            this.data.add(elephant);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(e -> e.getName().equals(name));
    }

    public Elephant getElephant(String retiredFrom) {
        return this.data.stream().filter(e -> e.getRetiredFrom().equals(retiredFrom)).findFirst().orElse(null);
    }

    public Elephant getOldestElephant() {
        return this.data.stream().max(Comparator.comparingInt(Elephant::getAge)).orElse(null);
    }

    public int getAllElephants() {
        return this.data.size();
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Saved elephants in the park:").append(System.lineSeparator());
        this.data.forEach(e ->
                sb.append(e.getName()).append(" came from: ").append(e.getRetiredFrom()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}