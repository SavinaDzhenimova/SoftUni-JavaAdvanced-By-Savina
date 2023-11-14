package halloween;

import java.util.ArrayList;
import java.util.List;

public class House {
    private int capacity;
    private List<Kid> data;

    public House(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addKid(Kid kid) {
        if (this.data.size() < this.capacity) {
            this.data.add(kid);
        }
    }

    public boolean removeKid(String name) {
        return this.data.removeIf(k -> k.getName().equals(name));
    }

    public Kid getKid(String street) {
        return this.data.stream().filter(k -> k.getStreet().equals(street)).findAny().orElse(null);
    }

    public int getAllKids() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Children who visited a house for candy:").append(System.lineSeparator());
        this.data.forEach(k -> sb.append(String.format("%s from %s street", k.getName(), k.getStreet()))
                .append(System.lineSeparator()));
        return sb.toString().trim();
    }
}